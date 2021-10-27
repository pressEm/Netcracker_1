import java.util.Iterator;

/**
 * An iterator for lists that allows the programmer to traverse the list
 *
 * @param <T> the type of elements in this ArrayList
 * @autor Valentina Filonova
 */
public class MyContractIterator<T extends IContract> implements Iterator<T> {

    /**
     * index of element
     * values in the array
     */
    private int index;
    private T[] values;

    /**
     *
     * @param values in the array
     */
    public MyContractIterator(T[] values){
        this.values = values;
    }

    /**
     * Returns true if the iteration has more elements.
     */
    @Override
    public boolean hasNext() {
        return index<values.length;
    }

    /**
     * Returns the next element in the iteration.
     * @return next object T
     */
    @Override
    public T next() {
        return values[index++];
    }
}
