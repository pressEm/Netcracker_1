package sorting;

import contracts.Contract;
import mylist.MyList;
import validation.IValidator;

import java.util.Comparator;

public class SelectionSorter implements ISorter, IValidator {
    /**
     * @param list1 - the list to be ordered
     * @param cmp   - sorting criteria
     * @return ordered list
     */
    @Override
    public MyList<Contract> sort(MyList list1, Comparator cmp) {
        System.out.println("--- --- sort --- ---");
        MyList<Contract> list = list1;
        for (int left = 0; left < list.size(); left++) {
            int minInd = left;
            for (int i = left; i < list.size(); i++) {
                if (cmp.compare(list.get(i), list.get(minInd)) < 0) {
                    minInd = i;
                }
            }
            Contract c = list.get(left);
            list.add(c, minInd);
            list.remove(left);

            Contract c1 = list.get(minInd);
            list.remove(minInd);
            list.add(c1, left);
        }
        return list;
    }

    @Override
    public Contract[] sort(Contract[] arr, Comparator cmp) {
        System.out.println("--- --- sort --- ---");
        for (int i = 1; i < arr.length; i++) {
            int minInd = i;
            for (int j = i; j < arr.length; j++) {
                if (cmp.compare(arr[j], arr[minInd]) < 0) {
                    minInd = j;
                }
            }
            Contract c1 = arr[minInd];
            arr[minInd] = arr[i];
            arr[i] = c1;
        }
        return arr;
    }
}
