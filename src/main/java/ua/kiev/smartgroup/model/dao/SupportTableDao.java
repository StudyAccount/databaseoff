package ua.kiev.smartgroup.model.dao;

/**
 * Created by SleepWalker on 17.01.2017.
 */
public interface SupportTableDao<T> {

    void newEntry(int idBaseTable, int idSmallTable);

    void deleteEntry(int idBaseTable);

    void modify(int idBaseTable, int idSmallTable);

    T loadByBaseTableId(int idBaseTable);

}
