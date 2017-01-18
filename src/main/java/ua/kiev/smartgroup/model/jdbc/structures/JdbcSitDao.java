package ua.kiev.smartgroup.model.jdbc.structures;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ua.kiev.smartgroup.Main;
import ua.kiev.smartgroup.model.dao.SitDao;
import ua.kiev.smartgroup.model.jdbc.baseStructures.JdbcBaseTableDao;
import ua.kiev.smartgroup.model.tables.Sit;

import javax.sql.DataSource;
import java.sql.*;

/**
 * Created by SleepWalker on 18.01.2017.
 */
public class JdbcSitDao extends JdbcBaseTableDao implements SitDao {

    private DataSource newDataSource;

    public static final Logger LOGGER = LoggerFactory.getLogger(Main.class);

    @Override
    public void addNewSit(int id, String name, int idOffice, int idEmployee) {
        LOGGER.info("Connecting to database");

        try (Connection connection = newDataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement("INSERT INTO SIT VALUES(?,?,?,?)")){

            LOGGER.info("Successfully connected to database");

            statement.setInt(1, id);
            statement.setString(2, name);

            if (idOffice > 0){
                statement.setInt(3,idOffice);
            } else {

                statement.setNull(3, Types.INTEGER);
            }

            if (idEmployee > 0){

                statement.setInt(4,idEmployee);
            } else {

                statement.setNull(4, Types.INTEGER);
            }

            statement.executeUpdate();


        } catch (SQLException exception) {
            LOGGER.error("Exception occurred while connecting to database: ", exception);
            throw new RuntimeException(exception);
        }
    }

    @Override
    public void modify(int id, String name, int idOffice, int idEmployee) {

        LOGGER.info("Connecting to database");

        try (Connection connection = newDataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement("UPDATE SIT SET NAME = ?, ID_OFFICE = ?," +
                     "ID_EMPLOYEE = ? WHERE ID = ?")) {

            LOGGER.info("Successfully connected to database");

            statement.setString(1, name);

            if(idOffice > 0){

                statement.setInt(2, idOffice);
            }else {

                statement.setNull(2, Types.INTEGER);
            }

            if (idEmployee > 0){

                statement.setInt(3,idEmployee);
            } else {

                statement.setNull(3, Types.INTEGER);
            }

            statement.setInt(4, id);

            statement.executeUpdate();
        }catch (SQLException exception) {
            LOGGER.error("Exception occurred while connecting to database: ", exception);
            throw new RuntimeException(exception);
        }
    }

    public void setNewDataSource(DataSource newDataSource) {
        this.newDataSource = newDataSource;
    }

    @Override
    public Sit createTable(ResultSet resultSet) throws SQLException {

        Sit sit = new Sit();

        sit.setId(resultSet.getInt("ID"));
        sit.setName(resultSet.getString("NAME"));
        sit.setIdEmployee(resultSet.getInt("ID_OFFICE"));
        sit.setIdEmployee(resultSet.getInt("ID_EMPLOYEE"));
        return sit;

    }
}
