package ua.kiev.smartgroup.model.dao;

/**
 * Created by SleepWalker on 18.01.2017.
 */
public interface RiskManagerDao extends BaseTableDao {

    void addNewRiskManager(int id, int idEmployee);

    void modify(int id, int idEmployee);


}

