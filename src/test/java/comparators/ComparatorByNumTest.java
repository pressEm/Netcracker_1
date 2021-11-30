package comparators;

import contracts.InternetContract;
import contracts.MobileContract;
import contracts.Person;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class ComparatorByNumTest {

    @Test
    void compare() {
        ComparatorByNum cmp = new ComparatorByNum();

        Person p1 = new Person("Valentina", LocalDate.of(2001, 11, 18), 'w');
        Person p2 = new Person("Alex", LocalDate.of(2000, 2, 28), 'm');

        MobileContract c1 = new MobileContract(0, LocalDate.of(2019, 11, 10),
                LocalDate.of(2022, 11, 10), 10, p1, 100, 10, 4);
        InternetContract c2 = new InternetContract(1, LocalDate.of(2019, 9, 10),
                LocalDate.of(2022, 10, 10),
                11, p1, 300);

        assertTrue(  cmp.compare(c1, c2)<0);
    }
}