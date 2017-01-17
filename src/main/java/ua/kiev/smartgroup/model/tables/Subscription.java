package ua.kiev.smartgroup.model.tables;

/**
 * Created by SleepWalker on 23.12.2016.
 */
public class Subscription extends BaseTable{

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Subscription{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
