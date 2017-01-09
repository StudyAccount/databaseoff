package ua.kiev.smartgroup.model.jdbc;

import ua.kiev.smartgroup.model.Hardware;
import ua.kiev.smartgroup.model.MonitorModel;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by SleepWalker on 03.01.2017.
 */
public class JdbcMonitorModelDao extends JdbcHardwareDao {
    @Override
    public Hardware createTable(ResultSet resultSet) throws SQLException {
        Hardware monitorModel = new MonitorModel();

        monitorModel.setId(resultSet.getInt("ID"));
        monitorModel.setName(resultSet.getString("NAME"));

        return monitorModel;
    }
}
