package ua.kiev.smartgroup.model.jdbc.structures;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ua.kiev.smartgroup.Main;
import ua.kiev.smartgroup.model.jdbc.baseStructures.JdbcBaseTableDao;
import ua.kiev.smartgroup.model.tables.Computer;
import ua.kiev.smartgroup.model.dao.ComputerDao;

import javax.sql.DataSource;
import java.sql.*;

/**
 * Created by SleepWalker on 03.01.2017.
 */
public class JdbcComputerDao extends JdbcBaseTableDao implements ComputerDao {

    private DataSource newDataSource;

    public static final Logger LOGGER = LoggerFactory.getLogger(Main.class);

    @Override
    public void addNewComputer(int id, String name, int idMotherboard, String ram, String dateOfIncome,
                               float priceInUSD, float priceInUAH, int idEmployee) {
        LOGGER.info("Connecting to database");

        try (Connection connection = newDataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement("INSERT INTO COMPUTER VALUES(?,?,?,?,?,?,?,?)")){

            LOGGER.info("Successfully connected to database");

            statement.setInt(1, id);
            statement.setString(2, name);

            if (idMotherboard > 0){
                statement.setInt(3,idMotherboard);
            } else {

                statement.setNull(3, Types.INTEGER);
            }

            statement.setString(4, ram);
            statement.setString(5, dateOfIncome);
            statement.setFloat(6, priceInUSD);
            statement.setFloat(7,priceInUAH);

            if (idEmployee > 0){

                statement.setInt(8,idEmployee);
            } else {

                statement.setNull(8, Types.INTEGER);
            }

            statement.executeUpdate();


        } catch (SQLException exception) {
            LOGGER.error("Exception occurred while connecting to database: ", exception);
            throw new RuntimeException(exception);
        }
    }

    @Override
    public void modify(int id, String name, int idMotherboard, String ram, String dateOfIncome,
                       float priceInUSD, float priceInUAH, int idEmployee) {

        try (Connection connection = newDataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement("UPDATE COMPUTER SET NAME = ?, ID_MOTHERBOARD = ?," +
                     "RAM = ?, DATE_OF_INCOME = ?, PRICE_IN_USD = ?, PRICE_IN_UAH = ?, ID_EMPLOYEE = ? WHERE ID = ?")) {

            LOGGER.info("Successfully connected to database");

            statement.setString(1, name);

            if(idMotherboard > 0){

                statement.setInt(2, idMotherboard);
            }else {

                statement.setNull(2, Types.INTEGER);
            }

            statement.setString(3, ram);
            statement.setString(4, dateOfIncome);
            statement.setFloat(5, priceInUSD);
            statement.setFloat(6,priceInUAH);

            if (idEmployee > 0){

                statement.setInt(7,idEmployee);
            } else {

                statement.setNull(7, Types.INTEGER);
            }

            statement.setInt(8, id);

            statement.executeUpdate();
        }catch (SQLException exception) {
            LOGGER.error("Exception occurred while connecting to database: ", exception);
            throw new RuntimeException(exception);
        }


    }

    @Override
    public Computer createTable(ResultSet resultSet) throws SQLException {
        Computer computer = new Computer();

        computer.setId(resultSet.getInt("ID"));
        computer.setName(resultSet.getString("NAME"));
        computer.setIdMotherboard(resultSet.getInt("ID_MOTHERBOARD"));
        computer.setRam(resultSet.getString("RAM"));
        computer.setDateOfIncome(resultSet.getString("DATE_OF_INCOME"));
        computer.setPriceInUSD(resultSet.getFloat("PRICE_IN_USD"));
        computer.setPriceInUAH(resultSet.getFloat("PRICE_IN_UAH"));
        computer.setIdEmployee(resultSet.getInt("ID_EMPLOYEE"));

        return computer;
    }

    public void setNewDataSource(DataSource dataSource) {
        this.newDataSource = dataSource;
    }

}
