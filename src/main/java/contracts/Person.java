package contracts;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import jaxb.DateAdapter;
import jaxb.LocalDateAdapter;

import java.time.LocalDate;
import java.time.Period;
import java.util.Date;

/**
 * contracts.Person representation class
 * @autor Valentina Filonova
 */
@XmlRootElement(name = "person")
@XmlType(propOrder = {"name", "ssex", "birthDate", "age" })
public class Person {
    /**
     * Name of the person
     */
    @XmlElement
    private String name;

    /**
     * Date of birth of the person
     */
    private LocalDate birthDate;

    /**
     * Sex of the person
     */
    @XmlElement
    private String  ssex;

    private char sex;
    /**
     * Age of the person
     */
    @XmlElement
    private int age;

    /**
     * Constructor - creating new person.
     * @param name
     * @param birthDate
     * @param sex
     */
    public Person(String name, LocalDate birthDate, char sex) {
        this.name = name;
        this.birthDate = birthDate;
        this.sex = sex;
        this.age = getAge(birthDate);
    }

    public Person(String name, LocalDate birthDate, String sex) {
        this.name = name;
        this.birthDate = birthDate;
        this.ssex = sex;
        this.age = getAge(birthDate);
    }

    public Person() {
    }

    /**
     * Age calculation function.
     * @param birthDate - date of birth of the person
     * @return age
     */
    private int getAge(LocalDate birthDate){
        Period period = Period.between(birthDate, LocalDate.now());
        return period.getYears();
    }

    /**
     * Overriding method, which provides a format for displaying person information.
     * @return String with person information
     */
    @Override
    public String toString() {
        return "contracts.Person{" +
                "name='" + name + '\'' +
                ", birthDate=" + birthDate +
                ", sex=" + sex +
                ", age=" + age +
                '}';
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }


    public LocalDate getBirthDate() {
        return birthDate;
    }

    @XmlJavaTypeAdapter(LocalDateAdapter.class)
    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }


//    public char getSex() {
//        return this.sex;
//    }
}
