package sorting;

import comparators.MyComparator;
import contracts.Contract;
import mylist.MyList;

/**
 * Bubble sorting is used to arrange the list items
 *
 */
public class BubleSorter implements ISorter {
    /**
     * @param list1 - the list to be ordered
     * @param cmp - sorting criteria
     * @return ordered list
     */
    @Override
    public MyList<Contract> sort(MyList list1, MyComparator cmp) {
        MyList<Contract> list = list1;
        for (int i = 0; i < list.size(); i++) {
            for (int j = 1; j < list.size(); j++) {
                if (cmp.compare(list.get(j - 1), list.get(j)) < 0) {
                    System.out.println("i > j" + i + ' ' + j);
                    Contract c = list.get(j - 1);
                    list.remove(j - 1);
                    list.add(c, j);
                }
            }
        }
        return list;
    }
}