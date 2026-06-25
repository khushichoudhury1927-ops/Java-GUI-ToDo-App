public class Main {

    public static void main(String[] args) {

        System.out.println("==============================================");
        System.out.println("          Welcome to ElevateBank             ");
        System.out.println("==============================================\n");

        SavingsAccount savings = new SavingsAccount("Priya Sharma", "SAV-1001", 5000.00, 4.5);
        CurrentAccount current = new CurrentAccount("Rahul Verma", "CUR-2001", 3000.00, 2000.00);

        System.out.println("--- Savings Account Details ---");
        savings.displayInfo();

        System.out.println("\n--- Current Account Details ---");
        current.displayInfo();

        System.out.println("\n\n========== Savings Account Transactions ==========");
        savings.deposit(2000);
        savings.withdraw(1000);
        savings.withdraw(6200);
        savings.applyInterest();
        savings.printStatement();

        System.out.println("========== Current Account Transactions ==========");
        current.deposit(500);
        current.withdraw(4000);
        current.withdraw(2500);
        current.printStatement();
    }
}
