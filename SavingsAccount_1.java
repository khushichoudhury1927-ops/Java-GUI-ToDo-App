public class SavingsAccount extends BankAccount {

    private double interestRate;
    private static final double MIN_BALANCE = 500.00;

    public SavingsAccount(String accountHolder, String accountNumber, double initialBalance, double interestRate) {
        super(accountHolder, accountNumber, initialBalance);
        this.interestRate = interestRate;
    }

    @Override
    public void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Withdrawal amount has to be greater than zero.");
            return;
        }
        if (balance - amount < MIN_BALANCE) {
            System.out.println("Can't withdraw Rs." + String.format("%.2f", amount)
                    + ". Balance would fall below the minimum required Rs." + String.format("%.2f", MIN_BALANCE) + ".");
            return;
        }
        balance -= amount;
        transactionHistory.add("Withdrawn         | -Rs." + String.format("%.2f", amount) + "  | Balance: Rs." + String.format("%.2f", balance));
        System.out.println("Rs." + String.format("%.2f", amount) + " withdrawn from savings. Remaining balance: Rs." + String.format("%.2f", balance));
    }

    public void applyInterest() {
        double interest = balance * (interestRate / 100);
        balance += interest;
        transactionHistory.add("Interest Applied  | +" + interestRate + "% = Rs." + String.format("%.2f", interest) + "  | Balance: Rs." + String.format("%.2f", balance));
        System.out.println("Interest applied at " + interestRate + "%. Rs." + String.format("%.2f", interest) + " added to your account.");
    }

    @Override
    public void displayInfo() {
        System.out.println("Type            : Savings Account");
        System.out.println("Holder          : " + accountHolder);
        System.out.println("Account Number  : " + accountNumber);
        System.out.println("Balance         : Rs." + String.format("%.2f", balance));
        System.out.println("Interest Rate   : " + interestRate + "% per annum");
        System.out.println("Minimum Balance : Rs." + String.format("%.2f", MIN_BALANCE));
    }
}
