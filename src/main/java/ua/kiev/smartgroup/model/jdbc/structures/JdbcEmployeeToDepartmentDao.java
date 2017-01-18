package ua.kiev.smartgroup.model.jdbc.structures;

import ua.kiev.smartgroup.model.jdbc.baseStructures.JdbcForeignToBaseTablesDao;
import ua.kiev.smartgroup.model.tables.EmployeeToDepartment;
import ua.kiev.smartgroup.model.tables.ForeignTable;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by SleepWalker on 18.01.2017.
 */
public class JdbcEmployeeToDepartmentDao extends JdbcForeignToBaseTablesDao {


    @Override
    public ForeignTable createTable(ResultSet resultSet) throws SQLException {

        EmployeeToDepartment employeeToDepartment = new EmployeeToDepartment();

        employeeToDepartment.setIdEmployee(resultSet.getInt("ID_EMPLOYEE"));
        employeeToDepartment.setIdDepartment(resultSet.getInt("ID_DEPARTMENT"));

        return employeeToDepartment;
    }
}
