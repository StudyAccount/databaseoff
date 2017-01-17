package ua.kiev.smartgroup.model.jdbc.structures;

import ua.kiev.smartgroup.model.jdbc.baseStructures.JdbcHardwareToComputer;
import ua.kiev.smartgroup.model.tables.ForeignTable;
import ua.kiev.smartgroup.model.tables.HddToComputer;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by SleepWalker on 17.01.2017.
 */
public class JdbcHddToComputerDao extends JdbcHardwareToComputer {

    @Override
    public ForeignTable createTable(ResultSet resultSet) throws SQLException {

        HddToComputer hddToComputer = new HddToComputer();

        hddToComputer.setIdComputer(resultSet.getInt("ID_COMPUTER"));
        hddToComputer.setIdHdd(resultSet.getInt("ID_HDD"));

        return hddToComputer;
    }
}
