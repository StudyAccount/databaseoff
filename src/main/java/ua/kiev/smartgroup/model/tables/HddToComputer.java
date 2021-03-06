package ua.kiev.smartgroup.model.tables;

/**
 * Created by SleepWalker on 23.12.2016.
 */
public class HddToComputer extends ForeignTable{

    private int idComputer;
    private int idHdd;

    public int getIdComputer() {
        return idComputer;
    }

    public void setIdComputer(int idComputer) {
        this.idComputer = idComputer;
    }

    public int getIdHdd() {
        return idHdd;
    }

    public void setIdHdd(int idHdd) {
        this.idHdd = idHdd;
    }

    @Override
    public String toString() {
        return "HddToComputer{" +
                "idComputer=" + idComputer +
                ", idHdd=" + idHdd +
                '}';
    }
}
