package sorting;

import contracts.Contract;
import mylist.MyContractList;
import mylist.MyList;
import validation.IValidator;

import java.util.Comparator;

/**
 * Bubble sorting is used to arrange the list items
 */
public class BubleSorter implements ISorter, IValidator {
    /**
     * @param list1 - the list to be ordered
     * @param cmp   - sorting criteria
     * @return ordered list
     */
    @Override
    public MyList<Contract> sort(MyList list1, Comparator cmp) {
        System.out.println("--- --- sort --- ---");
        MyList<Contract> list = new MyContractList<>();
        for (Object c : list1
        ) {
            list.add((Contract) c);
        }
        for (int i = 0; i < list.size(); i++) {
            for (int j = 1; j < list.size(); j++) {
                if (cmp.compare(list.get(j - 1), list.get(j)) > 0) {
                    Contract c = list.get(j - 1);
                    list.remove(j - 1);
                    list.add(c, j);
                }
            }
        }
        return list;
    }

    @Override
    public Contract[] sort(Contract[] arr, Comparator cmp) {
        System.out.println("--- --- sort --- ---");
        MyList<Contract> list = new MyContractList<>();
        for (int i = 1; i < arr.length; i++) {
            for (int j = 1; j < arr.length; j++) {
                if (cmp.compare(arr[j - 1], arr[j]) > 0) {
                    Contract c = arr[j - 1];
                    arr[j - 1] = arr[j];
                    arr[j] = c;
                }
            }
        }
        return arr;
    }
}