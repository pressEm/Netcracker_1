import java.util.Iterator;

/**
 * An iterator for lists that allows the programmer to traverse the list
 *
 * @param <T> the type of elements in this ArrayList
 * @autor Valentina Filonova
 */
public class MyArrayIterator<T> implements Iterator<T> {

    /**
     *
     */
    private int index;
    private T[] values;

    public MyArrayIterator(T[] values){
        this.values = values;
    }

    @Override
    public boolean hasNext() {
        return index<values.length;
    }

    @Override
    public T next() {
        return values[index++];
    }
}
