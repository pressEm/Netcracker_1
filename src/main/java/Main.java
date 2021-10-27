import java.time.LocalDate;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Person p1 = new Person("Valentina", LocalDate.of(2001, 11, 18), 'w');
        Person p2 = new Person("Alex", LocalDate.of(2000, 2, 28), 'm');

        MobileContract c1 = new MobileContract(0,LocalDate.of(2019, 11, 10),
                LocalDate.of(2022, 11, 10), 0, p1, 100, 10, 4);
        InternetContract c2 = new InternetContract(1, LocalDate.of(2019, 11, 10),
                LocalDate.of(2022, 11, 10),
                1, p1, 300);
        TVContract c3 = new TVContract(2, LocalDate.of(2019, 12, 10),
                LocalDate.of(2022, 12, 10),
                2, p2, new ArrayList<Channels>());
        MyList<Contract> list = new MyContractList();
        list.add(new Contract[]{c1, c2, c3});
        for (Contract c : list) {
            System.out.println(c);
        }
        System.out.println("Number of contracts: " + list.size());
    }
}
