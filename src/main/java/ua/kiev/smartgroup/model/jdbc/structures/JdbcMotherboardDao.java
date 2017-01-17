package ua.kiev.smartgroup.model.jdbc.structures;

import ua.kiev.smartgroup.model.jdbc.baseStructures.JdbcHardwareDao;
import ua.kiev.smartgroup.model.tables.Hardware;
import ua.kiev.smartgroup.model.tables.Motherboard;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by SleepWalker on 03.01.2017.
 */
public class JdbcMotherboardDao extends JdbcHardwareDao {
    @Override
    public Hardware createTable(ResultSet resultSet) throws SQLException {
        Hardware motherboard = new Motherboard();

        motherboard.setId(resultSet.getInt("ID"));
        motherboard.setName(resultSet.getString("NAME"));

        return motherboard;
    }
}
