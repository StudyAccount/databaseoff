package ua.kiev.smartgroup.model.dao;

/**
 * Created by SleepWalker on 18.01.2017.
 */
public interface SitDao extends BaseTableDao {

    void addNewSit(int id, String name, int idOffice, int idEmployee);

    void modify(int id, String name, int idOffice, int idEmployee);
}
