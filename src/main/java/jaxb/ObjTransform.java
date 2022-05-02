package jaxb;

import contracts.*;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.Unmarshaller;
import mylist.MyContractList;
import java.io.File;
import java.time.LocalDate;
import java.util.ArrayList;

public class ObjTransform {

    public static void marshalContractList() {
        JAXBContext jaxbContext = null;
        try {
            jaxbContext = JAXBContext.newInstance(MyContractList.class);
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            MyContractList<Contract> listContract = new MyContractList<>();
            System.out.println("startup");
            Person p1 = new Person("Valentina", LocalDate.of(2001, 11, 18), 'w');
            Person p2 = new Person("Alex", LocalDate.of(2000, 2, 28), 'm');
            MobileContract mb1 = new MobileContract(0, LocalDate.of( 2019, 11, 10),
                    LocalDate.of(2022, 11, 10), 0, p1, 100, 10, 4);
            MobileContract mb2 = new MobileContract(1, LocalDate.of(2020, 11, 10),
                    LocalDate.of(2023, 11, 10), 1, p2, 100, 10, 4);
            listContract.add(mb1);
            listContract.add(mb2);
            jaxbMarshaller.marshal(listContract, new File("D:\\ProgaChill\\Netcracker_1\\test\\contractList.xml"));
            jaxbMarshaller.marshal(listContract, System.out);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }

    public static void marshalContractList(MyContractList<Contract> listContract) {
        JAXBContext jaxbContext = null;
        try {
            jaxbContext = JAXBContext.newInstance(MyContractList.class);
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            jaxbMarshaller.marshal(listContract, new File("D:\\ProgaChill\\Netcracker_1\\test\\contractList.xml"));
            jaxbMarshaller.marshal(listContract, System.out);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }

    public static void marshalInternetContract() {
        JAXBContext jaxbContext = null;
        try {
            jaxbContext = JAXBContext.newInstance(InternetContract.class);
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            Person p = new Person("Alex", LocalDate.of(2000, 11, 10), "m");
            InternetContract internetContract = new InternetContract(2,
                    LocalDate.of(2018, 11, 10),
                    LocalDate.of(2023, 11, 10), 22, p, 400);
            jaxbMarshaller.marshal(internetContract, new File("D:\\ProgaChill\\Netcracker_1\\test\\internetContract.xml"));
            jaxbMarshaller.marshal(internetContract, System.out);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }

    public static void marshalInternetContract(InternetContract internetContract) {
        JAXBContext jaxbContext = null;
        try {
            jaxbContext = JAXBContext.newInstance(InternetContract.class);
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            jaxbMarshaller.marshal(internetContract, new File("D:\\ProgaChill\\Netcracker_1\\test\\internetContract.xml"));
            jaxbMarshaller.marshal(internetContract, System.out);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }

    public static void marshalMobileContract() {
        JAXBContext jaxbContext = null;
        try {
            jaxbContext = JAXBContext.newInstance(MobileContract.class);
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            Person p = new Person("Alex", LocalDate.of(2000, 11, 10), "m");
            MobileContract mobileContract = new MobileContract(0, LocalDate.of(2019, 11, 10),
                    LocalDate.of(2022, 11, 10), 0, p, 200, 20, 2);
            jaxbMarshaller.marshal(mobileContract, new File("D:\\ProgaChill\\Netcracker_1\\test\\mobileContract.xml"));
            jaxbMarshaller.marshal(mobileContract, System.out);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }

    public static void marshalMobileContract(MobileContract mobileContract) {
        JAXBContext jaxbContext = null;
        try {
            jaxbContext = JAXBContext.newInstance(MobileContract.class);
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            jaxbMarshaller.marshal(mobileContract, new File("D:\\ProgaChill\\Netcracker_1\\test\\mobileContract.xml"));
            jaxbMarshaller.marshal(mobileContract, System.out);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }

    public static void marshalTVContract() {
        JAXBContext jaxbContext = null;
        try {
            jaxbContext = JAXBContext.newInstance(TVContract.class);
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            ArrayList<Channels> channels = new ArrayList<>();
            channels.add(Channels.FOX);
            channels.add(Channels.RAIN);
            channels.add(Channels.WINTER);
            Person p = new Person("Alex", LocalDate.of(2000, 11, 10), "m");
            TVContract contract = new TVContract(1, LocalDate.of(2018, 1, 1),
                    LocalDate.of(2022, 10, 10), 2, p, channels);
            jaxbMarshaller.marshal(contract, new File("D:\\ProgaChill\\Netcracker_1\\test\\TVContract.xml"));
            jaxbMarshaller.marshal(contract, System.out);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }

    public static void marshalTVContract(TVContract contract) {
        JAXBContext jaxbContext = null;
        try {
            jaxbContext = JAXBContext.newInstance(TVContract.class);
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            jaxbMarshaller.marshal(contract, new File("D:\\ProgaChill\\Netcracker_1\\test\\TVContract.xml"));
            jaxbMarshaller.marshal(contract, System.out);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }

    public static InternetContract unMarshalInternetContract() {
        JAXBContext jaxbContext = null;
        try {
            jaxbContext = JAXBContext.newInstance(InternetContract.class);
            File file = new File("D:\\ProgaChill\\Netcracker_1\\test\\internetContract.xml");
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            InternetContract o = (InternetContract) jaxbUnmarshaller.unmarshal(file);
            System.out.println(o);
            return o;
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static MobileContract unMarshalMobileContract() {
        JAXBContext jaxbContext = null;
        try {
            jaxbContext = JAXBContext.newInstance(MobileContract.class);
            File file = new File("D:\\ProgaChill\\Netcracker_1\\test\\mobileContract.xml");
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            MobileContract o = (MobileContract) jaxbUnmarshaller.unmarshal(file);
            System.out.println(o);
            return o;
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static TVContract unMarshalTVContract() {
        JAXBContext jaxbContext = null;
        try {
            jaxbContext = JAXBContext.newInstance(TVContract.class);
            File file = new File("D:\\ProgaChill\\Netcracker_1\\test\\TVContract.xml");
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            TVContract o = (TVContract) jaxbUnmarshaller.unmarshal(file);
            System.out.println(o);
            return o;
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static MyContractList <Contract> unMarshalContractList() {
        JAXBContext jaxbContext = null;
        try {
            jaxbContext = JAXBContext.newInstance(MyContractList.class);
            File file = new File("D:\\ProgaChill\\Netcracker_1\\test\\contractList.xml");
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            MyContractList <Contract> o = (MyContractList<Contract>) jaxbUnmarshaller.unmarshal(file);
            System.out.println("object: " + o);
            return o;
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return null;
    }


    public static void marshalPerson() {
        JAXBContext jaxbContext = null;
        try {
            jaxbContext = JAXBContext.newInstance(Person.class);
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            Person p = new Person("Alex", LocalDate.of(2000, 11, 10), "m");
            jaxbMarshaller.marshal(p, new File("D:\\ProgaChill\\Netcracker_1\\test\\person.xml"));
            jaxbMarshaller.marshal(p, System.out);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }

    public static Person unMarshalPerson() {
        JAXBContext jaxbContext = null;
        try {
            jaxbContext = JAXBContext.newInstance(Person.class);
            File file = new File("D:\\ProgaChill\\Netcracker_1\\test\\person.xml");
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            Person o = (Person) jaxbUnmarshaller.unmarshal(file);
            System.out.println(o);
            return o;
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return null;
    }

}
