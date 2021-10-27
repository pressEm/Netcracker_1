import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ContractTest {

    @Test
    void getStart() {
        Person p1 = new Person("Valentina", LocalDate.of(2001, 11, 18), 'w');

        MobileContract mb1 = new MobileContract(0, LocalDate.of(2019, 11, 10),
                LocalDate.of(2022, 11, 10), 0, p1, 200, 20, 2);
        assertEquals(LocalDate.of(2019, 11, 10), mb1.getStart());
    }

    @Test
    void getEnd() {
        Person p1 = new Person("Valentina", LocalDate.of(2001, 11, 18), 'w');

        MobileContract mb1 = new MobileContract(0, LocalDate.of(2019, 11, 10),
                LocalDate.of(2022, 11, 10), 0, p1, 200, 20, 2);
        assertEquals(LocalDate.of(2022, 11, 10), mb1.getEnd());
    }

    @Test
    void getOwner() {
        Person p1 = new Person("Valentina", LocalDate.of(2001, 11, 18), 'w');

        MobileContract mb1 = new MobileContract(0, LocalDate.of(2019, 11, 10),
                LocalDate.of(2022, 11, 10), 0, p1, 200, 20, 2);
        assertEquals(p1, mb1.getOwner());
    }

    @Test
    void getID() {
        Person p1 = new Person("Valentina", LocalDate.of(2001, 11, 18), 'w');

        MobileContract mb1 = new MobileContract(0, LocalDate.of(2019, 11, 10),
                LocalDate.of(2022, 11, 10), 0, p1, 200, 20, 2);
        assertEquals(0, mb1.getID());
    }
}