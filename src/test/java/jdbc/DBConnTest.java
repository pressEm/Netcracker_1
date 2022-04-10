package jdbc;

import contracts.*;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;

class DBConnTest {
    DBConn conn = new DBConn();

    @Test
    void getConn() {
        conn = new DBConn();
    }

    @Test
    void addPerson() {
        Person p = new Person("Valentina", LocalDate.of(2000, 11, 10), 'm');
        conn.addPerson(p);
    }

    @Test
    void addTVTest() {
        ArrayList<Channels> channels = new ArrayList<>();
        channels.add(Channels.FOX);
        channels.add(Channels.RAIN);
        channels.add(Channels.WINTER);

        Person p = new Person("Alex", LocalDate.of(2000, 11, 10), 'm');
        TVContract contract = new TVContract(1, LocalDate.of(2018, 1, 1),
                LocalDate.of(2022, 10, 10), 2, p, channels);
        conn.addTVContract(contract, conn.getIdPerson(p));
    }

    @Test
    void addInternetTest() {
        Person p = new Person("Alex", LocalDate.of(2000, 11, 10), 'm');
        InternetContract internetContract = new InternetContract(2,
                LocalDate.of(2018, 11, 10),
                LocalDate.of(2023, 11, 10), 22, p, 400);
        conn.addInternetContract(internetContract, conn.getIdPerson(p));
    }

    @Test
    void addMobileTest() {
        Person p = new Person("Alex", LocalDate.of(2000, 11, 10), 'm');
        MobileContract mobileContract = new MobileContract(0, LocalDate.of(2019, 11, 10),
                LocalDate.of(2022, 11, 10), 0, p, 200, 20, 2);
        conn.addMobileContract(mobileContract, conn.getIdPerson(p));
    }
}