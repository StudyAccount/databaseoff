package ua.kiev.smartgroup.model.jdbc.structures;

import ua.kiev.smartgroup.model.jdbc.baseStructures.JdbcSmallTableDao;
import ua.kiev.smartgroup.model.tables.BaseTable;
import ua.kiev.smartgroup.model.tables.Office;
import ua.kiev.smartgroup.model.tables.Status;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by SleepWalker on 18.01.2017.
 */
public class JdbcOfficeDao extends JdbcSmallTableDao{

    @Override
    public BaseTable createTable(ResultSet resultSet) throws SQLException {

        Office office = new Office();

        office.setId(resultSet.getInt("ID"));
        office.setName(resultSet.getString("NAME"));

        return office;
    }
}
