import java.util.Iterator;

/***
 *  The user can access elements by their integer index, add, remove and search for elements in the list.
 * @param <T> the type of elements in this list
 * @autor Valentina Filonova
 */
public interface MyList<T> extends Iterable<T>{
    boolean add(T element);
    boolean add(T element, int index);
    void remove(int index);
    T get(int index);
    int size();
}
