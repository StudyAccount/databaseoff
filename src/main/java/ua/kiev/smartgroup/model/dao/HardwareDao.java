package ua.kiev.smartgroup.model.dao;

import java.util.List;

/**
 * Created by SleepWalker on 27.12.2016.
 */
public interface HardwareDao<T> {

    List<T> loadAllList();

    void addNewModel(int id, String name);

    void deleteModel(int id);

    T loadByID(int id);

    void modify(int id, String name);

}
