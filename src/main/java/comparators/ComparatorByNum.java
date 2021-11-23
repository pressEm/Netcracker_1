package comparators;

import contracts.Contract;

import java.util.Comparator;

/**
 *A comparison function, which imposes a total ordering on a collection of contracts.
 * @param <T> type of collection
 */
public class ComparatorByNum<T extends Contract> implements Comparator<T> {
    /**
     * Sorts contacts by number
     * @param c1 the first object to be compared.
     * @param c2 the second object to be compared.
     * @return a negative integer, zero, or a positive integer as the
     * first argument is less than, equal to, or greater than the
     * second.
     */
    @Override
    public int compare(Contract c1, Contract c2) {
        return c1.getNum() - c2.getNum();
    }
}
