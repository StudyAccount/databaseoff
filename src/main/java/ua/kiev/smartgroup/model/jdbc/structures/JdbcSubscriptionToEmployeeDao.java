package ua.kiev.smartgroup.model.jdbc.structures;

import ua.kiev.smartgroup.model.jdbc.baseStructures.JdbcForeignToBaseTablesDao;
import ua.kiev.smartgroup.model.tables.ForeignTable;
import ua.kiev.smartgroup.model.tables.SubscriptionToEmployee;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by SleepWalker on 18.01.2017.
 */
public class JdbcSubscriptionToEmployeeDao extends JdbcForeignToBaseTablesDao {

    @Override
    public ForeignTable createTable(ResultSet resultSet) throws SQLException {

        SubscriptionToEmployee subscriptionToEmployee = new SubscriptionToEmployee();

        subscriptionToEmployee.setIdEmployee(resultSet.getInt("ID_EMPLOYEE"));
        subscriptionToEmployee.setIdSubscription(resultSet.getInt("ID_SUBSCRIPTION"));

        return subscriptionToEmployee;
    }
}
