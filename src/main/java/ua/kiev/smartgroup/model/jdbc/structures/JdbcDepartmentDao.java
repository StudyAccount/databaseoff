package ua.kiev.smartgroup.model.jdbc.structures;

import ua.kiev.smartgroup.model.jdbc.baseStructures.JdbcSmallTableDao;
import ua.kiev.smartgroup.model.tables.BaseTable;
import ua.kiev.smartgroup.model.tables.Department;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by SleepWalker on 18.01.2017.
 */
public class JdbcDepartmentDao extends JdbcSmallTableDao {

    @Override
    public BaseTable createTable(ResultSet resultSet) throws SQLException {

        Department department = new Department();

        department.setId(resultSet.getInt("ID"));
        department.setName(resultSet.getString("NAME"));

        return department;
    }
}
