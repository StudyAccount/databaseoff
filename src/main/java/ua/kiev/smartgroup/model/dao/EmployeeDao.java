package ua.kiev.smartgroup.model.dao;

import ua.kiev.smartgroup.model.Employee;

import java.util.List;

/**
 * Created by User on 13.12.2016.
 */
public interface EmployeeDao {

    Employee loadEmployee(int id);

    List<Employee> getAllEmployees();

    Employee addNewEmployee();

    Employee deleteEmployee();

    Employee modify();
}
