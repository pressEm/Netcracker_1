import java.time.LocalDate;

/**
 * Class implemented extends Contract. It describes mobile
 *
 * @autor Valentina Filonova
 */

public class InternetContract extends Contract {

    /**
     * Speed of the connection.
     */
    private int connectionSpeed;

    /**
     * Constructor - creating new mobile contract.
     *
     * @param id    of the contract
     * @param start of the contract
     * @param end   of the contract
     * @param num   of the contract
     * @param owner of the contract
     * @param speed of the connection
     */
    public InternetContract(int id, LocalDate start, LocalDate end, int num, Person owner, int speed) {
        super(id, start, end, num, owner);
        this.connectionSpeed = speed;
    }

    public int getConnectionSpeed() {
        return connectionSpeed;
    }

    @Override
    public String toString() {
        return "InternetContract {" +
                "id=" + super.getID() +
                ", start=" + super.getStart() +
                ", end=" + super.getEnd() +
                ", num=" + super.getNum() +
                ", owner=" + super.getOwner().getName() +
                ", connectionSpeed=" + connectionSpeed + '}';
    }
}
