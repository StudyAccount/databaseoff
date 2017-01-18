package ua.kiev.smartgroup.model.jdbc.structures;

import ua.kiev.smartgroup.model.jdbc.baseStructures.JdbcSmallTableDao;
import ua.kiev.smartgroup.model.tables.Hardware;
import ua.kiev.smartgroup.model.tables.Hdd;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by SleepWalker on 03.01.2017.
 */
public class JdbcHddDao extends JdbcSmallTableDao {

    @Override
    public Hardware createTable(ResultSet resultSet) throws SQLException {
        Hardware hdd = new Hdd();

        hdd.setId(resultSet.getInt("ID"));
        hdd.setName(resultSet.getString("NAME"));

        return hdd;
    }
}
