import contracts.*;
import mylist.MyContractList;
import mylist.MyList;
import validation.CheckContract;
import validation.InternetContractValidator;
import validation.ValidatorMessage;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {
        Person p1 = new Person("Valentina", LocalDate.of(2001, 11, 18), 'w');
        Person p2 = new Person("Alex", LocalDate.of(2000, 2, 28), 'm');

        MobileContract c1 = new MobileContract(0, LocalDate.of(2019, 11, 10),
                LocalDate.of(2022, 11, 10), 10, p1, 100, 10, 4);
        InternetContract c2 = new InternetContract(1, LocalDate.of(2019, 9, 10),
                LocalDate.of(2022, 10, 10),
                11, p1, 300);
        TVContract c3 = new TVContract(2, LocalDate.of(2019, 12, 10),
                LocalDate.of(2022, 12, 10),
                22, p2, new ArrayList<Channels>());
        TVContract c4 = new TVContract(3, LocalDate.of(2018, 2, 20),
                LocalDate.of(2022, 1, 10),
                21, p2, new ArrayList<Channels>());
        MyList<Contract> list = new MyContractList();
        list.add(new Contract[]{c1, c2, c3, c4});
//        for (Contract c : list) {
//            System.out.println(c);
//        }
//        System.out.println("Number of contracts: " + list.size());

//        ComparatorByDateEnd cmp = new ComparatorByDateEnd();
//        ComparatorByNum cmpn = new ComparatorByNum();
//        SelectionSorter ss = new SelectionSorter();
//        BubleSorter bs = new BubleSorter();
//        MyList<Contract> listSorted = bs.sort(list, cmpn);
//        printList(listSorted);

//        FinishAfterDate<IContract> isStartBefore = new FinishAfterDate<>();
//        MyList<Contract> listSearch = list.search(isStartBefore);
//        printList(listSearch);

        LoadCSV data = new LoadCSV("AddAddr.csv", list);
        data.readCSVFile();

        InternetContract c7 = new InternetContract(7, LocalDate.of(2020, 9, 10),
                LocalDate.of(2012, 10, 10),
                -11, p1, -300);
        printList(list);


        InternetContractValidator validateContract = new InternetContractValidator();
        ValidatorMessage message = validateContract.validate(c7);
        System.out.println(message.toString());
        CheckContract contract = new CheckContract();
        System.out.println(contract.checkTVChannels(c3));
    }


    public static void printList(MyList<Contract> list){
        System.out.println("--- --- print --- ---");
        for (Contract c:list) {
            System.out.println(c);
        }
    }
}
