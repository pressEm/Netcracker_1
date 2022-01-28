package validate;

import comparators.ComparatorByDateEnd;
import contracts.Channels;
import contracts.InternetContract;
import contracts.Person;
import contracts.TVContract;
import org.junit.jupiter.api.Test;
import validation.InternetContractValidator;
import validation.Status;
import validation.TVContractValidator;
import validation.ValidatorMessage;

import java.time.LocalDate;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

class InternetContractValidatorTest {

    @Test
    void compare() {
        Person p1 = new Person("Valentina", LocalDate.of(2001, 11, 18), 'w');
        Person p2 = new Person("Alex", LocalDate.of(2000, 2, 28), 'm');
        InternetContract c1 = new InternetContract(1, LocalDate.of(2019, 9, 10),
                LocalDate.of(2022, 10, 10),
                11, p1, 300);
        InternetContract c2 = new InternetContract(7, LocalDate.of(2020, 9, 10),
                LocalDate.of(2012, 10, 10),
                -11, p1, -300);

        InternetContractValidator validator = new InternetContractValidator();

        ValidatorMessage message1 = new ValidatorMessage();
        message1.setStatus(Status.OK);

        ValidatorMessage message2 = new ValidatorMessage();
        message2.setStatus(Status.ERROR);
        message2.addError("start", "Start date can`t be after end/current date");
        message2.addError("end", "End date can`t be before start/current date");
        message2.addError("num", "num can't be negative");
        message2.addError("speed", "speed can't be negative");

        assertEquals(validator.validate(c1).toString(), message1.toString());
        assertEquals(validator.validate(c2).toString(), message2.toString());
    }
}