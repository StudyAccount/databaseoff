package ua.kiev.smartgroup.model.dao;

import ua.kiev.smartgroup.model.Computer;

import java.util.List;

/**
 * Created by SleepWalker on 23.12.2016.
 */
public interface ComputerDao extends BaseTableDao{

//    List<Computer> loadAllComputers();

//    Computer loadComputerByID(int id);

    void addNewComputer(int id, String name, int idMotherboard,  String ram, String dateOfIncome, float priceInUSD,
                        float priceInUAH, int idEmployee);

//    void deleteComputer(int id);

    void modify(int id, String name, int idMotherboard,  String ram, String dateOfIncome, float priceInUSD,
                float priceInUAH, int idEmployee);

}
