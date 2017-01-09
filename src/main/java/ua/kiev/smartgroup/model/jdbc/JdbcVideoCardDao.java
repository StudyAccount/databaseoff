package ua.kiev.smartgroup.model.jdbc;

import ua.kiev.smartgroup.model.Hardware;
import ua.kiev.smartgroup.model.VideoCard;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by SleepWalker on 03.01.2017.
 */
public class JdbcVideoCardDao extends JdbcHardwareDao {
    @Override
    public Hardware createTable(ResultSet resultSet) throws SQLException {
        Hardware videoCard = new VideoCard();

        videoCard.setId(resultSet.getInt("ID"));
        videoCard.setName(resultSet.getString("NAME"));

        return videoCard;
    }
}

