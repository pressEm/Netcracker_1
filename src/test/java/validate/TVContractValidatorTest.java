package validate;

import contracts.*;
import org.junit.jupiter.api.Test;
import validation.Status;
import validation.TVContractValidator;
import validation.ValidatorMessage;

import java.time.LocalDate;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TVContractValidatorTest {

    @Test
    void compare() {
        Person p1 = new Person("Valentina", LocalDate.of(2001, 11, 18), 'w');
        Person p2 = new Person("Alex", LocalDate.of(2000, 2, 28), 'm');

        TVContract c1 = new TVContract(2, LocalDate.of(2019, 12, 10),
                LocalDate.of(2022, 12, 10),
                22, p2, new ArrayList<Channels>());
        TVContract c2 = new TVContract(2, LocalDate.of(2029, 12, 10),
                LocalDate.of(2022, 12, 10),
                22, p2, new ArrayList<Channels>());

        TVContractValidator validator = new TVContractValidator();
        validator.validate(c1);

        ValidatorMessage message1 = new ValidatorMessage();
        message1.setStatus(Status.OK);

        ValidatorMessage message2 = new ValidatorMessage();
        message2.setStatus(Status.ERROR);
        message2.addError("start", "Start date can`t be after end/current date");
        message2.addError("end", "End date can`t be before start/current date");

        assertEquals(validator.validate(c1).toString(), message1.toString());
        assertEquals(validator.validate(c2).toString(), message2.toString());
    }
}