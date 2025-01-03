import java.util.Scanner;

public class ATMOperation {

    private AdminActions adminActions;
    private UserActions userActions;

    public ATMOperation() {
        this.adminActions = new AdminActions();
        this.userActions = new UserActions();

        // Initialize static fields in ATMSystem if needed
        ATMSystem.getAdmins().add(new Admin("admin", 1234));
        ATMSystem.getAdmins().add(new Admin("admin1", 1234));
    }

    public void start() {
        Scanner sc = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            System.out.println("\nATM System Menu:");
            System.out.println("1. Admin Login");
            System.out.println("2. User Login");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            int choice = Integer.parseInt(sc.nextLine());

            switch (choice) {
                case 1:
                    if(adminLog(sc)) {
                        adminActionsMenu(sc,new Admin());
                    }
                    break;
                case 2:
                    User userlogg=userLog(sc);
                    if(userlogg!=null) {
                        userActionsMenu(sc,new User());
                    }
                    break;
                case 3:
                    System.out.println("Exiting the ATM system...");
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
        sc.close();
    }

    private boolean adminLog(Scanner sc) {
        System.out.print("Enter Admin Username: ");
        String adminUsername = sc.nextLine();
        Admin admin = null;
        for (Admin a : ATMSystem.getAdmins()) {
            if (a.getAdminName().equals(adminUsername)) {
                admin = a;
                break;
            }
        }

        if (admin != null) {
            System.out.print("Enter Admin Pin: ");
            int adminPin = Integer.parseInt(sc.nextLine());
            if (adminPin == admin.getAdminPin()) {
                adminActionsMenu(sc, admin);
                return true;
            } else {
                System.out.println("Invalid Pin.");
            }
        } else {
            System.out.println("Invalid Username.");
        }
        return false;
    }

    private void adminActionsMenu(Scanner sc, Admin admin) {
        boolean exit = false;
        while (!exit) {
            System.out.println("\nAdmin Menu:");
            System.out.println("1. Add User");
            System.out.println("2. Delete User");
            System.out.println("3. View User List");
            System.out.println("4. View ATM Balance");
            System.out.println("5. Deposit Amount");
            System.out.println("6. View User Transactions");
            System.out.println("7. View Admin Transactions");
            System.out.println("8. Exit");
            System.out.print("Enter your choice: ");
            int choice = Integer.parseInt(sc.nextLine());

            switch (choice) {
                case 1:
                    adminActions.addUser(sc);
                    break;
                case 2:
                    adminActions.deleteUser(sc);
                    break;
                case 3:
                    adminActions.viewUsers();
                    break;
                case 4:
                    adminActions.viewAtmBalance();
                    break;
                case 5:
                    adminActions.depositAtmBalance(sc, admin);
                    break;
                case 6:
                    adminActions.viewUserTransactions(sc);
                    break;
                case 7:
                    adminActions.viewAdminTransactions(sc);
                    break;
                case 8:
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }

    private User userLog(Scanner sc) {
        System.out.print("Enter Username: ");
        String username = sc.nextLine();

        User user= null;
        for (User u : ATMSystem.getUsers()) {
            if (u.getUsername().equals(username)) {
                user = u;
                break;
            }
        }


        if (user != null) {
            System.out.print("Enter User Pin: ");
            String password = sc.nextLine();
            if (password.equals(user.getPassword())) {
                userActionsMenu(sc, user);
                return user;
            } else {
                System.out.println("Invalid Pin.");
            }
        } else {
            System.out.println("Invalid Username.");
        }
        return null;
    }

    private void userActionsMenu(Scanner sc,User user) {
        boolean exit = false;
        while (!exit) {
            System.out.println("\nUser Menu:");
            System.out.println("1. Deposit Money");
            System.out.println("2. Withdraw Money");
            System.out.println("3. View Balance");
            System.out.println("4. View Transaction History");
            System.out.println("5. Change Pin");
            System.out.println("6. Logout");
            System.out.print("Enter your choice: ");
            int choice = Integer.parseInt(sc.nextLine());

            switch (choice) {
                case 1:
                    userActions.depositMoney(sc, user);
                    break;
                case 2:
                    userActions.withdrawMoney(sc, user);
                    break;
                case 3:
                    userActions.viewBalance(user);
                    break;
                case 4:
                    userActions.viewTransactionHistory(user);
                    break;
                case 5:
                    userActions.changePin(user, sc);
                    break;
                case 6:
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }
}
