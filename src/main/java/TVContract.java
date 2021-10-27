import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class TVContract extends Contract {

    private List<Channels> channels = new ArrayList();
    /**
     * Constructor - creating new contract.
     * @param id of the contract
     * @param start of the contract
     * @param end   of the contract
     * @param num    of the contract
     * @param owner of the contract
     */
    public TVContract(int id, LocalDate start, LocalDate end, int num, Person owner,  List<Channels> channels) {
        super(id, start, end, num, owner);
        this.channels = channels;
    }

    @Override
    public String toString() {
        return "TVContract {" +
                "id=" + super.getID() +
                ", start=" + super.getStart() +
                ", end=" + super.getEnd() +
                ", num=" + super.getNum() +
                ", owner=" + super.getOwner().getName() +
                ", channels=" + channels +
                '}';
    }
}
