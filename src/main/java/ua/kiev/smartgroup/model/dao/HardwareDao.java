package ua.kiev.smartgroup.model.dao;

import java.util.List;

/**
 * Created by SleepWalker on 27.12.2016.
 */
public interface HardwareDao<T> {

    List<T> loadAllList();

    T addNewModel();

    T deleteModel();

    T loadByID();

    T modify();

}
