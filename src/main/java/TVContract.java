import java.time.LocalDate;

public class TVContract extends Contract {
    /**
     * Constructor - creating new contract.
     *
     * @param start of the contract
     * @param end   of the contract
     * @param id    of the contract
     * @param owner of the contract
     */
    public TVContract(LocalDate start, LocalDate end, int id, Person owner) {
        super(start, end, id, owner);
    }
}
