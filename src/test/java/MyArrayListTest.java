import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MyArrayListTest {

    @Test
    void add() {
        MyList<String> listContract = new MyArrayList<>();
        String s1 = "first";
        String s2 = "second";
        String s3 = "third";
        listContract.add(s1);
        listContract.add(s2);
        listContract.add(s3);

        listContract.add("forth", 1);
        assertEquals("forth", listContract.get(1));
    }

    @Test
    void testAdd() {
        MyList<String> listContract = new MyArrayList<>();
        String s1 = "first";

        listContract.add(s1);
        assertEquals(1, listContract.size());
    }

    @Test
    void remove() {
        MyList<String> listContract = new MyArrayList<>();
        String s1 = "first";
        String s2 = "second";
        String s3 = "third";
        listContract.add(s1);
        listContract.add(s2);
        listContract.add(s3);

        listContract.remove(1);
        assertEquals(2, listContract.size());
        assertEquals("third", listContract.get(1));
    }

    @Test
    void get() {
        MyList<String> listContract = new MyArrayList<>();
        String s1 = "first";
        String s2 = "second";
        String s3 = "third";
        listContract.add(s1);
        listContract.add(s2);
        listContract.add(s3);

        assertEquals("second", listContract.get(1));
    }

    @Test
    void size() {
        MyList<String> listContract = new MyArrayList<>();
        String s1 = "first";
        String s2 = "second";
        String s3 = "third";
        listContract.add(s1);
        listContract.add(s2);
        listContract.add(s3);

        assertEquals(3, listContract.size());
    }
}