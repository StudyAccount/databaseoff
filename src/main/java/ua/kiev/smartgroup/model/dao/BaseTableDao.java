package ua.kiev.smartgroup.model.dao;

import java.util.List;

/**
 * Created by SleepWalker on 09.01.2017.
 */
public interface BaseTableDao<T> {

    List<T> loadAllList();
    
    void deleteEntry(int id);

    T loadByID(int id);
    
}
