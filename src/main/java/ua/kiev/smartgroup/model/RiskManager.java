package ua.kiev.smartgroup.model;

/**
 * Created by SleepWalker on 23.12.2016.
 */
public class RiskManager extends BaseTable{

    private int idEmployee;

    public int getIdEmployee() {
        return idEmployee;
    }

    public void setIdEmployee(int idEmployee) {
        this.idEmployee = idEmployee;
    }

    @Override
    public String toString() {
        return "RiskManager{" +
                "id=" + id +
                "idEmployee=" + idEmployee +
                '}';
    }
}
