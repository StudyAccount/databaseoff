package ua.kiev.smartgroup;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.mchange.v2.util.ComparatorUtils;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ua.kiev.smartgroup.configuration.AppConfig;
import ua.kiev.smartgroup.controllers.EmployeeController;
import ua.kiev.smartgroup.model.Computer;
import ua.kiev.smartgroup.model.jdbc.JdbcComputerDao;
import ua.kiev.smartgroup.model.jdbc.JdbcEmployeeDao;
import ua.kiev.smartgroup.model.jdbc.JdbcHardwareDao;


/**
 * Created by User on 23.11.2016.
 */
public class Main {

    private EmployeeController employeeController;
    private JdbcHardwareDao processorDao;
    private JdbcEmployeeDao employeeDao;
    private JdbcHardwareDao hddDao;
    private JdbcHardwareDao monitorModelDao;
    private JdbcHardwareDao motherboardDao;
    private JdbcHardwareDao ssdDao;
    private JdbcHardwareDao videoCardDao;
    private JdbcComputerDao computerDao;


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
        computerDao.loadAllList().forEach(System.out::println);
        computerDao.deleteEntry(22);
        System.out.printf("--------------------");
        System.out.println(computerDao.loadByID(3).toString());
        System.out.printf("--------------------");
//        computerDao.loadAllComputers().forEach(System.out::println);
//        computerDao.addNewComputer(22,"o",1,"ss","",0,0,2);
//        computerDao.loadAllComputers().forEach(System.out::println);
//        computerDao.deleteComputer(22);
//        computerDao.loadAllComputers().forEach(System.out::println);
//        Computer computer = computerDao.loadComputerByID(1);
//        System.out.println(computer);
        computerDao.loadAllList().forEach(System.out::println);
        computerDao.modify(22,"o",1,"qqqq","",0,0,2);
        computerDao.loadAllList().forEach(System.out::println);
//        processorDao.loadAllList().forEach(System.out::println);
//        hddDao.loadAllList("HDD").forEach(System.out::println);
//        monitorModelDao.loadAllList("MONITOR_MODEL").forEach(System.out::println);
//        motherboardDao.loadAllList("MOTHERBOARD").forEach(System.out::println);
//        ssdDao.loadAllList("SSD").forEach(System.out::println);
//        videoCardDao.loadAllList("VIDEOCARD").forEach(System.out::println);

//        Hardware processor  = processorDao.loadByID(1);
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

//        processorDao.addNewModel("PROCESSOR", 78,"jktym");
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

    public void setProcessorDao(JdbcHardwareDao processorDao) {
        this.processorDao = processorDao;
    }


        public void setEmployeeController(EmployeeController employeeController) {
        this.employeeController = employeeController;
    }


    public void setHddDao(JdbcHardwareDao hddDao) {
        this.hddDao = hddDao;
    }

    public void setEmployeeDao(JdbcEmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }

    public void setMonitorModelDao(JdbcHardwareDao monitorModelDao) {
        this.monitorModelDao = monitorModelDao;
    }

    public void setMotherboardDao(JdbcHardwareDao motherboardDao) {
        this.motherboardDao = motherboardDao;
    }

    public void setSsdDao(JdbcHardwareDao ssdDao) {
        this.ssdDao = ssdDao;
    }

    public void setVideoCardDao(JdbcHardwareDao videoCardDao) {
        this.videoCardDao = videoCardDao;
    }

    public void setComputerDao(JdbcComputerDao computerDao) {
        this.computerDao = computerDao;
    }
}

