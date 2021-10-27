import java.util.Iterator;

/**
 * Resizable-array implementation of the {@code MyList} interface.
 * This class provides methods to manipulate the size of the array that is
 * used internally to store the list.
 *
 * @param <T> the type of elements in this ArrayList
 * @autor Valentina Filonova
 */

public class MyContractList<T extends IContract> implements MyList {
    /**
     * Array storing list items
     */
    private T[] values;

    /**
     * Constructs an empty list
     */
    public MyContractList() {
        values = (T[]) new Contract[0];
    }

    /**
     * Appends the specified element to the end of this list.
     *
     * @param element to be appended to this list
     * @return true if operation success
     */
    @Override
    public boolean add(IContract element) {
        if (element == null){
            return false;
        }
        T[] temp = values;
        values = (T[]) new Contract[temp.length + 1];
        System.arraycopy(temp, 0, values, 0, values.length - 1);
        values[values.length - 1] = (T) element;
        return true;
    }

    /**
     * Appends the specified element to the at the specified position in this list.
     *
     * @param index of addition
     * @param element to be appended to this list
     * @return true if operation success
     */
    @Override
    public boolean add(IContract element, int index) {
        T[] temp = values;
        values = (T[]) new Contract[temp.length + 1];
        System.arraycopy(temp, 0, values, 0, index);
        values[index] = (T) element;
        System.arraycopy(temp, index, values,  index+1, temp.length-index);
        return true;
    }

    /**
     * Appends the elements to the end of this list.
     *
     * @param elements of addition
     * @return true if operation success
     */
    @Override
    public boolean add(IContract[] elements) {
        if (elements == null) {
            return false;
        }
        for (int i = 0; i < elements.length; i++) {
            add(elements[i]);
        }
        return true;
    }

    /**
     * Delete element tat the specified position in this list.
     *
     * @param index of deletions
     */
    @Override
    public void remove(int index) {
        if (index > values.length){
            return;
        }
        T[] temp = values;
        values = (T[]) new Contract[temp.length - 1];
        System.arraycopy(temp, 0, values, 0, index);

        System.arraycopy(temp, index+1, values,  index, temp.length-index-1);
    }

    /**
     * Delete element by id.
     *
     * @param id of contract to deletion
     */
    @Override
    public void removeByID(int id) {
        System.out.println("Deletion contract with id " + id + "...");
        for (int i = 0; i < values.length; i++) {
            if (values[i].getID() == id) {
               remove(i);
            }
        }
    }

    /**
     * Returns the element at the specified position in this list.
     *
     * @param index of element you want to get
     * @return the element at the specified position in this list
     */
    @Override
    public IContract get(int index) {
        return values[index];
    }

    /**
     * @return size of the list
     */
    @Override
    public int size() {
        return values.length;
    }

    /**
     * Returns an iterator over the elements in this list in proper sequence.
     *
     * @return an iterator over the elements in this list in proper sequence
     */
    @Override
    public Iterator<T> iterator() {
        return new MyContractIterator<>(values);
    }

}