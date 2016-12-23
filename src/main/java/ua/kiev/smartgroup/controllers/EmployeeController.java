package ua.kiev.smartgroup.controllers;


import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.Transactional;
import ua.kiev.smartgroup.model.Employee;
import ua.kiev.smartgroup.model.dao.EmployeeDao;

import java.util.List;

/**
 * Created by SleepWalker on 21.12.2016.
 */
public class EmployeeController {

    private PlatformTransactionManager txManager;
    private EmployeeDao employeeDao;

    @Transactional
    public List<Employee> getAllEmployees(){

       return employeeDao.getAllEmployees();

    }

    @Transactional
    public Employee getEmployeeById(int id){

        return employeeDao.loadEmployee(id);
    }


    public void setTxManager(PlatformTransactionManager txManager) {
        this.txManager = txManager;
    }

    public void setEmployeeDao(EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }
}
