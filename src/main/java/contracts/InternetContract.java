package contracts;

import contracts.Contract;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlTransient;
import jakarta.xml.bind.annotation.XmlType;
import jakarta.xml.bind.annotation.adapters.XmlAdapter;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import jaxb.LocalDateAdapter;

import java.time.LocalDate;

/**
 * Class implemented extends contracts.Contract. It describes mobile
 *
 * @autor Valentina Filonova
 */
@XmlRootElement(name = "internetContract")
@XmlType(propOrder = {"connectionSpeed" })
public class InternetContract extends Contract {

    /**
     * Speed of the connection.
     */
    @XmlElement
    private int connectionSpeed;




//    private LocalDate start;
//    @XmlJavaTypeAdapter(LocalDateAdapter.class)
//    public void setStart(LocalDate start) {
//        this.start = start;
//    }
//    @Override
//    public LocalDate getStart() {
//        return start;
//    }
//
//
//
//
//    /**
//     * Сontract expiration date
//     */
////    @XmlElement
//    private LocalDate end;
//    @XmlJavaTypeAdapter(LocalDateAdapter.class)
//    public void setEnd(LocalDate end) {
//        this.end = end;
//    }
//    @Override
//    public LocalDate getEnd() {
//        return end;
//    }
//
//    /**
//     * Index of the contract
//     */
//    @XmlElement
//    private int id;
//    /**
//     * Num of the contract
//     */
//    @XmlElement
//    private int num;
//    /**
//     * The owner of the contract
//     */
////    @XmlElement
//    @XmlTransient
//    private Person owner;


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
//    public InternetContract(@XmlElement(name = "id") int id, @XmlJavaTypeAdapter(LocalDateAdapter.class) LocalDate start,
//                            @XmlJavaTypeAdapter(LocalDateAdapter.class) LocalDate end, @XmlElement(name = "num") int num,
//                            Person owner, @XmlElement(name = "connectionSpeed") int speed) {
//        super(id, start, end, num, owner);
//        this.connectionSpeed = speed;
//        System.out.println(id+" " + start + " " + " " + end+ " " + num);
//    }
    public InternetContract(int id, LocalDate start, LocalDate end, int num, Person owner, int speed) {
        super(id, start, end, num, owner);
//        this.id = id;
//        this.end = end;
//        this.num = num;
//        this.start = start;
        this.connectionSpeed = speed;
        System.out.println(id+" " + start + " " + " " + end+ " " + num);
    }

    public InternetContract() {
    }

    public int getConnectionSpeed() {
        return connectionSpeed;
    }

    @Override
    public String toString() {
        return "contracts.InternetContract {" +
                "id=" + super.getID() +
                ", start=" + super.getStart() +
                ", end=" + super.getEnd() +
                ", num=" + super.getNum() +
                ", owner=" + super.getOwner().getName() +
                ", connectionSpeed=" + connectionSpeed + '}';
    }
}
