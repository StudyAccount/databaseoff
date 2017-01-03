package ua.kiev.smartgroup.model.jdbc;

import ua.kiev.smartgroup.model.Hardware;
import ua.kiev.smartgroup.model.Motherboard;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by SleepWalker on 03.01.2017.
 */
public class JdbcMotherboardDao extends JdbcHardwareDao {
    @Override
    public Hardware createHardware(ResultSet resultSet) throws SQLException {
        Hardware motherboard = new Motherboard();

        motherboard.setId(resultSet.getInt("ID"));
        motherboard.setName(resultSet.getString("NAME"));

        return motherboard;
    }
}
