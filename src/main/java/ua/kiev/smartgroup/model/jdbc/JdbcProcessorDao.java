package ua.kiev.smartgroup.model.jdbc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ua.kiev.smartgroup.Main;
import ua.kiev.smartgroup.model.Processor;
import ua.kiev.smartgroup.model.dao.HardwareDao;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by SleepWalker on 27.12.2016.
 */
public class JdbcProcessorDao implements HardwareDao{

    private DataSource dataSource;

    public static final Logger LOGGER = LoggerFactory.getLogger(Main.class);

    @Override
    public List<Processor> loadAllList() {

        List<Processor> result = new ArrayList<>();

        try (Connection connection = dataSource.getConnection();
             Statement statement = connection.createStatement()){

            LOGGER.info("Successfully connected to database");

            String sql = "SELECT * FROM PROCESSOR";

            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()){
                Processor processor = createProcessor(resultSet);
                result.add(processor);
            }


        }catch (SQLException exception){
            LOGGER.error("Exception occurred while connecting to database: ", exception);
            throw new RuntimeException(exception);
        }


        return result;
    }

    @Override
    public void addNewModel(int id, String name) {

        LOGGER.info("Connecting to database");

        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement("INSERT INTO PROCESSOR VALUES(?,?)")){

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
    public void deleteModel(int id) {

        LOGGER.info("Connecting to database");

        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement("DELETE FROM PROCESSOR WHERE ID=?")) {

            statement.setInt(1, id);
            statement.executeUpdate();

        }catch (SQLException exception) {
            LOGGER.error("Exception occurred while connecting to database: ", exception);
            throw new RuntimeException(exception);
        }

    }

    @Override
    public Processor loadByID(int id) {

        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement("SELECT * FROM PROCESSOR WHERE ID = ?")){

            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();

            if(resultSet.next()){

                return createProcessor(resultSet);
            }else {

                throw new RuntimeException("Cannot not find processor wit id " + id);
            }


        } catch (SQLException exception) {
            LOGGER.error("Exception occurred while connecting to database: ", exception);
            throw new RuntimeException(exception);
        }
    }

    @Override
    public void modify(int id, String name) {

        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement("UPDATE PROCESSOR SET NAME = ? WHERE ID = ?")) {

            LOGGER.info("Successfully connected to database");

            statement.setString(1, name);
            statement.setInt(2, id);
            statement.executeUpdate();

        }catch (SQLException exception) {
            LOGGER.error("Exception occurred while connecting to database: ", exception);
            throw new RuntimeException(exception);
        }


    }

    private Processor createProcessor(ResultSet resultSet) throws SQLException{
        Processor processor = new Processor();
        processor.setId(resultSet.getInt("ID"));
        processor.setName(resultSet.getString("NAME"));

        return processor;

    }

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }
}
