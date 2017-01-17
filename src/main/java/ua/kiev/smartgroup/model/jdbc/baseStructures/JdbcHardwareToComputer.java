package ua.kiev.smartgroup.model.jdbc.baseStructures;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ua.kiev.smartgroup.Main;
import ua.kiev.smartgroup.model.tables.ForeignTable;
import ua.kiev.smartgroup.model.dao.SupportHardwareTableDao;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by SleepWalker on 17.01.2017.
 */
public class JdbcHardwareToComputer implements SupportHardwareTableDao {

    private String tableName;
    private DataSource dataSource;
    private String hardwareId;

    private static final Logger LOGGER = LoggerFactory.getLogger(Main.class);
    @Override
    public void newEntry(int idComputer, int idHardware) {

        LOGGER.info("Connecting to database");

        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement("INSERT INTO " + tableName + " VALUES(?,?)")){

            LOGGER.info("Successfully connected to database");

            statement.setInt(1, idComputer);
            statement.setInt(2, idHardware);

            statement.executeUpdate();


        } catch (SQLException exception) {
            LOGGER.error("Exception occurred while connecting to database: ", exception);
            throw new RuntimeException(exception);
        }

    }

    @Override
    public void deleteEntry(int idComputer) {
        LOGGER.info("Connecting to database");

        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement("DELETE FROM " + tableName + " WHERE  ID_COMPUTER=?")) {

            statement.setInt(1, idComputer);
            statement.executeUpdate();

        }catch (SQLException exception) {
            LOGGER.error("Exception occurred while connecting to database: ", exception);
            throw new RuntimeException(exception);
        }
    }

    @Override
    public void modify(int idComputer, int idHardware) {
        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement("UPDATE " + tableName + " SET " + hardwareId + " = ? WHERE ID_COMPUTER = ?")) {

            LOGGER.info("Successfully connected to database");

            statement.setInt(1, idComputer);
            statement.setInt(2, idHardware);
            statement.executeUpdate();
        }catch (SQLException exception) {
            LOGGER.error("Exception occurred while connecting to database: ", exception);
            throw new RuntimeException(exception);
        }
    }

    @Override
    public ForeignTable loadByComputerId(int idComputer) {

        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement("SELECT * FROM " + tableName + " WHERE ID_COMPUTER = ?")){

            statement.setInt(1, idComputer);
            ResultSet resultSet = statement.executeQuery();

            if(resultSet.next()){
                return createTable(resultSet);
            }else {

                throw new RuntimeException("Cannot not find hardware wit id " + idComputer);
            }


        } catch (SQLException exception) {
            LOGGER.error("Exception occurred while connecting to database: ", exception);
            throw new RuntimeException(exception);
        }
    }

    public ForeignTable createTable(ResultSet resultSet) throws SQLException{
        return new ForeignTable();
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public void setHardwareId(String hardwareId) {
        this.hardwareId = hardwareId;
    }
}
