package ua.kiev.smartgroup.model.jdbc.structures;

import ua.kiev.smartgroup.model.jdbc.baseStructures.JdbcHardwareDao;
import ua.kiev.smartgroup.model.tables.Hardware;
import ua.kiev.smartgroup.model.tables.Ssd;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by SleepWalker on 03.01.2017.
 */
public class JdbcSsdDao extends JdbcHardwareDao {
    @Override
    public Hardware createTable(ResultSet resultSet) throws SQLException {
        Hardware ssd = new Ssd();

        ssd.setId(resultSet.getInt("ID"));
        ssd.setName(resultSet.getString("NAME"));

        return ssd;
    }
}
