package ua.kiev.smartgroup.model.jdbc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ua.kiev.smartgroup.Main;
import ua.kiev.smartgroup.model.Computer;
import ua.kiev.smartgroup.model.dao.ComputerDao;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by SleepWalker on 03.01.2017.
 */
public class JdbcComputerDao implements ComputerDao {

    private DataSource dataSource;

    public static final Logger LOGGER = LoggerFactory.getLogger(Main.class);

    @Override
    public List<Computer> loadAllComputers() {

        LOGGER.info("Connecting to database");
        List<Computer> result = new ArrayList<>();

        try (Connection connection = dataSource.getConnection();
             Statement statement = connection.createStatement()){

            LOGGER.info("Successfully connected to database");

            String sql = "SELECT * FROM COMPUTER";

            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()){
                Computer computer = createComputer(resultSet);
                result.add(computer);
            }

        } catch (SQLException exception) {
            LOGGER.error("Exception occurred while connecting to database: ", exception);
            throw new RuntimeException(exception);
        }

        return result;

    }

    @Override
    public Computer loadComputerByID(int id) {
        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement("SELECT * FROM COMPUTER WHERE ID = ?")){

            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();

            if(resultSet.next()){

                return createComputer(resultSet);
            }else {

                throw new RuntimeException("Cannot not find computer wit id " + id);
            }


        } catch (SQLException exception) {
            LOGGER.error("Exception occurred while connecting to database: ", exception);
            throw new RuntimeException(exception);
        }
    }

    @Override
    public void addNewComputer(int id, String name, int idMotherboard, String ram, String dateOfIncome,
                               float priceInUSD, float priceInUAH, int idEmployee) {
        LOGGER.info("Connecting to database");

        try (Connection connection = dataSource.getConnection();
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
    public void deleteComputer(int id) {

        LOGGER.info("Connecting to database");

        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement("DELETE FROM COMPUTER WHERE ID=?")) {

            statement.setInt(1, id);
            statement.executeUpdate();

        }catch (SQLException exception) {
            LOGGER.error("Exception occurred while connecting to database: ", exception);
            throw new RuntimeException(exception);
        }

    }

    @Override
    public void modify(int id, String name, int idMotherboard, String ram, String dateOfIncome,
                       float priceInUSD, float priceInUAH, int idEmployee) {

        try (Connection connection = dataSource.getConnection();
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

    private Computer createComputer(ResultSet resultSet) throws SQLException {
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

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }
}
