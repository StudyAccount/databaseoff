package ua.kiev.smartgroup.model.jdbc.structures;

import ua.kiev.smartgroup.model.jdbc.baseStructures.JdbcHardwareToComputer;
import ua.kiev.smartgroup.model.tables.ForeignTable;
import ua.kiev.smartgroup.model.tables.VideoCardToComputer;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by SleepWalker on 17.01.2017.
 */
public class JdbcVideoCardToComputerDao extends JdbcHardwareToComputer {

    @Override
    public ForeignTable createTable(ResultSet resultSet) throws SQLException {

        VideoCardToComputer videoCardToComputer = new VideoCardToComputer();

        videoCardToComputer.setIdComputer(resultSet.getInt("ID_COMPUTER"));
        videoCardToComputer.setIdVideoCard(resultSet.getInt("ID_VIDEOCARD"));

        return videoCardToComputer;
    }
}
