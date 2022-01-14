package validate;

import contracts.MobileContract;
import contracts.Person;
import org.junit.jupiter.api.Test;
import validation.MobileContractValidtor;
import validation.Status;
import validation.ValidatorMessage;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MobileContractTest {

    @Test
    void compare() {
        Person p1 = new Person("Valentina", LocalDate.of(2001, 11, 18), 'w');
        Person p2 = new Person("Alex", LocalDate.of(2000, 2, 28), 'm');
        MobileContract c1 = new MobileContract(0, LocalDate.of(2019, 11, 10),
                LocalDate.of(2022, 11, 10), 10, p1, 100, 10, 4);
        MobileContract c2 = new MobileContract(0, LocalDate.of(2024, 11, 10),
                LocalDate.of(2022, 11, 10), -10, p1, -100, -10, -4);

        MobileContractValidtor validator = new MobileContractValidtor();

        ValidatorMessage message1 = new ValidatorMessage();
        message1.setStatus(Status.OK);

        ValidatorMessage message2 = new ValidatorMessage();
        message2.setStatus(Status.ERROR);
        message2.addError("start", "Start date can`t be after end/current date");
        message2.addError("end", "End date can`t be before start/current date");
        message2.addError("num", "num can't be negative");
        message2.addError("minutes", "minutes can't be negative");
        message2.addError("sms", "sms can't be negative");
        message2.addError("gb", "gb can't be negative");

        assertEquals(validator.validate(c1).toString(), message1.toString());
        assertEquals(validator.validate(c2).toString(), message2.toString());
    }
}
