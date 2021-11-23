import comparators.ComparatorByDateEnd;
import contracts.*;
import mylist.MyContractList;
import mylist.MyList;
import predicates.FinishAfterDate;
import predicates.FinishBeforeDate;
import predicates.StartBeforeDate;
import sorting.SelectionSorter;

import java.io.FileReader;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.function.Predicate;

public class TestCmp {
    public static void main(String[] args) {
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
        list.add(new Contract[]{c2, c3, c1, c4});
        for (Contract c : list) {
            System.out.println(c);
        }
        System.out.println("Number of contracts: " + list.size());
    }
}

