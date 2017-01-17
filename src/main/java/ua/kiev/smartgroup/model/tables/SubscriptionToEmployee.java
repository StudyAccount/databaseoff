package ua.kiev.smartgroup.model.tables;

/**
 * Created by SleepWalker on 23.12.2016.
 */
public class SubscriptionToEmployee extends ForeignTable {

    private int idEmployee;
    private int idSubscription;

    public int getIdEmployee() {
        return idEmployee;
    }

    public void setIdEmployee(int idEmployee) {
        this.idEmployee = idEmployee;
    }

    public int getIdSubscription() {
        return idSubscription;
    }

    public void setIdSubscription(int idSubscription) {
        this.idSubscription = idSubscription;
    }
}
