package ua.kiev.smartgroup.model.jdbc.structures;

import ua.kiev.smartgroup.model.jdbc.baseStructures.JdbcHardwareDao;
import ua.kiev.smartgroup.model.tables.Hardware;
import ua.kiev.smartgroup.model.tables.Processor;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by SleepWalker on 03.01.2017.
 */
public class JdbcProcessorDao extends JdbcHardwareDao {

    @Override
    public Hardware createTable(ResultSet resultSet) throws SQLException {

        Hardware processor = new Processor();

        processor.setId(resultSet.getInt("ID"));
        processor.setName(resultSet.getString("NAME"));

        return processor;

    }
}
