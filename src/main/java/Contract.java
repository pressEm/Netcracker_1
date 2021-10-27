import java.time.LocalDate;

/**
 * Abstract class implemented interface IContract
 * @see IContract
 * @autor Valentina Filonova
 */
public abstract class Contract implements IContract {
    /**
     * Start date of the contract
     */
    private LocalDate start;
    /**
     * Сontract expiration date
     */
    private LocalDate end;
    /**
     * Index of the contract
     */
    private int id;
    /**
     * Num of the contract
     */
    private int num;
    /**
     * The owner of the contract
     */
    private Person owner;

    /**
     * Constructor - creating new contract.
     * @param id of the contract
     * @param start of the contract
     * @param end of the contract
     * @param num of the contract
     * @param owner of the contract
     */
    public Contract(int id, LocalDate start, LocalDate end, int num, Person owner) {
        this.id = id;
        this.start = start;
        this.end = end;
        this.num = num;
        this.owner = owner;
    }

    /**
     * Function for getting the field value {@link Contract#start}.
     * @return start date
     */
    public LocalDate getStart() {
        return this.start;
    }

    /**
     * Function for getting the field value {@link Contract#end}.
     * @return expiration date
     */
    public LocalDate getEnd() {
        return this.end;
    }

    /**
     * Function for getting the field value {@link Contract#owner}.
     * @return Person who is the contract owner
     */
    public Person getOwner() {
        return this.owner;
    }

    /**
     * Assign an {@link Contract#owner}.
     * @param owner
     */
    public void setOwner(Person owner) {
        this.owner = owner;
    }

    /**
     * Function for getting the field value {@link Contract#id}
     * @return contract id
     */
    @Override
    public int getID() {
        return this.id;
    }

    /**
     * Overriding method, which provides a format for displaying contract information.
     * @return String with contract information
     */
    @Override
    public String toString() {
        return "Contract{" +
                "start=" + start +
                ", end=" + end +
                ", id=" + id +
                ", owner=" + owner +
                '}';
    }
}
