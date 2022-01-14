package validate;

import contracts.*;
import org.junit.jupiter.api.Test;
import validation.CheckContract;

import java.time.LocalDate;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertTrue;

import static org.junit.jupiter.api.Assertions.assertFalse;

public class CheckContractTest {
    CheckContract checkContract = new CheckContract();

    @Test
    void check() {
        Person p1 = new Person("Valentina", LocalDate.of(2001, 11, 18), 'w');

        MobileContract c1 = new MobileContract(0, LocalDate.of(2019, 11, 10),
                LocalDate.of(2022, 11, 10), 0, p1, 200, 20, 2);
        MobileContract c2 = new MobileContract(0, LocalDate.of(2019, 11, 10),
                LocalDate.of(2022, 11, 10), 0, p1, -200, -20, -2);

        InternetContract c3 = new InternetContract(1, LocalDate.of(2019, 9, 10),
                LocalDate.of(2022, 10, 10),
                11, p1, 300);
        InternetContract c4 = new InternetContract(7, LocalDate.of(2020, 9, 10),
                LocalDate.of(2012, 10, 10),
                -11, p1, -300);

        TVContract c5 = new TVContract(2, LocalDate.of(2019, 12, 10),
                LocalDate.of(2022, 12, 10),
                22, p1, new ArrayList<Channels>());

        assertTrue(checkContract.checkStartDate(c1));
        assertTrue(checkContract.checkEndDate(c1));
        assertTrue(checkContract.checkOwner(c1));
        assertTrue(checkContract.checkMinutes(c1));
        assertTrue(checkContract.checkGb(c1));
        assertTrue(checkContract.checkGb(c1));
        assertFalse(checkContract.checkMinutes(c2));
        assertFalse(checkContract.checkGb(c2));
        assertFalse(checkContract.checkGb(c2));

        assertTrue(checkContract.checkSpeed(c3));
        assertFalse(checkContract.checkSpeed(c4));

        assertTrue(checkContract.checkTVChannels(c5));
    }
}
