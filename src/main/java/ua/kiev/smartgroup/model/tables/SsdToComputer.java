package ua.kiev.smartgroup.model.tables;

/**
 * Created by SleepWalker on 23.12.2016.
 */
public class SsdToComputer extends ForeignTable{

    private int idComputer;
    private int idSsd;

    public int getIdComputer() {
        return idComputer;
    }

    public void setIdComputer(int idComputer) {
        this.idComputer = idComputer;
    }

    public int getIdSsd() {
        return idSsd;
    }

    public void setIdSsd(int idSsd) {
        this.idSsd = idSsd;
    }

    @Override
    public String toString() {
        return "SsdToComputer{" +
                "idComputer=" + idComputer +
                ", idSsd=" + idSsd +
                '}';
    }
}
