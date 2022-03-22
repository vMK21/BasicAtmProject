import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Scanner;

public class AtmOption extends Account {
    Scanner menuInput = new Scanner(System.in);
    DecimalFormat moneyFormat = new DecimalFormat("'$'###,##0.00");
    HashMap<Integer, Integer> userData = new HashMap<>();
    HashMap<Integer, Double> balanceData = new HashMap<>();
    DBConnect dbConnect = new DBConnect();

    public void Menu() throws IOException {
        int menuControl;
        System.out.println("Menu: ");
        System.out.println("1. Log to account");
        System.out.println("2. Register account");
        System.out.println("3. Exit");
        menuControl = menuInput.nextInt();

        switch (menuControl) {
            case 1:
                getID();
                getAccountValue();
                System.out.println();
                System.out.println("Please enter login: ");
                setCustomerNumber(menuInput.nextInt());
                System.out.println("Please enter password: ");
                setPinNumber(menuInput.nextInt());
                Login(getCustomerNumber(), getPinNumber());
                break;
            case 2:
                System.out.println("Welcome to registration!");
                System.out.println("Please enter your login: ");
                setCustomerNumber(menuInput.nextInt());
                System.out.println("Please enter password: ");
                setPinNumber(menuInput.nextInt());
                Register(getCustomerNumber(), getPinNumber());
                Menu();
                break;
            case 3:
                System.out.println("Thank you for using our program!");
                System.exit(0);
                break;
        }
    }

    public void Login(int login, int pin) throws IOException {
        boolean test = false;
        for (Entry<Integer, Integer> entry : userData.entrySet()) {
            if (entry.getKey() == login && entry.getValue() == pin) {
                test = true;
                System.out.println("Login succesful" + '\n');
                LoggedMenu();
            }
        }
        if (!test) {
            System.out.println("Wrong login or password" + "\n");
        }
    }

    public void Register(int login, int pin) {
        registerAccount(login, pin);
    }

    public void StartMenu() throws IOException {
        System.out.println();
        System.out.println("Welcome to ATM Project!");
        System.out.println("Created by vmk21" + "\n");
        Menu();
    }

    public void LoggedMenu() throws IOException {
        int menuControl;
        System.out.println("Menu: ");
        System.out.println("1. Check balance");
        System.out.println("2. Withdraw money");
        System.out.println("3. Deposit money");
        System.out.println("4. Exit to menu");
        menuControl = menuInput.nextInt();
        switch (menuControl) {
            case 1:
                getAccountValue();
                setAccountBalance(getCustomerNumber());
                System.out.println("Your currently balance is: " + moneyFormat.format(getBalance()));
                LoggedMenu();
                break;
            case 2:
                setAccountBalance(getCustomerNumber());
                updateBalance(getWitdrawMoney(), getCustomerNumber());
                LoggedMenu();
                break;
            case 3:
                setAccountBalance(getCustomerNumber());
                updateBalance(getInputDeposite(), getCustomerNumber());
                LoggedMenu();
                break;
            case 4:
                Menu();
        }
    }

    void getID() {
        ArrayList<Integer> login = new ArrayList<>();
        login = dbConnect.getLoginFromSql();
        ArrayList<Integer> PIN = new ArrayList<>();
        PIN = dbConnect.getPinFromSql();
        for (int i = 0; i < login.toArray().length; i++) {
            userData.put(login.get(i), PIN.get(i));
        }
    }

    void getAccountValue() {
        ArrayList<Integer> login = new ArrayList<>();
        login = dbConnect.getLoginFromSql();
        ArrayList<Double> balance = new ArrayList<>();
        balance = dbConnect.getBalanceFromSql();
        for (int i = 0; i < login.toArray().length; i++) {
            balanceData.put(login.get(i), balance.get(i));
        }
    }

    void setAccountBalance(int login) {
        for (Entry<Integer, Double> entry : balanceData.entrySet()) {
            if (entry.getKey() == login) {
                setBalance(entry.getValue());
            }
        }
    }

}