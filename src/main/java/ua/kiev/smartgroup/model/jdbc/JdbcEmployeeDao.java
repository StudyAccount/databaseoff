package ua.kiev.smartgroup.model.jdbc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ua.kiev.smartgroup.Main;
import ua.kiev.smartgroup.model.Employee;
import ua.kiev.smartgroup.model.EmployeeDao;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by User on 13.12.2016.
 */
public class JdbcEmployeeDao implements EmployeeDao {

    private DataSource dataSource;

    public static final Logger LOGGER = LoggerFactory.getLogger(Main.class);
//    private String url = "jdbc:postgresql://localhost:5432/company";
//    private String user = "Viktor";
//    private String password  = "pass";

    public JdbcEmployeeDao(){
        loadDriver();
    }

    @Override
    public Employee load(int id){
        Employee employee = null;
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
    public List<Employee> getAll(){

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

    private Employee createEmployee(ResultSet resultSet) throws SQLException {
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
        return employee;
    }

    private void loadDriver() {
        try {
            LOGGER.info("Loading JDBC driver: org.postgresql.Driver");
            Class.forName("org.postgresql.Driver");
            LOGGER.info("Driver loaded successfully");
        } catch (ClassNotFoundException e) {
            LOGGER.error("Cannot find driver: org.postgresql.Driver");
            throw new RuntimeException(e);
        }
    }

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }
}
