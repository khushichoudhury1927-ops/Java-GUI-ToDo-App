public class CurrentAccount extends BankAccount {

    private double overdraftLimit;

    public CurrentAccount(String accountHolder, String accountNumber, double initialBalance, double overdraftLimit) {
        super(accountHolder, accountNumber, initialBalance);
        this.overdraftLimit = overdraftLimit;
    }

    @Override
    public void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Withdrawal amount has to be greater than zero.");
            return;
        }
        if (amount > balance + overdraftLimit) {
            System.out.println("Transaction declined. Rs." + String.format("%.2f", amount)
                    + " exceeds your available limit (balance + overdraft: Rs." + String.format("%.2f", balance + overdraftLimit) + ").");
            return;
        }
        balance -= amount;
        transactionHistory.add("Withdrawn         | -Rs." + String.format("%.2f", amount) + "  | Balance: Rs." + String.format("%.2f", balance));
        System.out.println("Rs." + String.format("%.2f", amount) + " withdrawn from current account.");
        if (balance < 0) {
            System.out.println("Heads up! Your account is overdrawn by Rs." + String.format("%.2f", Math.abs(balance)) + ".");
        }
    }

    @Override
    public void displayInfo() {
        System.out.println("Type            : Current Account");
        System.out.println("Holder          : " + accountHolder);
        System.out.println("Account Number  : " + accountNumber);
        System.out.println("Balance         : Rs." + String.format("%.2f", balance));
        System.out.println("Overdraft Limit : Rs." + String.format("%.2f", overdraftLimit));
    }
}
