package ua.kiev.smartgroup.model.dao;

import ua.kiev.smartgroup.model.Hardware;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by SleepWalker on 27.12.2016.
 */
public interface HardwareDao<T>  extends BaseTableDao{

//    List<T> loadAllList();

    void addNewModel(int id, String name);
//
//    void deleteEntry(int id);
//
//    T loadByID(int id);

    void modify(int id, String name);

}
