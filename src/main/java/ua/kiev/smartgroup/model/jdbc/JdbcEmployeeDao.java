package ua.kiev.smartgroup.model.jdbc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import ua.kiev.smartgroup.Main;
import ua.kiev.smartgroup.model.Employee;
import ua.kiev.smartgroup.model.dao.EmployeeDao;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by User on 13.12.2016.
 */
public class JdbcEmployeeDao implements EmployeeDao {

    private DataSource dataSource;
    private Employee employee;


    public static final Logger LOGGER = LoggerFactory.getLogger(Main.class);

    @Override
    @Transactional(propagation = Propagation.MANDATORY)
    public Employee loadEmployee(int id){

        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement("SELECT * FROM EMPLOYEE WHERE ID = ?")){

            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();

            if(resultSet.next()){

                return createEmployee(resultSet);
            }else {

                throw new RuntimeException("Cannot not find employee wit id " + id);
            }


        } catch (SQLException exception) {
            LOGGER.error("Exception occurred while connecting to database: ", exception);
            throw new RuntimeException(exception);
        }

    }

    @Override
    @Transactional(propagation = Propagation.MANDATORY)
    public List<Employee> getAllEmployees(){

        LOGGER.info("Connecting to database");
        List<Employee> result = new ArrayList<>();

        try (Connection connection = dataSource.getConnection();
             Statement statement = connection.createStatement()){

            LOGGER.info("Successfully connected to database");

            String sql = "SELECT * FROM EMPLOYEE";

            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()){
                Employee employee = createEmployee(resultSet);
                result.add(employee);
            }

        } catch (SQLException exception) {
            LOGGER.error("Exception occurred while connecting to database: ", exception);
            throw new RuntimeException(exception);
        }

        return result;

    }


    @Override
    public Employee addNewEmployee() {
        return null;
    }

    @Override
    public Employee deleteEmployee() {
        return null;
    }

    @Override
    public Employee modify() {
        return null;
    }

    private Employee createEmployee(ResultSet resultSet) throws SQLException {

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
        return employee;
    }


    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
}
