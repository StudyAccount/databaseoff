package ua.kiev.smartgroup.model.jdbc;

import ua.kiev.smartgroup.model.Hardware;
import ua.kiev.smartgroup.model.Hdd;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by SleepWalker on 03.01.2017.
 */
public class JdbcHddDao extends JdbcHardwareDao {

    @Override
    public Hardware createHardware(ResultSet resultSet) throws SQLException {
        Hardware hdd = new Hdd();

        hdd.setId(resultSet.getInt("ID"));
        hdd.setName(resultSet.getString("NAME"));

        return hdd;
    }
}
