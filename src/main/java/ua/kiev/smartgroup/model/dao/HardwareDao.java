package ua.kiev.smartgroup.model.dao;


/**
 * Created by SleepWalker on 27.12.2016.
 */
public interface HardwareDao<T>  extends BaseTableDao{

    void addNewModel(int id, String name);

    void modify(int id, String name);

}
