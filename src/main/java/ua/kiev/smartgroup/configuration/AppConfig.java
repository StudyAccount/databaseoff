package ua.kiev.smartgroup.configuration;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import ua.kiev.smartgroup.Main;
import ua.kiev.smartgroup.controllers.EmployeeController;
import ua.kiev.smartgroup.model.jdbc.JdbcEmployeeDao;

import java.beans.PropertyVetoException;
/**
 * Created by User on 23.11.2016.
 */
@Configuration
@EnableTransactionManagement(proxyTargetClass =  true)
public class AppConfig {

    @Bean
    public LogAspect logAspect(){
        return new LogAspect();
    }


    @Bean
    public ComboPooledDataSource dataSource(
//            @Value("${jdbc.driver.class}") String driverClass,
//            @Value("${jdbc.url}") String jdbcUrl,
//            @Value("${jdbc.user}") String user,
//            @Value("${jdbc.password}") String password,
//            @Value("${jdbc.min.connections}") int minConnections,
//            @Value("${jdbc.max.connections}") int maxConnections,
//            @Value("${jdbc.acquire.increment}") int acquireIncrement
    ) throws PropertyVetoException {

        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        String driverClass = "org.postgresql.Driver" ;
        String jdbcUrl = "jdbc:postgresql://localhost:5432/company";
        String user = "Viktor";
        String password = "pass";
        int minConnections = 1;
        int maxConnections = 10;
        int acquireIncrement = 1;
        dataSource.setDriverClass(driverClass);
        dataSource.setJdbcUrl(jdbcUrl);
        dataSource.setUser(user);
        dataSource.setPassword(password);
        dataSource.setMinPoolSize(minConnections);
        dataSource.setMaxPoolSize(maxConnections);
        dataSource.setAcquireIncrement(acquireIncrement);
        return dataSource;
    }

//    @Bean
//    public PropertyPlaceholderConfigurer propertyPlaceholderConfigurer () {
//        PropertyPlaceholderConfigurer propertyPlaceholderConfigurer = new PropertyPlaceholderConfigurer();
//        propertyPlaceholderConfigurer.setLocation(new ClassPathResource("jdbc.properties"));
//        return propertyPlaceholderConfigurer;
//    }


    @Bean
    public JdbcEmployeeDao employeeDao() throws PropertyVetoException {
        JdbcEmployeeDao jdbcEmployeeDao = new JdbcEmployeeDao();
        jdbcEmployeeDao.setDataSource(dataSource());
        return jdbcEmployeeDao;
    }

    @Bean
    public DataSourceTransactionManager txManager() throws PropertyVetoException {
        DataSourceTransactionManager txManager = new DataSourceTransactionManager();
        txManager.setDataSource(dataSource());
        return txManager;
    }


    @Bean
    public EmployeeController employeeController() throws PropertyVetoException {
        EmployeeController employeeController = new EmployeeController();
        employeeController.setTxManager(txManager());
        employeeController.setEmployeeDao(employeeDao());
        return employeeController;

    }

    @Bean
    public Main main() throws PropertyVetoException {

        Main main = new Main();
        main.setEmployeeController(employeeController());
        return main;
    }
}
