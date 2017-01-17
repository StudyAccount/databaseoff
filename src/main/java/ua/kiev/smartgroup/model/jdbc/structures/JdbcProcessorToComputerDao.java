package ua.kiev.smartgroup.model.jdbc.structures;

import ua.kiev.smartgroup.model.jdbc.baseStructures.JdbcHardwareToComputer;
import ua.kiev.smartgroup.model.tables.ForeignTable;
import ua.kiev.smartgroup.model.tables.Processor;
import ua.kiev.smartgroup.model.tables.ProcessorToComputer;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by SleepWalker on 17.01.2017.
 */
public class JdbcProcessorToComputerDao extends JdbcHardwareToComputer {

    @Override
    public ForeignTable createTable(ResultSet resultSet) throws SQLException {

        ProcessorToComputer processorToComputer = new ProcessorToComputer();

        processorToComputer.setIdComputer(resultSet.getInt("ID_COMPUTER"));
        processorToComputer.setIdProcessor(resultSet.getInt("ID_PROCESSOR"));

        return processorToComputer;
    }
}
