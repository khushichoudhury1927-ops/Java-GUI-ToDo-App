import java.util.ArrayList;

public class BankAccount {
    protected String accountHolder;
    protected String accountNumber;
    protected double balance;
    protected ArrayList<String> transactionHistory;

    public BankAccount(String accountHolder, String accountNumber, double initialBalance) {
        this.accountHolder = accountHolder;
        this.accountNumber = accountNumber;
        this.balance = initialBalance;
        this.transactionHistory = new ArrayList<>();
        transactionHistory.add("Account opened    | Opening Balance : Rs." + String.format("%.2f", initialBalance));
    }

    public void deposit(double amount) {
        if (amount <= 0) {
            System.out.println("Deposit amount has to be greater than zero.");
            return;
        }
        balance += amount;
        transactionHistory.add("Deposited         | +Rs." + String.format("%.2f", amount) + "  | Balance: Rs." + String.format("%.2f", balance));
        System.out.println("Rs." + String.format("%.2f", amount) + " deposited. New balance: Rs." + String.format("%.2f", balance));
    }

    public void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Withdrawal amount has to be greater than zero.");
            return;
        }
        if (amount > balance) {
            System.out.println("Not enough funds. Current balance: Rs." + String.format("%.2f", balance));
            return;
        }
        balance -= amount;
        transactionHistory.add("Withdrawn         | -Rs." + String.format("%.2f", amount) + "  | Balance: Rs." + String.format("%.2f", balance));
        System.out.println("Rs." + String.format("%.2f", amount) + " withdrawn. Remaining balance: Rs." + String.format("%.2f", balance));
    }

    public double getBalance() {
        return balance;
    }

    public String getAccountHolder() {
        return accountHolder;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void printStatement() {
        System.out.println("\n========== Statement: " + accountHolder + " (" + accountNumber + ") ==========");
        for (String entry : transactionHistory) {
            System.out.println("  " + entry);
        }
        System.out.println("================================================================\n");
    }

    public void displayInfo() {
        System.out.println("Holder          : " + accountHolder);
        System.out.println("Account Number  : " + accountNumber);
        System.out.println("Balance         : Rs." + String.format("%.2f", balance));
    }
}
