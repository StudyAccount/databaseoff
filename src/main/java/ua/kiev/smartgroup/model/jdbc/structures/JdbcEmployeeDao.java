package ua.kiev.smartgroup.model.jdbc.structures;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ua.kiev.smartgroup.Main;
import ua.kiev.smartgroup.model.jdbc.baseStructures.JdbcBaseTableDao;
import ua.kiev.smartgroup.model.tables.Employee;
import ua.kiev.smartgroup.model.dao.EmployeeDao;

import javax.sql.DataSource;
import java.sql.*;

/**
 * Created by User on 13.12.2016.
 */
public class JdbcEmployeeDao extends JdbcBaseTableDao implements EmployeeDao {

    private DataSource newDataSource;


    public static final Logger LOGGER = LoggerFactory.getLogger(Main.class);

    @Override
    public void addNewEmployee(int id, int idStatus, String lastName, String name, String phone,
                                   String email, String address, String dateOfBirth, String dateOfSigningAContract,
                                   String dateOfFirstTrade, int idRiskManager) {

        LOGGER.info("Connecting to database");

        try (Connection connection = newDataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement("INSERT INTO EMPLOYEE VALUES(?,?,?,?,?,?,?,?,?,?,?)")){

            LOGGER.info("Successfully connected to database");

            statement.setInt(1, id);

            if (idStatus > 0) {
                statement.setInt(2, idStatus);
            } else {
                statement.setNull(2, Types.INTEGER);
            }

            statement.setString(3, lastName);
            statement.setString(4, name);
            statement.setString(5, phone);
            statement.setString(6, email);
            statement.setString(7, address);
            statement.setString(8, dateOfBirth);
            statement.setString(9, dateOfSigningAContract);
            statement.setString(10, dateOfFirstTrade);

            if (idRiskManager > 0) {
                statement.setInt(11, idRiskManager);
            } else {
                statement.setNull(11, Types.INTEGER);
            }

            statement.executeUpdate();


        } catch (SQLException exception) {
            LOGGER.error("Exception occurred while connecting to database: ", exception);
            throw new RuntimeException(exception);
        }
    }

    @Override
    public void modify(int id, int idStatus, String lastName, String name, String phone,
                       String email, String address, String dateOfBirth, String dateOfSigningAContract,
                       String dateOfFirstTrade, int idRiskManager) {

        try (Connection connection = newDataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement("UPDATE EMPLOYEE SET ID_STATUS =?, LAST_NAME=?, " +
                     "NAME=?, PHONE=?, EMAIL=?, ADDRESS=?, DATE_OF_BIRTH=?, DATE_OF_SIGNING_A_CONTRACT=?, " +
                     "DATE_OF_FIRST_TRADE=?, ID_RISKMANAGER=? WHERE ID = ?")) {

            LOGGER.info("Successfully connected to database");

            if (idStatus > 0) {
                statement.setInt(1,idStatus);
            } else {
                statement.setNull(1, Types.INTEGER);
            }

            statement.setString(2, lastName);
            statement.setString(3, name);
            statement.setString(4, phone);
            statement.setString(5, email);
            statement.setString(6, address);
            statement.setString(7, dateOfBirth);
            statement.setString(8, dateOfSigningAContract);
            statement.setString(9, dateOfFirstTrade);

            if (idRiskManager > 0) {
                statement.setInt(10, idRiskManager);
            } else {
                statement.setNull(10, Types.INTEGER);
            }

            statement.setInt(11, id);
            statement.executeUpdate();

        }catch (SQLException exception) {
            LOGGER.error("Exception occurred while connecting to database: ", exception);
            throw new RuntimeException(exception);
        }


    }

    @Override
    public Employee createTable(ResultSet resultSet) throws SQLException {
        Employee employee = new Employee();

        employee.setId(resultSet.getInt("ID"));
        employee.setIdStatus(resultSet.getInt("ID_STATUS"));
        employee.setLastName(resultSet.getString("LAST_NAME"));
        employee.setName(resultSet.getString("NAME"));
        employee.setPhone(resultSet.getString("PHONE"));
        employee.setEmail(resultSet.getString("EMAIL"));
        employee.setAddress(resultSet.getString("ADDRESS"));
//                employee.setDateOfBirth(LocalDateTime.from(resultSet.getDate("DATE_OF_BIRTH").toLocalDate()));
//                employee.setDateOfSigningAContract(LocalDateTime.from(resultSet.getDate("DATE_OF_SIGNING_A_CONTRACT").toLocalDate()));
//                employee.setDateOfFirstTrade(LocalDateTime.from(resultSet.getDate("DATE_OF_FIRST_TRADE").toLocalDate()));
        employee.setDateOfBirth(resultSet.getString("DATE_OF_BIRTH"));
        employee.setDateOfSigningAContract(resultSet.getString("DATE_OF_SIGNING_A_CONTRACT"));
        employee.setDateOfSigningAContract(resultSet.getString("DATE_OF_FIRST_TRADE"));
        return employee;
    }


    public void setNewDataSource(DataSource dataSource) {
        this.newDataSource = dataSource;
    }

}
