package ua.kiev.smartgroup.model.jdbc.structures;

import ua.kiev.smartgroup.model.jdbc.baseStructures.JdbcSmallTableDao;
import ua.kiev.smartgroup.model.tables.BaseTable;
import ua.kiev.smartgroup.model.tables.Status;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by SleepWalker on 18.01.2017.
 */
public class JdbcStatusDao extends JdbcSmallTableDao {

    @Override
    public BaseTable createTable(ResultSet resultSet) throws SQLException {

        Status status = new Status();

        status.setId(resultSet.getInt("ID"));
        status.setName(resultSet.getString("NAME"));

        return status;
    }
}
