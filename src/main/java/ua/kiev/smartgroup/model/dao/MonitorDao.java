package ua.kiev.smartgroup.model.dao;

/**
 * Created by SleepWalker on 18.01.2017.
 */
public interface MonitorDao extends BaseTableDao{

    void addNewMonitor(int id, String name, int idMonitorModel, String dateOfIncome, float priceInUSD, float priceInUAH,
                       int idEmployee);

    void modify(int id, String name, int idMonitorModel, String dateOfIncome, float priceInUSD, float priceInUAH,
                int idEmployee);

}
