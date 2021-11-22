package contracts;

import java.time.LocalDate;
import java.time.Period;

/**
 * contracts.Person representation class
 * @autor Valentina Filonova
 */
public class Person {
    /**
     * Name of the person
     */
    private String name;
    /**
     * Date of birth of the person
     */
    private LocalDate birthDate;
    /**
     * Sex of the person
     */
    private char sex;
    /**
     * Age of the person
     */
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
}
