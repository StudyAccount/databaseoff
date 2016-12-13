package ua.kiev.smartgroup.model;

import java.util.List;

/**
 * Created by User on 13.12.2016.
 */
public interface EmployeeDao {
    Employee load(int id);

    List<Employee> getAll();
}
