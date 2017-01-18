package ua.kiev.smartgroup;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ua.kiev.smartgroup.configuration.AppConfig;
import ua.kiev.smartgroup.controllers.EmployeeController;
import ua.kiev.smartgroup.model.jdbc.structures.*;
import ua.kiev.smartgroup.model.jdbc.baseStructures.JdbcSmallTableDao;


/**
 * Created by User on 23.11.2016.
 */
public class Main {

    private EmployeeController employeeController;
    private JdbcSmallTableDao processorDao;
    private JdbcEmployeeDao employeeDao;
    private JdbcSmallTableDao hddDao;
    private JdbcSmallTableDao monitorModelDao;
    private JdbcSmallTableDao motherboardDao;
    private JdbcSmallTableDao ssdDao;
    private JdbcSmallTableDao videoCardDao;
    private JdbcComputerDao computerDao;
    private JdbcProcessorToComputerDao processorToComputerDao;
    private JdbcHddToComputerDao hddToComputerDao;
    private JdbcSsdToComputerDao ssdToComputerDao;
    private JdbcVideoCardToComputerDao videoCardToComputerDao;


    public static void main(String[] args) {

        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);

        Main main = applicationContext.getBean(Main.class);
        main.start();

        //EmployeeDao employeeDao = applicationContext.getBean(JdbcEmployeeDao.class);
//
//        System.out.println("All employees");
//        employeeDao.getAllEmployees().forEach(System.out::println);
//        System.out.println("Employee with id 3");
//        System.out.println(employeeDao.loadEmployee(3));

    }

    private void start(){
//
//        computerDao.loadAllList().forEach(System.out::println);
//        computerDao.deleteEntry(22);
//        System.out.printf("--------------------");
//        System.out.println(computerDao.loadByID(3).toString());
//        System.out.printf("--------------------");
//        computerDao.loadAllComputers().forEach(System.out::println);
//        computerDao.addNewComputer(22,"o",1,"ss","",0,0,2);
//        computerDao.loadAllComputers().forEach(System.out::println);
//        computerDao.deleteComputer(22);
//        computerDao.loadAllComputers().forEach(System.out::println);
//        Computer computer = computerDao.loadComputerByID(1);
//        System.out.println(computer);
//        computerDao.loadAllList().forEach(System.out::println);
//        computerDao.modify(22,"o",1,"qqqq","",0,0,2);
//        computerDao.loadAllList().forEach(System.out::println);
//        processorDao.loadAllList().forEach(System.out::println);
//        hddDao.loadAllList("HDD").forEach(System.out::println);
//        monitorModelDao.loadAllList("MONITOR_MODEL").forEach(System.out::println);
//        motherboardDao.loadAllList("MOTHERBOARD").forEach(System.out::println);
//        ssdDao.loadAllList("SSD").forEach(System.out::println);
//        videoCardDao.loadAllList("VIDEOCARD").forEach(System.out::println);

//        ForeignTable hddToComputer = hddToComputerDao.loadByBaseTableId(4);
//        System.out.println(hddToComputer.toString());
//        hddToComputerDao.modify(8,4);
//        System.out.println(hddToComputerDao.loadByBaseTableId(4).toString());
//        BaseTable processor  = processorDao.loadByID(1);
//        Hardware hdd = hddDao.loadByID(1);
//        Hardware monitorModel  = monitorModelDao.loadByID(1);
//        Hardware motherboard =  motherboardDao.loadByID(1);
//        Hardware ssd = ssdDao.loadByID(1);
//        Hardware videoCard = videoCardDao.loadByID(1);
//
//        System.out.println(processor.toString());
//        System.out.println(hdd.toString());
//        System.out.println(monitorModel.toString());
//        System.out.println(motherboard.toString());
//        System.out.println(ssd.toString());
//        System.out.println(videoCard.toString());

//        processorDao.addNewModel(79,"jktym");
//        processorDao.deleteEntry(78);
//        processorDao.loadAllList().forEach(System.out::println);
//        processorDao.deleteEntry(79);
//        processorDao.loadAllList().forEach(System.out::println);
//        processorDao.addNewModel(77,"jktym");
//        processorDao.modify("PROCESSOR", 77,"t,fkf");
//        processorDao.deleteEntry("PROCESSOR", 77);

//        employeeDao.deleteEmployee(78);
//        employeeDao.addNewEmployee(78, 0, "Петров", "Василий", "+380995665874", "","","","","",0);
//        employeeDao.modify(78, 1, "Петров", "uuu", "+380995665874", "","","","","",1);
//

//        System.out.println("All processors");
//        processorDao.loadAllList().forEach(System.out::println);

//        employeeController.getAllEmployees().forEach(System.out::println);
//        System.out.println(employeeController.getEmployeeById(78));
    }

    public void setProcessorDao(JdbcSmallTableDao processorDao) {
        this.processorDao = processorDao;
    }


        public void setEmployeeController(EmployeeController employeeController) {
        this.employeeController = employeeController;
    }


    public void setHddDao(JdbcSmallTableDao hddDao) {
        this.hddDao = hddDao;
    }

    public void setEmployeeDao(JdbcEmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }

    public void setMonitorModelDao(JdbcSmallTableDao monitorModelDao) {
        this.monitorModelDao = monitorModelDao;
    }

    public void setMotherboardDao(JdbcSmallTableDao motherboardDao) {
        this.motherboardDao = motherboardDao;
    }

    public void setSsdDao(JdbcSmallTableDao ssdDao) {
        this.ssdDao = ssdDao;
    }

    public void setVideoCardDao(JdbcSmallTableDao videoCardDao) {
        this.videoCardDao = videoCardDao;
    }

    public void setComputerDao(JdbcComputerDao computerDao) {
        this.computerDao = computerDao;
    }

    public void setProcessorToComputerDao(JdbcProcessorToComputerDao processorToComputerDao) {
        this.processorToComputerDao = processorToComputerDao;
    }

    public void setHddToComputerDao(JdbcHddToComputerDao hddToComputerDao) {
        this.hddToComputerDao = hddToComputerDao;
    }

    public void setSsdToComputerDao(JdbcSsdToComputerDao ssdToComputerDao) {
        this.ssdToComputerDao = ssdToComputerDao;
    }

    public void setVideoCardToComputerDao(JdbcVideoCardToComputerDao videoCardToComputerDao) {
        this.videoCardToComputerDao = videoCardToComputerDao;
    }
}

