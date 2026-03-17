import java.util.*;

class ATM {
    private int pin = 1234;
    private double balance = 5000;
    private List<String> miniStatement = new ArrayList<>();

    Scanner sc = new Scanner(System.in);

    // Verify PIN
    public boolean verifyPin() {
        System.out.print("Enter PIN: ");
        int enteredPin = sc.nextInt();
        return enteredPin == pin;
    }

    // Check Balance
    public void checkBalance() {
        if (verifyPin()) {
            System.out.println("Current Balance: ₹" + balance);
        } else {
            System.out.println("Invalid PIN!");
        }
    }

    // Deposit
    public void deposit() {
        System.out.print("Enter amount to deposit: ");
        double amount = sc.nextDouble();
        balance += amount;
        miniStatement.add("Deposited: ₹" + amount);
        System.out.println("Amount Deposited Successfully.");
    }

    // Withdraw
    public void withdraw() {
        if (verifyPin()) {
            System.out.print("Enter amount to withdraw: ");
            double amount = sc.nextDouble();

            if (amount <= balance) {
                balance -= amount;
                miniStatement.add("Withdrawn: ₹" + amount);
                System.out.println("Please collect your cash.");
            } else {
                System.out.println("Insufficient Balance!");
            }
        } else {
            System.out.println("Invalid PIN!");
        }
    }

    // Change PIN
    public void changePin() {
        if (verifyPin()) {
            System.out.print("Enter new PIN: ");
            pin = sc.nextInt();
            System.out.println("PIN changed successfully.");
        } else {
            System.out.println("Invalid PIN!");
        }
    }

    // Mini Statement
    public void miniStatement() {
        System.out.println("----- Mini Statement -----");
        for (String s : miniStatement) {
            System.out.println(s);
        }
    }

    // Transfer Amount
    public void transfer() {
        if (verifyPin()) {
            System.out.print("Enter receiver account number: ");
            long acc = sc.nextLong();

            System.out.print("Enter amount to transfer: ");
            double amount = sc.nextDouble();

            if (amount <= balance) {
                balance -= amount;
                miniStatement.add("Transferred ₹" + amount + " to Acc: " + acc);
                System.out.println("Transfer Successful.");
            } else {
                System.out.println("Insufficient Balance!");
            }
        } else {
            System.out.println("Invalid PIN!");
        }
    }
}

public class ATMApp {
    public static void main(String[] args) {

        ATM atm = new ATM();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n===== ATM MENU =====");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Change PIN");
            System.out.println("5. Mini Statement");
            System.out.println("6. Transfer Money");
            System.out.println("7. Exit");

            System.out.print("Choose option: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    atm.checkBalance();
                    break;

                case 2:
                    atm.deposit();
                    break;

                case 3:
                    atm.withdraw();
                    break;

                case 4:
                    atm.changePin();
                    break;

                case 5:
                    atm.miniStatement();
                    break;

                case 6:
                    atm.transfer();
                    break;

                case 7:
                    System.out.println("Thank you for using ATM!");
                    System.exit(0);

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}