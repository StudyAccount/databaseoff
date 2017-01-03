package ua.kiev.smartgroup.model.jdbc;

import ua.kiev.smartgroup.model.Hardware;
import ua.kiev.smartgroup.model.Ssd;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by SleepWalker on 03.01.2017.
 */
public class JdbcSsdDao extends JdbcHardwareDao {
    @Override
    public Hardware createHardware(ResultSet resultSet) throws SQLException {
        Hardware ssd = new Ssd();

        ssd.setId(resultSet.getInt("ID"));
        ssd.setName(resultSet.getString("NAME"));

        return ssd;
    }
}
