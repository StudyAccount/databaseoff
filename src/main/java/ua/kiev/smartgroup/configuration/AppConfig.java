package ua.kiev.smartgroup.configuration;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import ua.kiev.smartgroup.Main;
import ua.kiev.smartgroup.controllers.EmployeeController;
import ua.kiev.smartgroup.model.BaseTable;
import ua.kiev.smartgroup.model.Employee;
import ua.kiev.smartgroup.model.Hdd;
import ua.kiev.smartgroup.model.Processor;
import ua.kiev.smartgroup.model.jdbc.*;

import javax.sql.DataSource;
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
    @Scope("prototype")
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
    public Employee employee(){

        return new Employee();
    }

    @Bean
    public JdbcEmployeeDao employeeDao() throws PropertyVetoException {
        JdbcEmployeeDao employeeDao = new JdbcEmployeeDao();
        employeeDao.setDataSource(dataSource());
        employeeDao.setNewDataSource(dataSource());
        employeeDao.setTableName("EMPLOYEE");

//        jdbcEmployeeDao.setEmployee(employee());

        return employeeDao;
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
        main.setEmployeeDao(employeeDao());
        main.setProcessorDao(processorDao());
        main.setHddDao(hddDao());
        main.setMonitorModelDao(monitorModelDao());
        main.setMotherboardDao(motherboardDao());
        main.setSsdDao(ssdDao());
        main.setVideoCardDao(videoCardDao());
        main.setComputerDao(computerDao());

        return main;
    }

    @Bean
    @Scope("prototype")
    public Processor processor(){

        return new Processor();
    }

    @Bean
    public JdbcProcessorDao processorDao() throws PropertyVetoException {

        JdbcProcessorDao processorDao = new JdbcProcessorDao();

        processorDao.setTableName("PROCESSOR");
        processorDao.setDataSource(dataSource());
        processorDao.setNewDataSource(dataSource());
        return processorDao;

    }

    @Bean
    public JdbcHddDao hddDao() throws PropertyVetoException {

        JdbcHddDao hddDao = new JdbcHddDao();
        hddDao.setTableName("HDD");
        hddDao.setDataSource(dataSource());
        hddDao.setNewDataSource(dataSource());
        return hddDao;
    }

    @Bean
    public Hdd hdd(){

        return new Hdd();
    }

    @Bean
    public JdbcMonitorModelDao monitorModelDao() throws PropertyVetoException {

        JdbcMonitorModelDao monitorModelDao = new JdbcMonitorModelDao();
//        monitorModelDao.setHardwareTable("MONITOR_MODEL");
        monitorModelDao.setTableName("MONITOR_MODEL");
        monitorModelDao.setDataSource(dataSource());
        monitorModelDao.setNewDataSource(dataSource());
        return monitorModelDao;
    }

    @Bean
    public JdbcSsdDao ssdDao() throws PropertyVetoException {

        JdbcSsdDao ssdDao = new JdbcSsdDao();
        ssdDao.setTableName("SSD");
        ssdDao.setDataSource(dataSource());
        ssdDao.setNewDataSource(dataSource());
        return ssdDao;
    }

    @Bean
    public JdbcVideoCardDao videoCardDao() throws PropertyVetoException {

        JdbcVideoCardDao videoCardDao = new JdbcVideoCardDao();
        videoCardDao.setTableName("VIDEOCARD");
        videoCardDao.setDataSource(dataSource());
        videoCardDao.setNewDataSource(dataSource());
        return videoCardDao;
    }

    @Bean
    public JdbcMotherboardDao motherboardDao() throws PropertyVetoException {
        JdbcMotherboardDao motherboardDao = new JdbcMotherboardDao();
        motherboardDao.setTableName("MOTHERBOARD");
        motherboardDao.setDataSource(dataSource());
        motherboardDao.setNewDataSource(dataSource());
        return motherboardDao;
    }

    @Bean
    public  JdbcComputerDao computerDao() throws PropertyVetoException {

        JdbcComputerDao computerDao = new JdbcComputerDao();
        computerDao.setDataSource(dataSource());
        computerDao.setTableName("COMPUTER");
        computerDao.setNewDataSource(dataSource());
        return computerDao;
    }
//
//    @Bean
//    public JdbcBaseTableDao baseTableDao() throws PropertyVetoException {
//
//        JdbcBaseTableDao baseTableDao = new JdbcBaseTableDao();
//        baseTableDao.setDataSource(dataSource());
//        return baseTableDao;
//    }

}
