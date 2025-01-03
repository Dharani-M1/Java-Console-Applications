import java.util.ArrayList;
import java.util.Scanner;

public class AdminActions {

    public void addUser(Scanner sc) {
        System.out.print("Enter new username: ");
        String username = sc.nextLine();

        // Check if the user already exists
        for (User user : ATMSystem.getUsers()) {
            if (user.getUsername().equals(username)) {
                System.out.println("User already exists!");
                return;
            }
        }

        System.out.print("Enter new password: ");
        String password = sc.nextLine();

        // Add the new user to the system
        ATMSystem.getUsers().add(new User(username, password));
        System.out.println("User added successfully.");
    }


    public void deleteUser(Scanner sc) {
        System.out.print("Enter username to delete: ");
        String username = sc.nextLine();

        User userToDelete = null;
        for (User user : ATMSystem.getUsers()) {
            if (user.getUsername().equals(username)) {
                userToDelete = user;
                break;
            }
        }

        if (userToDelete != null) {
            ATMSystem.getUsers().remove(userToDelete);
            System.out.println("User deleted successfully.");
        } else {
            System.out.println("User not found.");
        }
    }


    public void viewUsers() {
        System.out.println("Registered Users:");
        for (User user : ATMSystem.getUsers()) {
            System.out.println("->" + user.getUsername());
        }
    }


    public void viewAtmBalance() {
        System.out.println("ATM Balance: " + ATMSystem.getAtmbalance());
    }


public void depositAtmBalance(Scanner sc, Admin admin) {
    System.out.print("Enter deposit amount: ");
    double amount = Double.parseDouble(sc.nextLine());

    if (amount > 0) {
        System.out.println("Enter denomination counts:");
        System.out.print("2000: ");
        int count2000 = Integer.parseInt(sc.nextLine());
        System.out.print("500: ");
        int count500 = Integer.parseInt(sc.nextLine());
        System.out.print("200: ");
        int count200 = Integer.parseInt(sc.nextLine());
        System.out.print("100: ");
        int count100 = Integer.parseInt(sc.nextLine());

        if ((count2000*2000+count500 * 500 + count200 * 200 + count100 * 100) == amount) {
            ATMSystem.getNotes().add(new Notes(2000, count2000));
            ATMSystem.getNotes().add(new Notes(500, count500));
            ATMSystem.getNotes().add(new Notes(200, count200));
            ATMSystem.getNotes().add(new Notes(100, count100));


            ATMSystem.setAtmbalance(ATMSystem.getAtmbalance() + amount);
            ATMSystem.getTransactions().add(new Transaction("withdraw",amount));
            System.out.println("Deposit successful!");
        } else {
            System.out.println("Invalid denominations. Deposit failed.");
        }
    } else {
        System.out.println("Invalid amount entered.");
    }
}
















    public void viewUserTransactions(Scanner sc) {
        System.out.print("Enter the username to view transactions: ");
        String username = sc.nextLine();

        User user = null;
        for (User u : ATMSystem.getUsers()) {
            if (u.getUsername().equals(username)) {
                user = u;
                break;
            }
        }

        if (user != null) {
            System.out.println("Transaction history for " + username + ":");
            if (user.getTransactions().isEmpty()) {
                System.out.println("No transactions found.");
            } else {
                for (Transaction transaction : user.getTransactions()) {
                    System.out.println(transaction);
                }
            }
        } else {
            System.out.println("User not found.");
        }
    }


    public void viewAdminTransactions(Scanner sc) {
        System.out.print("Enter Admin Username to view transactions: ");
        String adminUsername = sc.nextLine();

        Admin admin = null;
        for (Admin a : ATMSystem.getAdmins()) {
            if (a.getAdminName().equals(adminUsername)) {
                admin = a;
                break;
            }
        }

        if (admin != null) {
            System.out.println("Transaction history for Admin " + adminUsername + ":");
            if (admin.getTransactions().isEmpty()) {
                System.out.println("No transactions found.");
            } else {
                for (Transaction transaction : admin.getTransactions()) {
                    System.out.println(transaction);
                }
            }
        } else {
            System.out.println("Admin not found.");
        }
    }
}
