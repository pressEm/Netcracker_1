import java.time.LocalDate;

/**
 * Class implemented extends Contract. It describes mobile
 * @autor Valentina Filonova
 */

public class InternetContract extends Contract {


    /**
     * Constructor - creating new mobile contract.
     * @param start of the contract
     * @param end of the contract
     * @param id of the contract
     * @param owner of the contract
     */
    public InternetContract(LocalDate start, LocalDate end, int id, Person owner) {
        super(start, end, id, owner);
    }
}
