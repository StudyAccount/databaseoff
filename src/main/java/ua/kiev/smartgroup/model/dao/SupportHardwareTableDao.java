package ua.kiev.smartgroup.model.dao;

/**
 * Created by SleepWalker on 17.01.2017.
 */
public interface SupportHardwareTableDao<T> {

    void newEntry(int idComputer, int idHardware);

    void deleteEntry(int idComputer);

    void modify(int idComputer, int idHardware);

    T loadByComputerId(int idComputer);

}
