import java.sql.*;
import java.util.ArrayList;


public class DBConnect {

    public ArrayList getLoginFromSql() {
        ArrayList<Integer> login = new ArrayList<>();

        try {
            String host = "jdbc:mysql://localhost:3306/atmproject";
            String uName = "root";
            String uPass = "";
            Connection con = DriverManager.getConnection(host, uName, uPass);
            Statement statement = con.createStatement();
            String sql = "SELECT * FROM `atmlog`;";
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                login.add(rs.getInt("Login"));
            }
        } catch (SQLException err) {
            System.out.println(err.getMessage());
        }
        return login;
    }

    public ArrayList getPinFromSql() {
        ArrayList<Integer> PIN = new ArrayList<>();

        try {
            String host = "jdbc:mysql://localhost:3306/atmproject";
            String uName = "root";
            String uPass = "";
            Connection con = DriverManager.getConnection(host, uName, uPass);
            Statement statement = con.createStatement();
            String sql = "SELECT * FROM `atmlog`;";
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                PIN.add(rs.getInt("Pin"));
            }
            con.close();
        } catch (SQLException err) {
            System.out.println(err.getMessage());
        }
        return PIN;
    }

    public ArrayList getBalanceFromSql() {
        ArrayList<Double> Balance = new ArrayList<>();
        try {
            String host = "jdbc:mysql://localhost:3306/atmproject";
            String uName = "root";
            String uPass = "";
            Connection con = DriverManager.getConnection(host, uName, uPass);
            Statement statement = con.createStatement();
            String sql = "SELECT * FROM `atmlog`;";
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                Balance.add(rs.getDouble("Balance"));
            }
        } catch (SQLException err) {
            System.out.println(err.getMessage());
        }
        return Balance;
    }

    public void updateBalance(double Balance, int login) {
        try {
            String host = "jdbc:mysql://localhost:3306/atmproject";
            String uName = "root";
            String uPass = "";
            Connection con = DriverManager.getConnection(host, uName, uPass);
            PreparedStatement statement = con.prepareStatement("UPDATE atmlog SET Balance=" + Balance + " WHERE Login=" + login);
            statement.executeUpdate();
        } catch (SQLException err) {
            System.out.println(err.getMessage());
        }
    }

    public void registerAccount(int login, int PIN) {
        try {
            String host = "jdbc:mysql://localhost:3306/atmproject";
            String uName = "root";
            String uPass = "";
            Connection con = DriverManager.getConnection(host, uName, uPass);
            PreparedStatement statement = con.prepareStatement("INSERT INTO atmlog (`ID`,`Login`, `Pin`, `Balance`) VALUES(null," + login + "," + PIN + ", 0)");
            statement.executeUpdate();
        } catch (SQLException err) {
            System.out.println(err.getMessage());
        }
    }

}