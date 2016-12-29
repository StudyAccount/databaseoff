package ua.kiev.smartgroup;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ua.kiev.smartgroup.configuration.AppConfig;
import ua.kiev.smartgroup.controllers.EmployeeController;
import ua.kiev.smartgroup.model.jdbc.JdbcEmployeeDao;
import ua.kiev.smartgroup.model.jdbc.JdbcProcessorDao;


/**
 * Created by User on 23.11.2016.
 */
public class Main {

    private EmployeeController employeeController;
    private JdbcProcessorDao processorDao;
    private JdbcEmployeeDao employeeDao;


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


//        employeeDao.deleteEmployee(78);
//        employeeDao.addNewEmployee(78, 0, "Петров", "Василий", "+380995665874", "","","","","",0);
//        employeeDao.modify(78, 1, "Петров", "uuu", "+380995665874", "","","","","",1);
//

//        System.out.println("All processors");
//        processorDao.loadAllList().forEach(System.out::println);

//        employeeController.getAllEmployees().forEach(System.out::println);
//        System.out.println(employeeController.getEmployeeById(78));
    }

    public void setProcessorDao(JdbcProcessorDao processorDao) {
        this.processorDao = processorDao;
    }


        public void setEmployeeController(EmployeeController employeeController) {
        this.employeeController = employeeController;
    }


    public void setEmployeeDao(JdbcEmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }
}

