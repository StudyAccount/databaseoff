package ua.kiev.smartgroup.model.jdbc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ua.kiev.smartgroup.Main;
import ua.kiev.smartgroup.model.dao.HardwareDao;

import javax.sql.DataSource;
import java.sql.*;

/**
 * Created by SleepWalker on 27.12.2016.
 */
public class JdbcHardwareDao extends JdbcBaseTableDao implements HardwareDao{

    private DataSource newDataSource;
    private String hardwareName;


    private static final Logger LOGGER = LoggerFactory.getLogger(Main.class);


    @Override
    public void addNewModel(int id, String name) {

        LOGGER.info("Connecting to database");

        try (Connection connection = newDataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement("INSERT INTO " + hardwareName + " VALUES(?,?)")){

            LOGGER.info("Successfully connected to database");

            statement.setInt(1, id);
            statement.setString(2, name);

            statement.executeUpdate();


        } catch (SQLException exception) {
            LOGGER.error("Exception occurred while connecting to database: ", exception);
            throw new RuntimeException(exception);
        }


    }

    @Override
    public void modify(int id, String name) {

        try (Connection connection = newDataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement("UPDATE " + hardwareName + " SET NAME = ? WHERE ID = ?")) {

            LOGGER.info("Successfully connected to database");

            statement.setString(1, name);
            statement.setInt(2, id);
            statement.executeUpdate();
        }catch (SQLException exception) {
            LOGGER.error("Exception occurred while connecting to database: ", exception);
            throw new RuntimeException(exception);
        }


    }

    public void setHardwareName(String hardwareName) {
        this.hardwareName = hardwareName;
    }

    public void setNewDataSource(DataSource dataSource) {
        this.newDataSource = dataSource;
    }

}
