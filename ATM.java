import java.util.Scanner;

class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposit successful. New balance: " + balance);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawal successful. New balance: " + balance);
        } else {
            System.out.println("Invalid withdrawal amount or insufficient funds.");
        }
    }
}

public class ATM {
    private BankAccount userAccount;

    public ATM(double initialBalance) {
        userAccount = new BankAccount(initialBalance);
    }

    public void displayMenu() {
        System.out.println("1. Check Balance");
        System.out.println("2. Deposit");
        System.out.println("3. Withdraw");
        System.out.println("4. Exit");
    }

    public void performTransaction(int choice, double amount) {
        switch (choice) {
            case 1:
                System.out.println("Current balance: " + userAccount.getBalance());
                break;
            case 2:
                userAccount.deposit(amount);
                break;
            case 3:
                userAccount.withdraw(amount);
                break;
            case 4:
                System.out.println("Exiting ATM. Thank you!");
                System.exit(0);
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter initial balance: ");
        double initialBalance = scanner.nextDouble();

        ATM atm = new ATM(initialBalance);

        while (true) {
            atm.displayMenu();

            System.out.print("Enter your choice (1-4): ");
            int choice = scanner.nextInt();

            if (choice == 4) {
                // Exit option
                break;
            }

            System.out.print("Enter amount: ");
            double amount = scanner.nextDouble();

            atm.performTransaction(choice, amount);
        }

        scanner.close();
    }
}
