package ua.kiev.smartgroup.model.jdbc.structures;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ua.kiev.smartgroup.Main;
import ua.kiev.smartgroup.model.dao.MonitorDao;
import ua.kiev.smartgroup.model.jdbc.baseStructures.JdbcBaseTableDao;
import ua.kiev.smartgroup.model.tables.Monitor;

import javax.sql.DataSource;
import java.sql.*;

/**
 * Created by SleepWalker on 18.01.2017.
 */
public class JdbcMonitorDao extends JdbcBaseTableDao implements MonitorDao{

    private DataSource newDataSource;

    public static final Logger LOGGER = LoggerFactory.getLogger(Main.class);

    @Override
    public void addNewMonitor(int id, String name, int idMonitorModel, String dateOfIncome, float priceInUSD,
                              float priceInUAH, int idEmployee) {
        LOGGER.info("Connecting to database");

        try (Connection connection = newDataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement("INSERT INTO MONITOR VALUES(?,?,?,?,?,?,?)")){

            LOGGER.info("Successfully connected to database");

            statement.setInt(1, id);
            statement.setString(2, name);

            if (idMonitorModel > 0){
                statement.setInt(3,idMonitorModel);
            } else {

                statement.setNull(3, Types.INTEGER);
            }

            statement.setString(4, dateOfIncome);
            statement.setFloat(5, priceInUSD);
            statement.setFloat(6,priceInUAH);

            if (idEmployee > 0){

                statement.setInt(7,idEmployee);
            } else {

                statement.setNull(7, Types.INTEGER);
            }

            statement.executeUpdate();


        } catch (SQLException exception) {
            LOGGER.error("Exception occurred while connecting to database: ", exception);
            throw new RuntimeException(exception);
        }
    }

    @Override
    public void modify(int id, String name, int idMonitorModel, String dateOfIncome, float priceInUSD,
                       float priceInUAH, int idEmployee) {

        LOGGER.info("Connecting to database");

        try (Connection connection = newDataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement("UPDATE MONITOR SET NAME = ?, ID_MONITOR_MODEL = ?," +
                     "DATE_OF_INCOME = ?, PRICE_IN_USD = ?, PRICE_IN_UAH = ?, ID_EMPLOYEE = ? WHERE ID = ?")) {

            LOGGER.info("Successfully connected to database");

            statement.setString(1, name);

            if(idMonitorModel > 0){

                statement.setInt(2, idMonitorModel);
            }else {

                statement.setNull(2, Types.INTEGER);
            }

            statement.setString(3, dateOfIncome);
            statement.setFloat(4, priceInUSD);
            statement.setFloat(5,priceInUAH);

            if (idEmployee > 0){

                statement.setInt(6,idEmployee);
            } else {

                statement.setNull(6, Types.INTEGER);
            }

            statement.setInt(7, id);

            statement.executeUpdate();
        }catch (SQLException exception) {
            LOGGER.error("Exception occurred while connecting to database: ", exception);
            throw new RuntimeException(exception);
        }

    }

    @Override
    public Monitor createTable(ResultSet resultSet) throws SQLException {

        Monitor monitor = new Monitor();

        monitor.setId(resultSet.getInt("ID"));
        monitor.setName(resultSet.getString("NAME"));
        monitor.setIdMonitorModel(resultSet.getInt("ID_MONITOR_MODEL"));
        monitor.setDateOfIncome(resultSet.getString("DATE_OF_INCOME"));
        monitor.setPriceInUSD(resultSet.getFloat("PRICE_IN_USD"));
        monitor.setPriceInUAH(resultSet.getFloat("PRICE_IN_UAH"));
        monitor.setIdEmployee(resultSet.getInt("ID_EMPLOYEE"));

        return monitor;
    }

    public void setNewDataSource(DataSource newDataSource) {
        this.newDataSource = newDataSource;
    }
}
