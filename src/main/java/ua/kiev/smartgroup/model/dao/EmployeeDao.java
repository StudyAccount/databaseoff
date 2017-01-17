package ua.kiev.smartgroup.model.dao;

/**
 * Created by User on 13.12.2016.
 */
public interface EmployeeDao extends BaseTableDao{


    void addNewEmployee(int id, int idStatus, String lastName, String name, String phone,
                            String email, String address, String dateOfBirth, String dateOfSigningAContract,
                            String dateOfFirstTrade, int idRiskManager);

    void modify(int id, int idStatus, String lastName, String name, String phone,
                String email, String address, String dateOfBirth, String dateOfSigningAContract,
                String dateOfFirstTrade, int idRiskManager);
}
