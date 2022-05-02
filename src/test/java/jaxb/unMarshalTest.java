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

public class unMarshalTest {
    @Test
    public static void main(String[] args) {
        Person p = ObjTransform.unMarshalPerson();
        InternetContract ic = ObjTransform.unMarshalInternetContract();
        TVContract tc = ObjTransform.unMarshalTVContract();
        MobileContract mc = ObjTransform.unMarshalMobileContract();
    }
}