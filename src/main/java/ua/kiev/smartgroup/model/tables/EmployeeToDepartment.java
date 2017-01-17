package ua.kiev.smartgroup.model.tables;

/**
 * Created by SleepWalker on 23.12.2016.
 */
public class EmployeeToDepartment extends ForeignTable{

    private int idEmployee;
    private int idDepartment;

    public int getIdEmployee() {
        return idEmployee;
    }

    public void setIdEmployee(int idEmployee) {
        this.idEmployee = idEmployee;
    }

    public int getIdDepartment() {
        return idDepartment;
    }

    public void setIdDepartment(int idDepartment) {
        this.idDepartment = idDepartment;
    }
}
