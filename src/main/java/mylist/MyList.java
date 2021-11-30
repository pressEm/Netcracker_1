package mylist;

import contracts.Contract;
import contracts.IContract;

import java.util.function.Predicate;

/***
 * The user can access elements by their integer index, add, remove and search for elements in the list.
 * @param <T> the type of elements in this list
 * @autor Valentina Filonova
 */
public interface MyList<T extends IContract> extends Iterable<T>{
    boolean add(T element);
    boolean add(T element, int index);
    boolean add(T[] elements);
    void remove(int index);
    void removeByID(int id);
    T get(int index);
    int size();
    MyList<T> search(Predicate<T> predicate);
}
