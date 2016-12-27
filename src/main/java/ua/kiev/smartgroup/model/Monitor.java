package ua.kiev.smartgroup.model;

/**
 * Created by SleepWalker on 23.12.2016.
 */
public class Monitor {

    private int id;
    private String name;
    private int idMonitorModel;
    private String dateOfIncome;
    private float priceInUSD;
    private float priceInUAH;
    private int idEmployee;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getIdMonitorModel() {
        return idMonitorModel;
    }

    public void setIdMonitorModel(int idMonitorModel) {
        this.idMonitorModel = idMonitorModel;
    }

    public String getDateOfIncome() {
        return dateOfIncome;
    }

    public void setDateOfIncome(String dateOfIncome) {
        this.dateOfIncome = dateOfIncome;
    }

    public float getPriceInUSD() {
        return priceInUSD;
    }

    public void setPriceInUSD(float priceInUSD) {
        this.priceInUSD = priceInUSD;
    }

    public float getPriceInUAH() {
        return priceInUAH;
    }

    public void setPriceInUAH(float priceInUAH) {
        this.priceInUAH = priceInUAH;
    }

    public int getIdEmployee() {
        return idEmployee;
    }

    public void setIdEmployee(int idEmployee) {
        this.idEmployee = idEmployee;
    }
}