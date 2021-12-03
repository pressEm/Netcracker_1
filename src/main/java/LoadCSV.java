import com.opencsv.CSVReader;
import contracts.*;
import mylist.MyContractList;
import mylist.MyList;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
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

    public void readCSVFile() throws IOException {
        try {
            CSVReader reader = new CSVReader(new FileReader(ADDRESS_FILE));
            String[] nextLine;

                while ((nextLine = reader.readNext()) != null) {
                    if (nextLine.length == 5) {
                    System.out.println("Name: [" + nextLine[0] + "]\nBirth date: [" + nextLine[1] +
                            "]\nSex: [" + nextLine[2] + "]\nType_contr: [" + nextLine[3] + "]\nParam_contr: [" + nextLine[4] + "]");
                }
            }
            CSVReader reader2 = new CSVReader(new FileReader(ADDRESS_FILE));
            allElements = reader2.readAll();
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }

//        StringWriter sw = new StringWriter();
//        CSVWriter writer = new CSVWriter(sw);
//        writer.writeAll(allElements);

//        System.out.println("\n\nGenerated CSV File:\n\n");
//        System.out.println(sw.toString());

        for (int i = 0; i < allElements.size(); i++) {
            addContract_1(allElements.get(i));
        }
    }

    private void addContract(String[] str) throws DateTimeException, NumberFormatException {
        if (str.length == 5) {
            String[] words = str[1].split("\\s*");
            for(String word : words){
                System.out.println(word);
            }
            String[] date_birth = str[1].split("\\.");
            System.out.println("ADD_CONTRACT");

//            for (String s: date_birth
//                 ) {
////                String text = "Егор Алла Александр";
////                System.out.print(s);
//                Pattern pattern = Pattern.compile("\\d{2}");
//                Matcher matcher = pattern.matcher(s);
//                while (matcher.find()) {
//                    System.out.println(s.substring(matcher.start(), matcher.end()));
//                }
//            }
            System.out.println("date_start: " + "|"+ str[4]);
//            Pattern pattern = Pattern.compile("\\d{2}");
//            Matcher matcher = pattern.matcher(str[4]);
//            while (matcher.find()) {
//                System.out.println("! " + str[4].substring(matcher.start(), matcher.end()));
//            }

            String[] param = str[4].split("\\s*");
            System.out.println("date_start: " + param[0]);

            String[] date_start = param[0].split("\\.");
//            System.out.println("date_start: " + date_start[0]);
//            for (String s: date_start
//            ) {
////                String text = "Егор Алла Александр";
////                System.out.print(s);
//                Pattern pattern_1 = Pattern.compile("\\d{2}");
//                Matcher matcher_1 = pattern_1.matcher(s);
//                while (matcher.find()) {
//                    System.out.println(s.substring(matcher.start(), matcher.end()));
//                }
//            }
            String[] date_end = param[1].split("\\.");
//            for (String s: date_start
//            ) {
////                String text = "Егор Алла Александр";
////                System.out.print(s);
//                Pattern pattern = Pattern.compile("\\d{2}");
//                Matcher matcher = pattern.matcher(s);
//                while (matcher.find()) {
//                    String string_date = s.substring(matcher.start(), matcher.end());
//                    System.out.println(s.substring(matcher.start(), matcher.end()));
//                    System.out.println(string_date + "  ))");
//                }
//            }
            try {
                Person p = new Person(str[0], LocalDate.of(Integer.parseInt(date_birth[2]), Integer.parseInt(date_birth[1]), Integer.parseInt(date_birth[0])), str[2].charAt(0));
                System.out.println(p);
                Contract c;
                switch (str[3]) {
                    case "Internet":
                        c = new InternetContract(repo.size(), LocalDate.of(Integer.parseInt(date_start[2]),
                                Integer.parseInt(date_start[1]), Integer.parseInt(date_start[0])), LocalDate.of(Integer.parseInt(date_end[2]),
                                Integer.parseInt(date_end[1]), Integer.parseInt(date_end[0])), Integer.parseInt(param[2]), p, Integer.parseInt(param[3]));
                        repo.add(c);
                        break;
                    case "TV":
                        String[] channels = param[3].split("\\|");
                        List<Channels> listChannels = new ArrayList<>();
                        for (int i = 0; i < channels.length; i++) {
                            System.out.println(channels[i]);
                            listChannels.add(Channels.valueOf(channels[i]));
                        }
                        c = new TVContract(repo.size(), LocalDate.of(Integer.parseInt(date_start[2]),
                                Integer.parseInt(date_start[1]), Integer.parseInt(date_start[0])), LocalDate.of(Integer.parseInt(date_end[2]),
                                Integer.parseInt(date_end[1]), Integer.parseInt(date_end[0])), Integer.parseInt(param[2]), p, listChannels);
                        repo.add(c);
                        break;
                    case "Mobile":
                        c = new MobileContract(repo.size(), LocalDate.of(Integer.parseInt(date_start[2]),
                                Integer.parseInt(date_start[1]), Integer.parseInt(date_start[0])), LocalDate.of(Integer.parseInt(date_end[2]),
                                Integer.parseInt(date_end[1]), Integer.parseInt(date_end[0])), Integer.parseInt(param[2]),
                                p, Integer.parseInt(param[3]), Integer.parseInt(param[4]), Integer.parseInt(param[5]));
                        repo.add(c);
                        break;
                }
            } catch (DateTimeException | NumberFormatException ex) {
                System.out.println("Invalid data format: " + ex.getMessage());
            }
        }else System.out.println("Incorrect number of parameters in the csv file");
    }
    private void addContract_1(String[] str) throws DateTimeException, NumberFormatException {
        if (str.length == 5) {
            String[] date_birth = str[1].split("\\.");
            String[] param = str[4].split(" ");
            System.out.println("date_start: " + param[1]);
            if (param[1].matches("\\d{2}-\\d{2}-\\d{4}")) {
                System.out.println("MATCHES");
            }
            String[] date_start = param[0].split("\\.");
            String[] date_end = param[1].split("\\.");
            try {
                Person p = new Person(str[0], LocalDate.of(Integer.parseInt(date_birth[2]), Integer.parseInt(date_birth[1]), Integer.parseInt(date_birth[0])), str[2].charAt(0));
                System.out.println(p);
                Contract c;
                switch (str[3]) {
                    case "Internet":
                        c = new InternetContract(repo.size(), LocalDate.of(Integer.parseInt(date_start[2]),
                                Integer.parseInt(date_start[1]), Integer.parseInt(date_start[0])), LocalDate.of(Integer.parseInt(date_end[2]),
                                Integer.parseInt(date_end[1]), Integer.parseInt(date_end[0])), Integer.parseInt(param[2]), p, Integer.parseInt(param[3]));
                        repo.add(c);
                        break;
                    case "TV":
                        String[] channels = param[3].split("\\|");
                        List<Channels> listChannels = new ArrayList<>();
                        for (int i = 0; i < channels.length; i++) {
                            System.out.println(channels[i]);
                            listChannels.add(Channels.valueOf(channels[i]));
                        }
                        c = new TVContract(repo.size(), LocalDate.of(Integer.parseInt(date_start[2]),
                                Integer.parseInt(date_start[1]), Integer.parseInt(date_start[0])), LocalDate.of(Integer.parseInt(date_end[2]),
                                Integer.parseInt(date_end[1]), Integer.parseInt(date_end[0])), Integer.parseInt(param[2]), p, listChannels);
                        repo.add(c);
                        break;
                    case "Mobile":
                        c = new MobileContract(repo.size(), LocalDate.of(Integer.parseInt(date_start[2]),
                                Integer.parseInt(date_start[1]), Integer.parseInt(date_start[0])), LocalDate.of(Integer.parseInt(date_end[2]),
                                Integer.parseInt(date_end[1]), Integer.parseInt(date_end[0])), Integer.parseInt(param[2]),
                                p, Integer.parseInt(param[3]), Integer.parseInt(param[4]), Integer.parseInt(param[5]));
                        repo.add(c);
                        break;
                }
            } catch (DateTimeException | NumberFormatException ex) {
                System.out.println("INVALID DATA FORMAT: " + ex.getMessage());
            }
        }else System.out.println("INCORRECT NUMBERS OF CONTRACT PARAMETERS IN THE CSV FILE");
    }
}