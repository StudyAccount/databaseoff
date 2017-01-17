package ua.kiev.smartgroup.model.jdbc.baseStructures;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ua.kiev.smartgroup.Main;
import ua.kiev.smartgroup.model.tables.BaseTable;
import ua.kiev.smartgroup.model.dao.BaseTableDao;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by SleepWalker on 09.01.2017.
 */
public class JdbcBaseTableDao implements BaseTableDao{

    private String tableName;
    private DataSource dataSource;

    private static final Logger LOGGER = LoggerFactory.getLogger(Main.class);

    @Override
    public List<BaseTable> loadAllList() {

        List<BaseTable> result = new ArrayList<>();

        try (Connection connection = dataSource.getConnection();
             Statement statement = connection.createStatement()){

            LOGGER.info("Successfully connected to database");

            String sql = "SELECT * FROM " + tableName;

            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()){
                BaseTable table = createTable(resultSet);
                result.add(table);
            }


        }catch (SQLException exception){
            LOGGER.error("Exception occurred while connecting to database: ", exception);
            throw new RuntimeException(exception);
        }


        return result;
    }

    @Override
    public void deleteEntry(int id) {

        LOGGER.info("Connecting to database");

        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement("DELETE FROM " + tableName + " WHERE ID=?")) {

            statement.setInt(1, id);
            statement.executeUpdate();

        }catch (SQLException exception) {
            LOGGER.error("Exception occurred while connecting to database: ", exception);
            throw new RuntimeException(exception);
        }

    }

    @Override
    public BaseTable loadByID(int id) {
        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement("SELECT * FROM " + tableName + " WHERE ID = ?")){

            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();

            if(resultSet.next()){
                return createTable(resultSet);
            }else {

                throw new RuntimeException("Cannot not find hardware wit id " + id);
            }


        } catch (SQLException exception) {
            LOGGER.error("Exception occurred while connecting to database: ", exception);
            throw new RuntimeException(exception);
        }
    }

    public BaseTable createTable(ResultSet resultSet) throws SQLException{
        return new BaseTable();
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }
}
