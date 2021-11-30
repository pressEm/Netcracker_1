package sorting;

import comparators.ComparatorByDateEnd;
import comparators.ComparatorByNum;
import contracts.*;
import mylist.MyContractList;
import mylist.MyList;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class BubleSorterTest {

    @Test
    void sort() {
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
        MyList<Contract> listCheck = new MyContractList();
        listCheck.add(new Contract[]{c4,c2,c1,c3});

        ComparatorByDateEnd cmp = new ComparatorByDateEnd();
        BubleSorter bs = new BubleSorter();
        MyList<Contract> listSorted = bs.sort(list, cmp);
        assertEquals(listSorted.get(0), listCheck.get(0));
        assertEquals(listSorted.get(1), listCheck.get(1));
        assertEquals(listSorted.get(2), listCheck.get(2));
        assertEquals(listSorted.get(3), listCheck.get(3));
    }
}