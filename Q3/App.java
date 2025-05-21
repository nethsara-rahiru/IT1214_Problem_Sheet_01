import java.util.*;

class BankAccount {
    private int accountNumber;
    private String accountHolder;
    private double balance;

    void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    void setAccountHolder(String accountHolder) {
        this.accountHolder = accountHolder;
    }

    void setBalance(double balance) {
        this.balance = balance;
    }

    int getAccountNumber() {
        return accountNumber;
    }

    String getAccountHolder() {
        return accountHolder;
    }

    double getBalance() {
        return balance;
    }

    void withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
        } else {
            throw new IllegalArgumentException("Insufficient balance");
        }
    }
}

class Bank {
    int maxAccounts = 5;
    BankAccount[] accounts = new BankAccount[maxAccounts];

    void newAccount() {
        for (int i = 0; i < maxAccounts; i++) {
            if (accounts[i] == null) {
                Scanner scan = new Scanner(System.in);
                accounts[i] = new BankAccount();

                System.out.print("Enter Account Number: ");
                accounts[i].setAccountNumber(Integer.parseInt(scan.nextLine()));

                System.out.print("Enter Account Holder Name: ");
                accounts[i].setAccountHolder(scan.nextLine());

                System.out.print("Enter Initial Balance: ");
                accounts[i].setBalance(Double.parseDouble(scan.nextLine()));

                System.out.println("Account added successfully.");
                break;
            }
        }
    }

    void showAccounts() {
        System.out.println("");
        System.out.println("Account Details");
        System.out.println("-------------------------------------");

        for (int i = 0; i < maxAccounts; i++) {
            if (accounts[i] != null) {
                System.out.println("Account Number : " + accounts[i].getAccountNumber());
                System.out.println("Account Holder : " + accounts[i].getAccountHolder());
                System.out.println("Balance        : " + accounts[i].getBalance());
                System.out.println("-------------------------------------");
            }
        }
    }

    void withdrawFromAccount() {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter Account Number to withdraw from: ");
        int accNumber = Integer.parseInt(scan.nextLine());

        for (int i = 0; i < maxAccounts; i++) {
            if (accounts[i] != null && accounts[i].getAccountNumber() == accNumber) {
                System.out.print("Enter amount to withdraw: ");
                double amount = Double.parseDouble(scan.nextLine());

                try {
                    accounts[i].withdraw(amount);
                    System.out.println("Withdrawal successful. New balance: " + accounts[i].getBalance());
                } catch (IllegalArgumentException e) {
                    System.out.println("Error: " + e.getMessage());
                }
                return;
            }
        }
        System.out.println("Account not found.");
    }
}

public class App {
    public static void main(String[] args) {
        int system = 1;
        int input;

        Scanner scan = new Scanner(System.in);
        Bank bank = new Bank();

        while (system == 1) {
            System.out.println("");
            System.out.println("--------------------------------------------");
            System.out.println("Welcome to the Bank Account Manager");
            System.out.println("--------------------------------------------");
            System.out.println("Please select an option...");
            System.out.println(" 1 - Add a new Account");
            System.out.println(" 2 - Withdraw from Account");
            System.out.println(" 3 - Display Accounts");
            System.out.println(" 4 - Exit");

            System.out.print("Enter your choice: ");
            try {
                input = Integer.parseInt(scan.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Try again.");
                continue;
            }

            switch (input) {
                case 1:
                    bank.newAccount();
                    break;
                case 2:
                    bank.withdrawFromAccount();
                    break;
                case 3:
                    bank.showAccounts();
                    break;
                case 4:
                    system = 0;
                    System.out.println("Exiting Bank Account Manager.");
                    break;
                default:
                    System.out.println("Invalid option.");
            }
        }
    }
}
