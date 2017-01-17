package ua.kiev.smartgroup.model.tables;

/**
 * Created by SleepWalker on 23.12.2016.
 */
public class ProcessorToComputer extends ForeignTable {

    private int idComputer;
    private int idProcessor;

    public int getIdComputer() {
        return idComputer;
    }

    public void setIdComputer(int idComputer) {
        this.idComputer = idComputer;
    }

    public int getIdProcessor() {
        return idProcessor;
    }

    public void setIdProcessor(int idProcessor) {
        this.idProcessor = idProcessor;
    }

    @Override
    public String toString() {
        return "ProcessorToComputer{" +
                "idComputer=" + idComputer +
                ", idProcessor=" + idProcessor +
                '}';
    }
}
