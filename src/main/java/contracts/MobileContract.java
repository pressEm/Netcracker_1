package contracts;

import java.time.LocalDate;

/**
 * Class implemented extends contracts.Contract.
 * This class describes mobile communication contract with special fields such as minutes, sms, gb.
 * @see Contract
 * @autor Valentina Filonova
 */
public class MobileContract extends Contract {
    /**
     * Number of minutes
     */
    private  int minutes;

    /**
     * Number of messages
     */
    private int sms;

    /**
     * Number of gigabytes of internet
     */
    private int gb;

    /**
     * Constructor - create new mobile communication contract
     * @param id of the contract
     * @param start of the contract
     * @param end of the contract
     * @param owner of the contract
     * @param num of the contract
     * @param minutes of the contract
     * @param sms of the contract
     * @param gb of the contract
     */
    public MobileContract(int id, LocalDate start, LocalDate end, int num, Person owner, int minutes, int sms, int gb) {
        super(id, start, end, num, owner);
        this.minutes = minutes;
        this.sms = sms;
        this.gb = gb;
    }

    /**
     * Function for getting the field value {@link MobileContract#minutes}.
     * @return expiration date
     */
    public int getMinutes() {
        return minutes;
    }

    /**
     * Function for getting the field value {@link MobileContract#sms}.
     * @return expiration date
     */
    public int getSms() {
        return sms;
    }

    /**
     * Function for getting the field value {@link MobileContract#gb}.
     * @return expiration date
     */
    public int getGb() {
        return gb;
    }

    @Override
    public String toString() {
        return "contracts.MobileContract {" +
                "id=" + super.getID() +
                ", start=" + super.getStart() +
                ", end=" + super.getEnd() +
                ", num=" + super.getNum() +
                ", owner=" + super.getOwner().getName() +
                ", minutes=" + minutes +
                ", sms=" + sms +
                ", gb=" + gb +
                '}';
    }
}
