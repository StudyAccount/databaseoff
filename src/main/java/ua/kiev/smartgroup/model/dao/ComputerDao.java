package ua.kiev.smartgroup.model.dao;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import ua.kiev.smartgroup.model.Computer;

import java.util.List;

/**
 * Created by SleepWalker on 23.12.2016.
 */
public interface ComputerDao {

    List<Computer> loadAllComputers();

    Computer addNewComputer();

    Computer deleteComputer();

    Computer loadComputer();

    Computer modify();

}
