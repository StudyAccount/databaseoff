package ua.kiev.smartgroup.model.jdbc.structures;

import ua.kiev.smartgroup.model.jdbc.baseStructures.JdbcSmallTableDao;
import ua.kiev.smartgroup.model.tables.Hardware;
import ua.kiev.smartgroup.model.tables.VideoCard;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by SleepWalker on 03.01.2017.
 */
public class JdbcVideoCardDao extends JdbcSmallTableDao {
    @Override
    public Hardware createTable(ResultSet resultSet) throws SQLException {
        Hardware videoCard = new VideoCard();

        videoCard.setId(resultSet.getInt("ID"));
        videoCard.setName(resultSet.getString("NAME"));

        return videoCard;
    }
}

