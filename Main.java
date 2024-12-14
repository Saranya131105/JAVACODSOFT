import java.util.Scanner;

class BankAccount {
    private double balance;

    // Constructor to initialize balance
    public BankAccount(double initialBalance) {
        if (initialBalance >= 0) {
            balance = initialBalance;
        } else {
            balance = 0;
        }
    }

    // Method to check balance
    public double getBalance() {
        return balance;
    }

    // Method to deposit money
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited $" + amount + ". New balance: $" + balance);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    // Method to withdraw money
    public boolean withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrew $" + amount + ". New balance: $" + balance);
            return true;
        } else if (amount > balance) {
            System.out.println("Insufficient balance for withdrawal.");
            return false;
        } else {
            System.out.println("Invalid withdrawal amount.");
            return false;
        }
    }
}

class ATM {
    private BankAccount account;
    private Scanner scanner;

    // Constructor to initialize the ATM with a bank account
    public ATM(double initialBalance) {
        account = new BankAccount(initialBalance);
        scanner = new Scanner(System.in);
    }

    // Method to display the ATM menu
    public void displayMenu() {
        int choice;
        double amount;
        boolean transactionStatus;

        do {
            System.out.println("\nATM Menu: ");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Current balance: $" + account.getBalance());
                    break;

                case 2:
                    System.out.print("Enter deposit amount: $");
                    amount = scanner.nextDouble();
                    account.deposit(amount);
                    break;

                case 3:
                    System.out.print("Enter withdrawal amount: $");
                    amount = scanner.nextDouble();
                    transactionStatus = account.withdraw(amount);
                    if (!transactionStatus) {
                        System.out.println("Withdrawal failed.");
                    }
                    break;

                case 4:
                    System.out.println("Thank you for using the ATM. Goodbye!");
                    break;

                default:
                    System.out.println("Invalid option. Please select a valid choice.");
                    break;
            }
        } while (choice != 4);
    }
}

public class Main {
    public static void main(String[] args) {
        // Initial balance for the user's account
        double initialBalance = 1000.00;

        // Create ATM instance
        ATM atm = new ATM(initialBalance);

        // Display the ATM menu and allow user to interact
        atm.displayMenu();
    }
}

