import org.junit.jupiter.api.*;

import java.time.LocalDate;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class MyContractListTest {

    private MyList<Contract> listContract = new MyContractList<>();

    @BeforeEach
    void init() {
        System.out.println("startup");
        Person p1 = new Person("Valentina", LocalDate.of(2001, 11, 18), 'w');
        Person p2 = new Person("Alex", LocalDate.of(2000, 2, 28), 'm');
        MobileContract mb1 = new MobileContract(0, LocalDate.of( 2019, 11, 10),
                LocalDate.of(2022, 11, 10), 0, p1, 100, 10, 4);
        MobileContract mb2 = new MobileContract(1, LocalDate.of(2020, 11, 10),
                LocalDate.of(2023, 11, 10), 1, p2, 100, 10, 4);
        listContract.add(mb1);
        listContract.add(mb2);
    }

    @Test
    void add() {
        System.out.println("test add");
        Person p2 = new Person("Alex", LocalDate.of(2000, 2, 28), 'm');
        TVContract c3 = new TVContract(2, LocalDate.of(2019, 12, 10),
                LocalDate.of(2022, 12, 10),
                2, p2, new ArrayList<>());

        listContract.add(c3, 1);
        assertEquals(3, listContract.size());
    }


    @Test
    void testAdd() {
        Person p2 = new Person("Alex", LocalDate.of(2000, 2, 28), 'm');
        TVContract c3 = new TVContract(2, LocalDate.of(2019, 12, 10),
                LocalDate.of(2022, 12, 10),
                2, p2, new ArrayList<>());

        listContract.add(c3, 1);
        assertEquals(c3, listContract.get(1));
        assertEquals(3, listContract.size());
    }

    @Test
    void remove() {
        Person p2 = new Person("Alex", LocalDate.of(2000, 2, 28), 'm');
        TVContract c3 = new TVContract(2, LocalDate.of(2019, 12, 10),
                LocalDate.of(2022, 12, 10),
                2, p2, new ArrayList<Channels>());
        listContract.add(c3);

        listContract.remove(1);
        assertEquals(2, listContract.size());
        assertEquals(c3, listContract.get(1));
    }

    @Test
    void removeByID() {
        Person p2 = new Person("Alex", LocalDate.of(2000, 2, 28), 'm');
        TVContract c3 = new TVContract(2, LocalDate.of(2019, 12, 10),
                LocalDate.of(2022, 12, 10),
                2, p2, new ArrayList<Channels>());
        listContract.add(c3);

        listContract.removeByID(listContract.get(0).getID());
        assertEquals(2, listContract.size());
        assertEquals(c3, listContract.get(1));
    }

    @Test
    void get() {
        Person p2 = new Person("Alex", LocalDate.of(2000, 2, 28), 'm');
        TVContract c3 = new TVContract(2, LocalDate.of(2019, 12, 10),
                LocalDate.of(2022, 12, 10),
                2, p2, new ArrayList<Channels>());
        MyList<Contract> listContract = new MyContractList();
        listContract.add(c3);

        assertEquals(c3, listContract.get(2));
    }

    @Test
    void size() {
        Person p2 = new Person("Alex", LocalDate.of(2000, 2, 28), 'm');
        TVContract c3 = new TVContract(2, LocalDate.of(2019, 12, 10),
                LocalDate.of(2022, 12, 10),
                2, p2, new ArrayList<Channels>());
        listContract.add(c3);

        assertEquals(3, listContract.size());
    }
}
