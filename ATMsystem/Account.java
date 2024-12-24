import java.util.ArrayList;

class Account {
    private String username;
    private int password;
    private double balance;
    private ArrayList<Transfer> transactionHistory;

    // Constructor
    public Account(String username, int password) {
        this.username = username;
        this.password = password;
        this.balance = 0.0;
        this.transactionHistory = new ArrayList<>();
    }

    public Account() {
    }

    // Getters and setters
    public String getUsername() {
        return username;
    }

    public int getPassword() {
        return password;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        this.balance += amount;
        transactionHistory.add(new Transfer("Deposit", amount));
        System.out.println("You have deposited amt "+amount +"Successfully");
    }

    public void withdraw(double amount) {
        if (balance >= amount) {
            this.balance -= amount;
            transactionHistory.add(new Transfer("Withdraw", amount));
            System.out.println("Successfully withdrawed the amount"+amount);
        } else {
            System.out.println("Insufficient balance!");
        }
    }
    public double viewbalance(){
        return this.balance;
    }

    public void viewTransactionHistory() {
        if (transactionHistory.isEmpty()) {
            System.out.println("No transactions found.");
        } else {
            for (Transfer transfer : transactionHistory) {
                System.out.println(transfer);
            }
        }
    }

}
