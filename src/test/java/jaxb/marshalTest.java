package jaxb;

import contracts.*;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.Unmarshaller;
import mylist.MyContractList;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.time.LocalDate;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class marshalTest {

    @Test
    public static void main(String[] args) {
        MyContractList<Contract> listContract = new MyContractList<>();
        System.out.println("startup");
        Person p1 = new Person("Valentina", LocalDate.of(2001, 11, 18), 'w');
        Person p2 = new Person("Alex", LocalDate.of(2000, 2, 28), 'm');
        MobileContract mb1 = new MobileContract(0, LocalDate.of(2019, 11, 10),
                LocalDate.of(2022, 11, 10), 0, p1, 100, 10, 4);
        MobileContract mb2 = new MobileContract(1, LocalDate.of(2020, 11, 10),
                LocalDate.of(2023, 11, 10), 1, p2, 100, 10, 4);
        listContract.add(mb1);
        listContract.add(mb2);
        ObjTransform.marshalContractList(listContract);

        InternetContract internetContract = new InternetContract(2,
                LocalDate.of(2018, 11, 10),
                LocalDate.of(2023, 11, 10), 22, p1, 400);
        ObjTransform.marshalInternetContract(internetContract);

        MobileContract mobileContract = new MobileContract(0, LocalDate.of(2019, 11, 10),
                LocalDate.of(2022, 11, 10), 0, p2, 200, 20, 2);
        ObjTransform.marshalMobileContract(mobileContract);

        ArrayList<Channels> channels = new ArrayList<>();
        channels.add(Channels.FOX);
        channels.add(Channels.RAIN);
        channels.add(Channels.WINTER);
        TVContract contract = new TVContract(1, LocalDate.of(2018, 1, 1),
                LocalDate.of(2022, 10, 10), 2, p1, channels);
        ObjTransform.marshalTVContract(contract);
    }

}