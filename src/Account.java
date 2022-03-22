import java.text.DecimalFormat;
import java.util.Scanner;

public class Account extends DBConnect {
    Scanner input = new Scanner(System.in);
    DecimalFormat moneyFormat = new DecimalFormat("'$'###,##0.00");
    private int customerNumber;
    private int pinNumber;
    private double balance;

    public int getCustomerNumber() {
        return customerNumber;
    }

    public void setCustomerNumber(int customerNumber) {
        this.customerNumber = customerNumber;
    }

    public int getPinNumber() {
        return pinNumber;
    }

    public void setPinNumber(int pinNumber) {
        this.pinNumber = pinNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void withdrawMoney(double amount) {
        balance = (balance - amount);
    }

    public void depositMoney(double amount) {
        balance = (balance + amount);
    }

    public double getWitdrawMoney() {
        System.out.println("Amount you want to withdraw from account: ");
        double amount = input.nextDouble();
        if ((balance - amount) >= 0) {
            withdrawMoney(amount);
            System.out.println("New balance: " + moneyFormat.format(balance) + "\n");
        } else {
            System.out.println("Balance cannot be negative" + "\n");
        }
        return balance;
    }

    public double getInputDeposite() {
        System.out.println("Checking account balance: " + moneyFormat.format(balance));
        System.out.println("Amount you want to deposit to account: ");
        double amount = input.nextDouble();
        if ((balance + amount) >= 0) {
            depositMoney(amount);
            System.out.println("New balance: " + moneyFormat.format(balance) + "\n");
        } else {
            System.out.println("Balance cannot be negative" + "\n");
        }
        return balance;
    }
}
