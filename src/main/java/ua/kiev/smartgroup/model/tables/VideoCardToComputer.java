package ua.kiev.smartgroup.model.tables;

/**
 * Created by SleepWalker on 23.12.2016.
 */
public class VideoCardToComputer extends ForeignTable{

    private int idComputer;
    private int idVideoCard;

    public int getIdComputer() {
        return idComputer;
    }

    public void setIdComputer(int idComputer) {
        this.idComputer = idComputer;
    }

    public int getIdVideoCard() {
        return idVideoCard;
    }

    public void setIdVideoCard(int idVideoCard) {
        this.idVideoCard = idVideoCard;
    }
}
