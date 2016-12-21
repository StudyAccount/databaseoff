package ua.kiev.smartgroup.controllers;


import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;
import ua.kiev.smartgroup.model.Employee;

import java.util.List;

/**
 * Created by SleepWalker on 21.12.2016.
 */
public class EmloyeeController {

    private PlatformTransactionManager txManager;

    public List<Employee> getAllEmoplyees(){
        TransactionStatus status =  txManager.getTransaction(new DefaultTransactionDefinition(TransactionDefinition.PROPAGATION_REQUIRED));


    }
}
