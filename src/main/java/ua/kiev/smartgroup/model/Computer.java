package ua.kiev.smartgroup.model;

/**
 * Created by SleepWalker on 23.12.2016.
 */
public class Computer {

    private int id;
    private String name;
    private int idMotherboard;
    private String ram;
    private String dateOfIncome;
    private float priceInUSD;
    private float priveInUAH;
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

    public int getIdMotherboard() {
        return idMotherboard;
    }

    public void setIdMotherboard(int idMotherboard) {
        this.idMotherboard = idMotherboard;
    }

    public String getRam() {
        return ram;
    }

    public void setRam(String ram) {
        this.ram = ram;
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

    public float getPriveInUAH() {
        return priveInUAH;
    }

    public void setPriveInUAH(float priveInUAH) {
        this.priveInUAH = priveInUAH;
    }

    public int getIdEmployee() {
        return idEmployee;
    }

    public void setIdEmployee(int idEmployee) {
        this.idEmployee = idEmployee;
    }
}
