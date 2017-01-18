package ua.kiev.smartgroup.model.jdbc.structures;

import ua.kiev.smartgroup.model.jdbc.baseStructures.JdbcSmallTableDao;
import ua.kiev.smartgroup.model.tables.BaseTable;
import ua.kiev.smartgroup.model.tables.Subscription;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by SleepWalker on 18.01.2017.
 */
public class JdbcSubscriptionDao extends JdbcSmallTableDao {

    @Override
    public BaseTable createTable(ResultSet resultSet) throws SQLException {

        Subscription subscription = new Subscription();

        subscription.setId(resultSet.getInt("ID"));
        subscription.setName(resultSet.getString("NAME"));

        return subscription;
    }
}
