package ua.kiev.smartgroup.model.jdbc.structures;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ua.kiev.smartgroup.Main;
import ua.kiev.smartgroup.model.dao.RiskManagerDao;
import ua.kiev.smartgroup.model.jdbc.baseStructures.JdbcBaseTableDao;
import ua.kiev.smartgroup.model.tables.BaseTable;
import ua.kiev.smartgroup.model.tables.RiskManager;

import javax.sql.DataSource;
import java.sql.*;

/**
 * Created by SleepWalker on 18.01.2017.
 */
public class JdbcRiskManagerDao extends JdbcBaseTableDao implements RiskManagerDao {

    private DataSource newDataSource;

    public static final Logger LOGGER = LoggerFactory.getLogger(Main.class);

    @Override
    public void addNewRiskManager(int id, int idEmployee) {

        LOGGER.info("Connecting to database");

        try (Connection connection = newDataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement("INSERT INTO RISK_MANAGER VALUES(?,?)")){

            LOGGER.info("Successfully connected to database");

            statement.setInt(1, id);

            if (idEmployee > 0){

                statement.setInt(2,idEmployee);
            } else {

                statement.setNull(2, Types.INTEGER);
            }

            statement.executeUpdate();


        } catch (SQLException exception) {
            LOGGER.error("Exception occurred while connecting to database: ", exception);
            throw new RuntimeException(exception);
        }
    }

    @Override
    public void modify(int id, int idEmployee) {

        LOGGER.info("Connecting to database");

        try (Connection connection = newDataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement("UPDATE RISK_MANAGER SET ID_EMPLOYEE = ? WHERE ID = ?")) {

            LOGGER.info("Successfully connected to database");

            if(idEmployee > 0){

                statement.setInt(1, idEmployee);
            }else {

                statement.setNull(1, Types.INTEGER);
            }

            statement.setInt(2, id);

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
    public RiskManager createTable(ResultSet resultSet) throws SQLException {

        RiskManager riskManager = new RiskManager();

        riskManager.setId(resultSet.getInt("ID"));
        riskManager.setIdEmployee(resultSet.getInt("ID_EMPLOYEE"));

        return riskManager;
    }
}
