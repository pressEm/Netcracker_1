import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class PersonTest {

    @Test
    void getName() {
        Person p1 = new Person("Valentina", LocalDate.of(2001, 11, 18), 'w');
        assertEquals("Valentina", p1.getName());
    }

    @Test
    void getAge() {
        Person p1 = new Person("Valentina", LocalDate.of(2001, 11, 18), 'w');
        assertEquals(19, p1.getAge());
    }
}