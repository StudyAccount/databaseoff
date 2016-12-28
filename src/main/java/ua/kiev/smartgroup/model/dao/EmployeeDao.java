package ua.kiev.smartgroup.model.dao;

import ua.kiev.smartgroup.model.Employee;

import java.util.List;

/**
 * Created by User on 13.12.2016.
 */
public interface EmployeeDao {

    Employee loadEmployee(int id);

    List<Employee> getAllEmployees();

    void addNewEmployee(int id, int idStatus, String lastName, String name, String phone,
                            String email, String address, String dateOfBirth, String dateOfSigningAContract,
                            String dateOfFirstTrade, int idRiskManager);

    Employee deleteEmployee();

    Employee modify();
}
