package ua.kiev.smartgroup.model.jdbc.structures;

import ua.kiev.smartgroup.model.jdbc.baseStructures.JdbcForeignToBaseTablesDao;
import ua.kiev.smartgroup.model.tables.ForeignTable;
import ua.kiev.smartgroup.model.tables.SsdToComputer;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by SleepWalker on 17.01.2017.
 */
public class JdbcSsdToComputerDao extends JdbcForeignToBaseTablesDao {

    @Override
    public ForeignTable createTable(ResultSet resultSet) throws SQLException {

        SsdToComputer ssdToComputer = new SsdToComputer();

        ssdToComputer.setIdComputer(resultSet.getInt("ID_COMPUTER"));
        ssdToComputer.setIdSsd(resultSet.getInt("ID_SSD"));

        return ssdToComputer;
    }
}
