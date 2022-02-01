package annotation;

import comparators.ComparatorByDateEnd;
import comparators.ComparatorByNum;
import contracts.*;
import mylist.MyContractList;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


class InjectorTest {

    @Test
    void getFieldsToInject() {
    }

    @Test
    void inject() {
    }

    @Test
    void injector() throws DependencyInjectionException, IllegalAccessException {
        MyContractList<Contract> listInj = Injector.inject(new MyContractList());
        MyContractList<Contract> list = new MyContractList<>();
        ComparatorByNum cmp = new ComparatorByNum();
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
        listInj.add(c1);
        listInj.add(c2);
        listInj.add(c3);
        listInj.add(c4);
        listInj.sortByName("sorting.SelectionSorter", cmp);
        assertNull(list.getSorter("sorting.SelectionSorter"));
        assertNotNull(listInj.getSorter("sorting.SelectionSorter"));
        assertEquals(2, listInj.getSorterList().size());
    }
}