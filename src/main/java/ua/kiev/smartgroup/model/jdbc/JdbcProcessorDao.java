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
    public Processor addNewModel() {
        return null;
    }

    @Override
    public Processor deleteModel() {
        return null;
    }

    @Override
    public Processor loadByID() {
        return null;
    }

    @Override
    public Processor modify() {
        return null;
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
