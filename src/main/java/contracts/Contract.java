package contracts;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlTransient;
import jakarta.xml.bind.annotation.XmlType;
import jakarta.xml.bind.annotation.adapters.XmlAdapter;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import jaxb.LocalDateAdapter;

import java.time.LocalDate;

/**
 * Abstract class implemented interface contracts.IContract
 *
 * @autor Valentina Filonova
 * @see IContract
 */
@XmlRootElement(name = "contract")
@XmlType(propOrder = {"id", "start", "end", "num", "owner"})
public class Contract implements IContract {
    /**
     * Start date of the contract
     */

    private LocalDate start;

    @XmlJavaTypeAdapter(LocalDateAdapter.class)
    public void setStart(LocalDate start) {
        this.start = start;
    }

    /**
     * Сontract expiration date
     */
    private LocalDate end;

    @XmlJavaTypeAdapter(LocalDateAdapter.class)
    public void setEnd(LocalDate end) {
        this.end = end;
    }

    /**
     * Index of the contract
     */
    @XmlElement
    private int id;

    /**
     * Num of the contract
     */
    @XmlElement
    private int num;

    /**
     * The owner of the contract
     */
    @XmlTransient
    private Person owner;

    /**
     * Constructor - creating new contract.
     *
     * @param id    of the contract
     * @param start of the contract
     * @param end   of the contract
     * @param num   of the contract
     * @param owner of the contract
     */
    public Contract(int id, LocalDate start, LocalDate end, int num, Person owner) {
        this.id = id;
        this.start = start;
        this.end = end;
        this.num = num;
        this.owner = owner;
    }

    protected Contract() {
    }

    /**
     * Function for getting the field value {@link Contract#start}.
     *
     * @return start date
     */
    public LocalDate getStart() {
        return this.start;
    }

    /**
     * Function for getting the field value {@link Contract#end}.
     *
     * @return expiration date
     */
    public LocalDate getEnd() {
        return this.end;
    }

    /**
     * Function for getting the field value {@link Contract#owner}.
     *
     * @return contracts.Person who is the contract owner
     */
    public Person getOwner() {
        return this.owner;
    }

    /**
     * Function for getting the field value {@link Contract#num}
     *
     * @return contract id
     */

    public int getNum() {
        return this.num;
    }

    /**
     * Assign an {@link Contract#owner}.
     *
     * @param owner
     */
    public void setOwner(Person owner) {
        this.owner = owner;
    }

    /**
     * Function for getting the field value {@link Contract#id}
     *
     * @return contract id
     */
    @Override
    public int getID() {
        return this.id;
    }

    /**
     * Overriding method, which provides a format for displaying contract information.
     *
     * @return String with contract information
     */
    @Override
    public String toString() {
        return "contracts.Contract {" +
                "id=" + id +
                ", start=" + start +
                ", end=" + end +
                ", num=" + num +
                ", owner=" + owner +
                '}';
    }

    static class Adapter extends XmlAdapter<Contract, IContract> {
        public IContract unmarshal(Contract v) {
            return v;
        }

        public Contract marshal(IContract v) {
            return (Contract) v;
        }
    }
}
