import contracts.*;
import mylist.MyContractList;
import mylist.MyList;
import org.junit.jupiter.api.*;
import predicates.FinishAfterDate;

import java.time.LocalDate;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class MyContractListTest {

    private MyList<Contract> listContract = new MyContractList<>();

    @Test
    void search() {
        Person p1 = new Person("Valentina", LocalDate.of(2001, 11, 18), 'w');
        Person p2 = new Person("Alex", LocalDate.of(2000, 2, 28), 'm');

        MobileContract c1 = new MobileContract(0, LocalDate.of(2019, 11, 10),
                LocalDate.of(2022, 11, 10), 10, p1, 100, 10, 4);
        InternetContract c2 = new InternetContract(1, LocalDate.of(2019, 9, 10),
                LocalDate.of(2022, 10, 10),
                11, p1, 300);
        TVContract c3 = new TVContract(2, LocalDate.of(2019, 12, 10),
                LocalDate.of(2022, 12, 10),
                22, p2, new ArrayList<Channels>());
        TVContract c4 = new TVContract(3, LocalDate.of(2018, 2, 20),
                LocalDate.of(2022, 1, 10),
                21, p2, new ArrayList<Channels>());
        MyList<Contract> list = new MyContractList();
        list.add(new Contract[]{c1, c2, c3, c4});
        for (Contract c : list) {
            System.out.println(c);
        }

        FinishAfterDate<IContract> isStartBefore = new FinishAfterDate<>();
        MyList<Contract> listSearch = list.search(isStartBefore);
        assertEquals(listSearch.get(0), c1);
        assertEquals(listSearch.get(1), c3);
        assertEquals(listSearch.size(), 2);
    }

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
