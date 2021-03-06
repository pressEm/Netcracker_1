import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import contracts.*;
import mylist.MyContractList;
import mylist.MyList;
import validation.*;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.StringWriter;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class LoadCSV {
    private String ADDRESS_FILE;
    private List<String[]> allElements = new ArrayList<>();
    private MyList<Contract> repo = new MyContractList<>();

    public LoadCSV(String ADDRESS_FILE, MyList<Contract> repo) {
        this.ADDRESS_FILE = ADDRESS_FILE;
        this.repo = repo;
    }

    public List<ValidatorMessage> readCSVFile() throws IOException {
        try {
//            CSVReader reader = new CSVReader(new FileReader(ADDRESS_FILE));
//            String[] nextLine;
            CSVReader reader2 = new CSVReader(new FileReader(ADDRESS_FILE));
            allElements = reader2.readAll();
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }

        StringWriter sw = new StringWriter();
        CSVWriter writer = new CSVWriter(sw);
        writer.writeAll(allElements);

        System.out.println("\n\nGenerated CSV File:\n");
        System.out.println(sw.toString());
        System.out.println("_________________________________________________________________");

        List<ValidatorMessage> messages = new ArrayList<>();
        for (int i = 0; i < allElements.size(); i++) {
            messages.add(addContract(allElements.get(i)));
        }
        return messages;
    }

    private ValidatorMessage addContract(String[] str) throws DateTimeException, NumberFormatException {
        ValidatorMessage message = new ValidatorMessage();
        message.setStatus(Status.OK);
        if (str.length == 5) {
            String[] date_birth = str[1].split("\\.");
            String[] param = str[4].split(" ");
            String[] date_start = param[0].split("\\.");
            String[] date_end = param[1].split("\\.");
            try {
                Person p = new Person(str[0], LocalDate.of(Integer.parseInt(date_birth[2]), Integer.parseInt(date_birth[1]), Integer.parseInt(date_birth[0])), str[2].charAt(0));
//                System.out.println(p);
                Contract c;
                switch (str[3]) {
                    case "Internet":
                        c = new InternetContract(repo.size(), LocalDate.of(Integer.parseInt(date_start[2]),
                                Integer.parseInt(date_start[1]), Integer.parseInt(date_start[0])), LocalDate.of(Integer.parseInt(date_end[2]),
                                Integer.parseInt(date_end[1]), Integer.parseInt(date_end[0])), Integer.parseInt(param[2]), p, Integer.parseInt(param[3]));
                        InternetContractValidator validator = new InternetContractValidator();
                        if (validator.validate(c).getStatus().equals(Status.OK)){
                            repo.add(c);
                        } else{
                            message = validator.validate(c);
                        }
                        break;
                    case "TV":
                        String[] channels = param[3].split("\\|");
                        List<Channels> listChannels = new ArrayList<>();
                        for (int i = 0; i < channels.length; i++) {
                            listChannels.add(Channels.valueOf(channels[i]));
                        }
                        c = new TVContract(repo.size(), LocalDate.of(Integer.parseInt(date_start[2]),
                                Integer.parseInt(date_start[1]), Integer.parseInt(date_start[0])), LocalDate.of(Integer.parseInt(date_end[2]),
                                Integer.parseInt(date_end[1]), Integer.parseInt(date_end[0])), Integer.parseInt(param[2]), p, listChannels);
                        TVContractValidator validator2 = new TVContractValidator();
                        if (validator2.validate(c).getStatus().equals(Status.OK)){
                            repo.add(c);
                        } else{
                            message = validator2.validate(c);
                        }
                        break;
                    case "Mobile":
                        c = new MobileContract(repo.size(), LocalDate.of(Integer.parseInt(date_start[2]),
                                Integer.parseInt(date_start[1]), Integer.parseInt(date_start[0])), LocalDate.of(Integer.parseInt(date_end[2]),
                                Integer.parseInt(date_end[1]), Integer.parseInt(date_end[0])), Integer.parseInt(param[2]),
                                p, Integer.parseInt(param[3]), Integer.parseInt(param[4]), Integer.parseInt(param[5]));
                        MobileContractValidtor validator3 = new MobileContractValidtor();
                        if (validator3.validate(c).getStatus().equals(Status.OK)){
                            repo.add(c);
                        } else{
                            message = validator3.validate(c);
                        }
                        break;
                }
            } catch (DateTimeException | NumberFormatException ex) {
                System.out.println("INVALID DATA FORMAT: " + ex.getMessage());
            }
        }else System.out.println("INCORRECT NUMBERS OF CONTRACT PARAMETERS IN THE CSV FILE");
        return message;
    }
}