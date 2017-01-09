package ua.kiev.smartgroup.model.jdbc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ua.kiev.smartgroup.Main;
import ua.kiev.smartgroup.model.Hardware;
import ua.kiev.smartgroup.model.dao.HardwareDao;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by SleepWalker on 27.12.2016.
 */
public class JdbcHardwareDao extends JdbcBaseTableDao implements HardwareDao{

    private DataSource newDataSource;
    private String hardwareTable;
    private String tableName;


    private static final Logger LOGGER = LoggerFactory.getLogger(Main.class);



//    @Override
//    public List<Hardware> loadAllList() {
//
//        List<Hardware> result = new ArrayList<>();
//
//        try (Connection connection = dataSource.getConnection();
//             Statement statement = connection.createStatement()){
//
//            LOGGER.info("Successfully connected to database");
//
//            String sql = "SELECT * FROM " + hardwareTable;
//
//            ResultSet resultSet = statement.executeQuery(sql);
//
//            while (resultSet.next()){
//                Hardware hardware = createHardware(resultSet);
//                result.add(hardware);
//            }
//
//
//        }catch (SQLException exception){
//            LOGGER.error("Exception occurred while connecting to database: ", exception);
//            throw new RuntimeException(exception);
//        }
//
//
//        return result;
//    }

    @Override
    public void addNewModel(int id, String name) {

        LOGGER.info("Connecting to database");

        try (Connection connection = newDataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement("INSERT INTO " + tableName + " VALUES(?,?)")){

            LOGGER.info("Successfully connected to database");

            statement.setInt(1, id);
            statement.setString(2, name);

            statement.executeUpdate();


        } catch (SQLException exception) {
            LOGGER.error("Exception occurred while connecting to database: ", exception);
            throw new RuntimeException(exception);
        }


    }

//    @Override
//    public void deleteEntry(int id) {
//
//        LOGGER.info("Connecting to database");
//
//        try (Connection connection = dataSource.getConnection();
//             PreparedStatement statement = connection.prepareStatement("DELETE FROM " + hardwareTable + " WHERE ID=?")) {
//
//            statement.setInt(1, id);
//            statement.executeUpdate();
//
//        }catch (SQLException exception) {
//            LOGGER.error("Exception occurred while connecting to database: ", exception);
//            throw new RuntimeException(exception);
//        }
//
//    }

//    @Override
//    public Hardware loadByID(int id) {
//        try (Connection connection = dataSource.getConnection();
//             PreparedStatement statement = connection.prepareStatement("SELECT * FROM " + hardwareTable + " WHERE ID = ?")){
//
//            statement.setInt(1, id);
//            ResultSet resultSet = statement.executeQuery();
//
//            if(resultSet.next()){
//                return createHardware(resultSet);
//            }else {
//
//                throw new RuntimeException("Cannot not find hardware wit id " + id);
//            }
//
//
//        } catch (SQLException exception) {
//            LOGGER.error("Exception occurred while connecting to database: ", exception);
//            throw new RuntimeException(exception);
//        }
//    }

    @Override
    public void modify(int id, String name) {

        try (Connection connection = newDataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement("UPDATE " + tableName + " SET NAME = ? WHERE ID = ?")) {

            LOGGER.info("Successfully connected to database");

            statement.setString(1, name);
            statement.setInt(2, id);
            statement.executeUpdate();
        }catch (SQLException exception) {
            LOGGER.error("Exception occurred while connecting to database: ", exception);
            throw new RuntimeException(exception);
        }


    }


    public Hardware createHardware(ResultSet resultSet) throws SQLException{

        return new Hardware();
    }

    public void setNewDataSource(DataSource dataSource) {
        this.newDataSource = dataSource;
    }

//    public void setHardwareTable(String hardwareTable) {
//        this.hardwareTable = hardwareTable;
//    }

}
