package sorting;

import comparators.MyComparator;
import contracts.Contract;
import mylist.MyList;

import java.util.Comparator;

/**
 * Interface is used to sort contracts
 * @autor Valentina Filonova
 */
public interface ISorter<T extends Contract> {
    public MyList<T> sort(MyList<T> list, MyComparator cmp);
}
