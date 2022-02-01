import annotation.DependencyInjectionException;
import annotation.Injector;
import contracts.Contract;
import mylist.MyContractList;
import mylist.MyList;
import org.junit.jupiter.api.Test;
import validation.Status;
import validation.ValidatorMessage;
import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LoadCSVTest {

@Test
void readCSVFile() throws IOException, DependencyInjectionException, IllegalAccessException {
    MyList<Contract> list = new MyContractList();
    LoadCSV data = Injector.inject(new LoadCSV("AddAddr.csv", list));
    List<ValidatorMessage> messages = data.readCSVFile();

    ValidatorMessage message1 = new ValidatorMessage();
    ValidatorMessage message2 = new ValidatorMessage();
    message1.setStatus(Status.OK);
    message2.setStatus(Status.ERROR);
    message2.addError("minutes", "minutes can't be negative");
    message2.addError("sms", "sms can't be negative");
    message2.addError("gb", "gb can't be negative");

    assertEquals(messages.get(0).toString(), message1.toString());
    assertEquals(messages.get(1).toString(), message1.toString());
    assertEquals(messages.get(2).toString(), message1.toString());
    assertEquals(messages.get(3).toString(), message2.toString());
}
}