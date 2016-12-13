package ua.kiev.smartgroup;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ua.kiev.smartgroup.model.jdbc.JdbcEmployeeDao;
import ua.kiev.smartgroup.model.EmployeeDao;


/**
 * Created by User on 23.11.2016.
 */
public class Main {
    public static final Logger LOGGER = LoggerFactory.getLogger(Main.class);


    public static void main(String[] args) {

        EmployeeDao employeeDao = new JdbcEmployeeDao();
        System.out.println("All employees");
        employeeDao.getAll().forEach(System.out::println);
        System.out.println("Employee with id 3");
        System.out.println(employeeDao.load(3));

    }


}

