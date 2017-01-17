package ua.kiev.smartgroup.model.dao;

/**
 * Created by SleepWalker on 23.12.2016.
 */
public interface ComputerDao extends BaseTableDao{


    void addNewComputer(int id, String name, int idMotherboard,  String ram, String dateOfIncome, float priceInUSD,
                        float priceInUAH, int idEmployee);

    void modify(int id, String name, int idMotherboard,  String ram, String dateOfIncome, float priceInUSD,
                float priceInUAH, int idEmployee);

}
