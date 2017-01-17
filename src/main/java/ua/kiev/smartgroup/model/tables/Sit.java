package ua.kiev.smartgroup.model.tables;

/**
 * Created by SleepWalker on 23.12.2016.
 */
public class Sit extends BaseTable{

    private String name;
    private int idOffice;
    private int idEmployee;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getIdOffice() {
        return idOffice;
    }

    public void setIdOffice(int idOffice) {
        this.idOffice = idOffice;
    }

    public int getIdEmployee() {
        return idEmployee;
    }

    public void setIdEmployee(int idEmployee) {
        this.idEmployee = idEmployee;
    }

    @Override
    public String toString() {
        return "Sit{" +
                "id=" + id +
                "name='" + name + '\'' +
                ", idOffice=" + idOffice +
                ", idEmployee=" + idEmployee +
                '}';
    }
}
