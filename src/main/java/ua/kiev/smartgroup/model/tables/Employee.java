package ua.kiev.smartgroup.model.tables;

/**
 * Created by User on 13.12.2016.
 */
public class Employee extends BaseTable {

    private int idStatus;
    private String lastName;
    private String name;
    private String phone;
    private String email;
    private String address;
    private String dateOfBirth;
    private String dateOfSigningAContract;
    private String dateOfFirstTrade;
    private int idRiskManager;

    public int getIdStatus() {
        return idStatus;
    }

    public void setIdStatus(int idStatus) {
        this.idStatus = idStatus;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getDateOfSigningAContract() {
        return dateOfSigningAContract;
    }

    public void setDateOfSigningAContract(String dateOfSigningAContract) {
        this.dateOfSigningAContract = dateOfSigningAContract;
    }

    public String getDateOfFirstTrade() {
        return dateOfFirstTrade;
    }

    public void setDateOfFirstTrade(String dateOfFirstTrade) {
        this.dateOfFirstTrade = dateOfFirstTrade;
    }

    public int getIdRiskManager() {
        return idRiskManager;
    }

    public void setIdRiskManager(int idRiskManager) {
        this.idRiskManager = idRiskManager;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", idStatus=" + idStatus +
                ", lastName='" + lastName + '\'' +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                ", dateOfBirth='" + dateOfBirth + '\'' +
                ", dateOfSigningAContract='" + dateOfSigningAContract + '\'' +
                ", dateOfFirstTrade='" + dateOfFirstTrade + '\'' +
                ", idRiskManager=" + idRiskManager +
                '}';
    }
}
