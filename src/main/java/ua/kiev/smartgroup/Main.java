package ua.kiev.smartgroup;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ua.kiev.smartgroup.configuration.AppConfig;
import ua.kiev.smartgroup.controllers.EmployeeController;


/**
 * Created by User on 23.11.2016.
 */
public class Main {

    private EmployeeController employeeController;


    public static void main(String[] args) {

        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);

        Main main = applicationContext.getBean(Main.class);
        main.start();

        //EmployeeDao employeeDao = applicationContext.getBean(JdbcEmployeeDao.class);
//
//        System.out.println("All employees");
//        employeeDao.getAll().forEach(System.out::println);
//        System.out.println("Employee with id 3");
//        System.out.println(employeeDao.load(3));

    }

    private void start(){

        employeeController.getAllEmployees().forEach(System.out::println);
        System.out.println(employeeController.getEmployeeById(3));
    }

    public void setEmployeeController(EmployeeController employeeController) {
        this.employeeController = employeeController;
    }
}

