package ua.kiev.smartgroup.configuration;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import ua.kiev.smartgroup.Main;
import ua.kiev.smartgroup.controllers.EmployeeController;
import ua.kiev.smartgroup.model.jdbc.structures.*;

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
    public JdbcEmployeeDao employeeDao() throws PropertyVetoException {
        JdbcEmployeeDao employeeDao = new JdbcEmployeeDao();
        employeeDao.setDataSource(dataSource());
        employeeDao.setNewDataSource(dataSource());
        employeeDao.setTableName("EMPLOYEE");

        return employeeDao;
    }



    @Bean
    public JdbcRiskManagerDao riskManagerDao() throws PropertyVetoException {

        JdbcRiskManagerDao riskManagerDao = new JdbcRiskManagerDao();

        riskManagerDao.setDataSource(dataSource());
        riskManagerDao.setNewDataSource(dataSource());
        riskManagerDao.setTableName("RISK_MANAGER");
        return riskManagerDao;
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
        main.setProcessorToComputerDao(processorToComputerDao());
        main.setHddToComputerDao(hddToComputerDao());
        main.setSsdToComputerDao(ssdToComputerDao());
        main.setVideoCardToComputerDao(videoCardToComputerDao());

        return main;
    }

    @Bean
    public JdbcProcessorDao processorDao() throws PropertyVetoException {

        JdbcProcessorDao processorDao = new JdbcProcessorDao();

        processorDao.setTableName("PROCESSOR");
        processorDao.setSmallTableName("PROCESSOR");
        processorDao.setDataSource(dataSource());
        processorDao.setNewDataSource(dataSource());
        return processorDao;

    }

    @Bean
    public JdbcHddDao hddDao() throws PropertyVetoException {

        JdbcHddDao hddDao = new JdbcHddDao();
        hddDao.setTableName("HDD");
        hddDao.setSmallTableName("HDD");
        hddDao.setDataSource(dataSource());
        hddDao.setNewDataSource(dataSource());
        return hddDao;
    }

//    @Bean
//    public Hdd hdd(){
//
//        return new Hdd();
//    }

    @Bean
    public JdbcMonitorModelDao monitorModelDao() throws PropertyVetoException {

        JdbcMonitorModelDao monitorModelDao = new JdbcMonitorModelDao();
        monitorModelDao.setTableName("MONITOR_MODEL");
        monitorModelDao.setSmallTableName("MONITOR_MODEL");
        monitorModelDao.setDataSource(dataSource());
        monitorModelDao.setNewDataSource(dataSource());
        return monitorModelDao;
    }

    @Bean
    public JdbcOfficeDao officeDao() throws PropertyVetoException {

        JdbcOfficeDao officeDao = new JdbcOfficeDao();
        officeDao.setTableName("OFFICE");
        officeDao.setSmallTableName("OFFICE");
        officeDao.setDataSource(dataSource());
        officeDao.setNewDataSource(dataSource());
        return officeDao;

    }

    @Bean
    public JdbcStatusDao statusDao() throws PropertyVetoException {

        JdbcStatusDao statusDao = new JdbcStatusDao();

        statusDao.setDataSource(dataSource());
        statusDao.setNewDataSource(dataSource());
        statusDao.setTableName("STATUS");
        statusDao.setSmallTableName("STATUS");
        return statusDao;
    }

    @Bean
    public JdbcDepartmentDao departmentDao() throws PropertyVetoException {

        JdbcDepartmentDao departmentDao = new JdbcDepartmentDao();

        departmentDao.setDataSource(dataSource());
        departmentDao.setNewDataSource(dataSource());
        departmentDao.setTableName("DEPARTMENT");
        departmentDao.setSmallTableName("DEPARTMENT");

        return departmentDao;
    }

    @Bean
    private JdbcSubscriptionDao subscriptionDao() throws PropertyVetoException {

        JdbcSubscriptionDao subscriptionDao = new JdbcSubscriptionDao();

        subscriptionDao.setDataSource(dataSource());
        subscriptionDao.setNewDataSource(dataSource());
        subscriptionDao.setTableName("SUBSCRIPTION");
        subscriptionDao.setSmallTableName("SUBSCRIPTION");
        return subscriptionDao;
    }

    @Bean
    public JdbcMonitorDao monitorDao() throws PropertyVetoException {

        JdbcMonitorDao monitorDao = new JdbcMonitorDao();
        monitorDao.setDataSource(dataSource());
        monitorDao.setNewDataSource(dataSource());
        monitorDao.setTableName("MONITOR");

        return monitorDao;
    }

    @Bean
    public JdbcSitDao sitDao() throws PropertyVetoException {

        JdbcSitDao sitDao = new JdbcSitDao();
        sitDao.setDataSource(dataSource());
        sitDao.setNewDataSource(dataSource());
        sitDao.setTableName("SIT");

        return  sitDao;
    }

    @Bean
    public JdbcSsdDao ssdDao() throws PropertyVetoException {

        JdbcSsdDao ssdDao = new JdbcSsdDao();
        ssdDao.setTableName("SSD");
        ssdDao.setSmallTableName("SSD");
        ssdDao.setDataSource(dataSource());
        ssdDao.setNewDataSource(dataSource());
        return ssdDao;
    }

    @Bean
    public JdbcVideoCardDao videoCardDao() throws PropertyVetoException {

        JdbcVideoCardDao videoCardDao = new JdbcVideoCardDao();
        videoCardDao.setTableName("VIDEOCARD");
        videoCardDao.setSmallTableName("VIDEOCARD");
        videoCardDao.setDataSource(dataSource());
        videoCardDao.setNewDataSource(dataSource());
        return videoCardDao;
    }

    @Bean
    public JdbcMotherboardDao motherboardDao() throws PropertyVetoException {
        JdbcMotherboardDao motherboardDao = new JdbcMotherboardDao();
        motherboardDao.setTableName("MOTHERBOARD");
        motherboardDao.setSmallTableName("MOTHERBOARD");
        motherboardDao.setDataSource(dataSource());
        motherboardDao.setNewDataSource(dataSource());
        return motherboardDao;
    }

    @Bean
    public JdbcComputerDao computerDao() throws PropertyVetoException {

        JdbcComputerDao computerDao = new JdbcComputerDao();
        computerDao.setDataSource(dataSource());
        computerDao.setTableName("COMPUTER");
        computerDao.setNewDataSource(dataSource());
        return computerDao;
    }

    @Bean
    public JdbcProcessorToComputerDao processorToComputerDao() throws PropertyVetoException {

        JdbcProcessorToComputerDao processorToComputerDao = new JdbcProcessorToComputerDao();
        processorToComputerDao.setDataSource(dataSource());
        processorToComputerDao.setTableName("COMPUTER_PROCESSOR");
        processorToComputerDao.setIdForeignTable("ID_PROCESSOR");
        processorToComputerDao.setIdBaseTable("ID_COMPUTER");
        return processorToComputerDao;
    }

    @Bean
    public JdbcHddToComputerDao hddToComputerDao() throws PropertyVetoException {

        JdbcHddToComputerDao hddToComputerDao = new JdbcHddToComputerDao();
        hddToComputerDao.setDataSource(dataSource());
        hddToComputerDao.setTableName("COMPUTER_HDD");
        hddToComputerDao.setIdForeignTable("ID_HDD");
        hddToComputerDao.setIdBaseTable("ID_COMPUTER");
        return  hddToComputerDao;
    }

    @Bean
    public JdbcSsdToComputerDao ssdToComputerDao() throws PropertyVetoException {

        JdbcSsdToComputerDao ssdToComputerDao = new JdbcSsdToComputerDao();
        ssdToComputerDao.setDataSource(dataSource());
        ssdToComputerDao.setTableName("COMPUTER_SSD");
        ssdToComputerDao.setIdForeignTable("ID_SSD");
        ssdToComputerDao.setIdBaseTable("ID_COMPUTER");
        return ssdToComputerDao;
    }

    @Bean
    public JdbcVideoCardToComputerDao videoCardToComputerDao() throws PropertyVetoException {

        JdbcVideoCardToComputerDao videoCardToComputerDao = new JdbcVideoCardToComputerDao();
        videoCardToComputerDao.setDataSource(dataSource());
        videoCardToComputerDao.setTableName("COMPUTER_VIDEOCARD");
        videoCardToComputerDao.setIdForeignTable("ID_VIDEOCARD");
        videoCardToComputerDao.setIdBaseTable("ID_COMPUTER");
        return videoCardToComputerDao;
    }

    @Bean
    public JdbcSubscriptionToEmployeeDao subscriptionToEmployeeDao() throws PropertyVetoException {

        JdbcSubscriptionToEmployeeDao subscriptionToEmployeeDao = new JdbcSubscriptionToEmployeeDao();
        subscriptionToEmployeeDao.setDataSource(dataSource());
        subscriptionToEmployeeDao.setTableName("SUBSCRIPTION_EMPLOYEE");
        subscriptionToEmployeeDao.setIdForeignTable("ID_SUBSCRIPTION");
        subscriptionToEmployeeDao.setIdBaseTable("ID_EMPLOYEE");
        return subscriptionToEmployeeDao;
    }

    @Bean
    public JdbcEmployeeToDepartmentDao employeeToDepartmentDao() throws PropertyVetoException {

        JdbcEmployeeToDepartmentDao employeeToDepartmentDao = new JdbcEmployeeToDepartmentDao();
        employeeToDepartmentDao.setDataSource(dataSource());
        employeeToDepartmentDao.setTableName("EMPLOYEE_DEPARTMENT");
        employeeToDepartmentDao.setIdForeignTable("ID_DEPARTMENT");
        employeeToDepartmentDao.setIdBaseTable("ID_EMPLOYEE");
        return employeeToDepartmentDao;
    }

}
