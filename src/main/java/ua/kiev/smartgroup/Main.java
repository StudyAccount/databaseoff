package ua.kiev.smartgroup;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


/**
 * Created by User on 23.11.2016.
 */
public class Main {
    public static final Logger LOGGER = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {

        loadDriver();
        LOGGER.info("Connecting to database");

        String url = "jdbc:postgresql://localhost:5432/company";
        String user = "Viktor";
        String password = "pass";
        try (Connection connection = DriverManager.getConnection(url, user, password);
             Statement statement = connection.createStatement()){

            LOGGER.info("Successfully connected to database");
        } catch (SQLException exception) {
            LOGGER.error("Exception occurred while connecting to database: " + url, exception);
        }


    }

    private static void loadDriver() {
        try {
            LOGGER.info("Loading JDBC driver: org.postgresql.Driver");
            Class.forName("org.postgresql.Driver");
            LOGGER.info("Driver loaded successfully");
        } catch (ClassNotFoundException e) {
            LOGGER.error("Cannot find driver: org.postgresql.Driver");
            throw new RuntimeException(e);
        }
    }

}

