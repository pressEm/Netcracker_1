package comparators;

import contracts.Contract;

import java.util.Comparator;

/**
 *A comparison function, which imposes a total ordering on a collection of contracts.
 * @param <T> type of collection
 */
public class ComparatorByDateEnd<T extends Contract> implements Comparator<T> {
    /**
     * Sorts contacts by number
     * @param c1 the first object to be compared.
     * @param c2 the second object to be compared.
     * @return a negative integer, or a positive integer as the
     * first argument is less than, or greater than the
     * second.
     */
    @Override
    public int compare(Contract c1, Contract c2) {
        if (c1.getEnd().isBefore(c2.getEnd())) {
            return -1;
        } else
            return 1;
    }
}
