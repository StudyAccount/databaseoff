package ua.kiev.smartgroup.model.jdbc.baseStructures;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ua.kiev.smartgroup.Main;
import ua.kiev.smartgroup.model.tables.ForeignTable;
import ua.kiev.smartgroup.model.dao.SupportTableDao;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by SleepWalker on 17.01.2017.
 */
public class JdbcForeignToBaseTablesDao implements SupportTableDao {

    private String tableName;
    private DataSource dataSource;
    private String idForeignTable;
    private String idBaseTable;

    private static final Logger LOGGER = LoggerFactory.getLogger(Main.class);
    @Override
    public void newEntry(int idBaseTable, int idSmallTable) {

        LOGGER.info("Connecting to database");

        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement("INSERT INTO " + tableName + " VALUES(?,?)")){

            LOGGER.info("Successfully connected to database");

            statement.setInt(1, idBaseTable);
            statement.setInt(2, idSmallTable);

            statement.executeUpdate();


        } catch (SQLException exception) {
            LOGGER.error("Exception occurred while connecting to database: ", exception);
            throw new RuntimeException(exception);
        }

    }

    @Override
    public void deleteEntry(int idBaseTable) {
        LOGGER.info("Connecting to database");

        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement("DELETE FROM " + tableName + " WHERE " + this.idBaseTable + " = ?")) {

            statement.setInt(1, idBaseTable);
            statement.executeUpdate();

        }catch (SQLException exception) {
            LOGGER.error("Exception occurred while connecting to database: ", exception);
            throw new RuntimeException(exception);
        }
    }

    @Override
    public void modify(int idBaseTable, int idSmallTable) {
        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement("UPDATE " + tableName + " SET " + idForeignTable + " = ? WHERE " + this.idBaseTable + " = ?")) {

            LOGGER.info("Successfully connected to database");

            statement.setInt(1, idBaseTable);
            statement.setInt(2, idSmallTable);
            statement.executeUpdate();
        }catch (SQLException exception) {
            LOGGER.error("Exception occurred while connecting to database: ", exception);
            throw new RuntimeException(exception);
        }
    }

    @Override
    public ForeignTable loadByBaseTableId(int idBaseTable) {

        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement("SELECT * FROM " + tableName + " WHERE " + this.idBaseTable + " = ?")){

            statement.setInt(1, idBaseTable);
            ResultSet resultSet = statement.executeQuery();

            if(resultSet.next()){
                return createTable(resultSet);
            }else {

                throw new RuntimeException("Cannot not find hardware wit id " + idBaseTable);
            }


        } catch (SQLException exception) {
            LOGGER.error("Exception occurred while connecting to database: ", exception);
            throw new RuntimeException(exception);
        }
    }

    public ForeignTable createTable(ResultSet resultSet) throws SQLException{
        return new ForeignTable();
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public void setIdForeignTable(String idForeignTable) {
        this.idForeignTable = idForeignTable;
    }

    public void setIdBaseTable(String idBaseTable) {
        this.idBaseTable = idBaseTable;
    }
}
