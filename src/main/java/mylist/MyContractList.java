package mylist;

import annotation.AutoInjectable;
import contracts.Contract;
import contracts.IContract;
import jakarta.xml.bind.annotation.*;
import jakarta.xml.bind.annotation.adapters.XmlAdapter;
import sorting.ISorter;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.function.Predicate;

/**
 * Resizable-array implementation of the {@code mylist.MyList} interface.
 * This class provides methods to manipulate the size of the array that is
 * used internally to store the list.
 *
 * @param <T> the type of elements in this ArrayList
 * @autor Valentina Filonova
 */
@XmlRootElement(name = "listContract")
@XmlAccessorType(XmlAccessType.FIELD)
public class MyContractList<T extends IContract> implements MyList {
    /**
     * Array storing list items
     */
    @XmlElement(name = "contracts")
    private T[] values;

    @XmlTransient
    public List<ISorter> getSorterList() {
        return sorterList;
    }

    @XmlTransient
    @AutoInjectable
    private List<ISorter> sorterList = new ArrayList<>();

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
        if (element == null) {
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
     * @param index   of addition
     * @param element to be appended to this list
     * @return true if operation success
     */
    @Override
    public boolean add(IContract element, int index) {
        T[] temp = values;
        values = (T[]) new Contract[temp.length + 1];
        System.arraycopy(temp, 0, values, 0, index);
        values[index] = (T) element;
        System.arraycopy(temp, index, values, index + 1, temp.length - index);
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
        if (index > values.length) {
            return;
        }
        T[] temp = values;
        values = (T[]) new Contract[temp.length - 1];
        System.arraycopy(temp, 0, values, 0, index);

        System.arraycopy(temp, index + 1, values, index, temp.length - index - 1);
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

    @Override
    public MyList search(Predicate predicate) {
        System.out.println("--- --- search --- ---");
        MyList<T> listSearch = new MyContractList<Contract>();
        for (T c : this.values) {
            if (c != null & predicate.test(c)) {
                listSearch.add(c);
            }
        }
        return listSearch;
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

    /**
     *
     * @param sorterName - name of class of sorting
     * @return sorted list of the contracts
     */

    public ISorter getSorter(String sorterName){
        ISorter result = null;
        for (ISorter sorter : sorterList) {
            System.out.println(sorter.getClass().getName());
            if (sorter.getClass().getName().equals(sorterName)) {
                result = sorter;
                break;
            }
        }
        return result;
    }
    public MyContractList sortByName(String sorterName, Comparator cmp) {
        ISorter result = getSorter(sorterName);
//        for (ISorter sorter : sorterList) {
//            System.out.println(sorter.getClass().getName());
//            if (sorter.getClass().getName().equals(sorterName)) {
//                result = sorter;
//                break;
//            }
//        }
        result.sort((Contract[]) values, cmp);
        return this;
    }

    static class Adapter extends XmlAdapter<MyContractList,MyList> {
        public MyList unmarshal(MyContractList v) {
            return v;
        }
        public MyContractList marshal(MyList v) { return (MyContractList) v; }
    }
}