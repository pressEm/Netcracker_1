package predicates;

import contracts.IContract;
import contracts.MobileContract;
import contracts.Person;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class FinishBeforeDateTest {

    @Test
    void test1() {
        FinishBeforeDate<IContract> isFinishBefore = new FinishBeforeDate<>();
        Person p1 = new Person("Valentina", LocalDate.of(2001, 11, 18), 'w');

        MobileContract c1 = new MobileContract(0, LocalDate.of(2019, 11, 10),
                LocalDate.of(2020, 11, 10), 10, p1, 100, 10, 4);

        MobileContract c2 = new MobileContract(0, LocalDate.of(2019, 11, 10),
                LocalDate.of(2022, 11, 10), 10, p1, 100, 10, 4);
        assertTrue(isFinishBefore.test(c1));
        assertFalse(isFinishBefore.test(c2));
    }
}