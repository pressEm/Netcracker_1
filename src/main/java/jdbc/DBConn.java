package jdbc;

import contracts.InternetContract;
import contracts.MobileContract;
import contracts.Person;
import contracts.TVContract;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.Properties;

public class DBConn {
    private Connection connection;

    public DBConn() {
        this.connection = getConnection();
    }

    private Connection getConnection() {
        FileInputStream dbp;
        Properties prop = new Properties();
        Connection conn = null;
        try {
            String PATH_TO_PROPERTIES = "src\\main\\DBConnection.properties";
            dbp = new FileInputStream(PATH_TO_PROPERTIES);
            prop.load(dbp);

        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            System.out.println(prop.getProperty("Database.DataURL"));
            conn = DriverManager.getConnection(prop.getProperty("Database.DataURL"));
            System.out.println("Database Connection established!");
        } catch (SQLException e) {
            System.out.println("Connection failed");
            e.printStackTrace();
        }

        return conn;
    }

    public void addPerson(Person person) {
        String sql = "INSERT INTO Persons (name, age, sex) VALUES (?,?,?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, person.getName());
            preparedStatement.setInt(2, 20);
            preparedStatement.setString(3, "w");
            preparedStatement.execute();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void addMobileContract(MobileContract contract, int id_person) {
        String sql = "INSERT INTO MobileContracts (start, end, owner, minutes, sms, gb) VALUES (?,?,?,?,?,?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, contract.getStart().toString());
            preparedStatement.setString(2, contract.getEnd().toString());
            preparedStatement.setInt(3, id_person);
            preparedStatement.setInt(4, contract.getMinutes());
            preparedStatement.setInt(5, contract.getSms());
            preparedStatement.setInt(6, contract.getGb());
            preparedStatement.execute();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addInternetContract(InternetContract contract, int id_person) {
        String sql = "INSERT INTO InternetContracts (start, end, owner, speed) VALUES (?,?,?,?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, contract.getStart().toString());
            preparedStatement.setString(2, contract.getEnd().toString());
            preparedStatement.setInt(3, id_person);
            preparedStatement.setInt(4, contract.getConnectionSpeed());
            preparedStatement.execute();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addTVContract(TVContract contract, int id_person) {
        System.out.println("Add tv contract to db...");
        String sql = "INSERT INTO TVContracts (start, end, owner) VALUES (?,?,?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, contract.getStart().toString());
            preparedStatement.setString(2, contract.getEnd().toString());
            preparedStatement.setInt(3, id_person);
            preparedStatement.execute();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        ArrayList<Integer> listIdContracts = getIdContractChannels(contract);
        for (int i = 0; i < listIdContracts.size(); i++) {
            try {
                PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO Contract_Channels VALUES(?,?)");
                preparedStatement.setInt(1, contract.getID());
                preparedStatement.setInt(2, listIdContracts.get(i));
                preparedStatement.execute();
                preparedStatement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public ArrayList<Integer> getIdContractChannels(TVContract contract) {
        ResultSet res = null;
        ArrayList<Integer> listID = new ArrayList<>();
        if (contract.getChannels() != null) {
            System.out.println("not null");
            for (int i = 0; i < contract.getChannels().size(); i++) {
                try {
                    PreparedStatement statement = connection.prepareStatement("select id_channel from Channels where channel = ?");
                    statement.setString(1, contract.getChannels().get(i).toString());
                    res = statement.executeQuery();
                    listID.add((Integer) res.getObject(1));
                    System.out.println(res.getString(1));
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        } else {
            System.out.println("null");
        }
        return listID;
    }

    public int getIdPerson(Person p) {
        int id = 0;
        String sql = "SELECT id_person FROM Persons WHERE name = ? ";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, p.getName());
            try (ResultSet res = preparedStatement.executeQuery()) {
                if (!res.next()) {
                    preparedStatement.close();
                    addPerson(p);
                    preparedStatement = connection.prepareStatement(sql);
                    preparedStatement.setString(1, p.getName());
                    preparedStatement.close();
                }
                id = res.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return id;
    }



}