import java.util.Scanner;

public class ATMSystem {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Admin admin = new Admin();
        Account currentUser =  null;
        Account acc = new Account();

        while (true) {
            System.out.println("\nATM System Menu:");
            System.out.println("1. Admin Login \n 2. User Login \n 3. Exit \n Enter your choice: ");
            int choice = Integer.parseInt(sc.nextLine());

            if (choice == 1) {
                int n = 0;
                x:while (n < 3) {
                    n++;
                    System.out.println("Enter Admin Username: ");
                    String adminUsername = sc.nextLine();
                    if (adminUsername.equals("admin")) {
                        System.out.println("Enter Admin Password: ");
                        int adminPassword = Integer.parseInt(sc.nextLine());
                        admin = new Admin(adminUsername, adminPassword);

                        if (adminPassword == 1234) {
                            boolean o = false;
                            while (!o) {
                                System.out.println("1.Add user \n 2.Delete user \n 3.view transaction History \n 4.View user list \n 5.Exit");
                                int c = Integer.parseInt(sc.nextLine());
                                switch (c) {
                                    case 1:
                                        System.out.print("Enter new username: ");
                                        String username = sc.nextLine();
                                        System.out.print("Enter new password: ");
                                        int password = Integer.parseInt(sc.nextLine());
                                        admin.addUserAccount(username, password);
                                        break;

                                    case 2:

                                        System.out.print("Enter username to delete: ");
                                        String usernameToDelete = sc.nextLine();
                                        admin.deleteuserAccount(usernameToDelete);
                                        break;

                                    case 3:
                                        System.out.print("Enter username to view transaction history: ");
                                        String usernameToView = sc.nextLine();
                                        admin.trahis(usernameToView);
                                        break;

                                    case 4:
                                        System.out.println("User list details");
                                        admin.userlist();
                                        break;
                                    case 5:
                                        o = true;
                                        break x;

                                }
                            }
                        } else {
                            System.out.println("Invalid password");
                        }

                    } else {
                        System.out.println("Invalid username");
                    }

                }

            } else if (choice == 2) {
                // User Login
                System.out.print("Enter Username: ");
                String username = sc.nextLine();
                System.out.print("Enter Password: ");
                int password = Integer.parseInt(sc.nextLine());

                // Check if the username exists
                boolean userFound = false;
                for (Account account : admin.useracc) {
                    if (account.getUsername().equals(username) && account.getPassword()==(password)) {
                        currentUser = account;
                        userFound = true;
                        break;
                    }
                }

                y:if (userFound) {
                    // User Menuscanner
                    while (true) {
                        System.out.println("\nUser Menu:");
                        System.out.println("1. Deposit Money");
                        System.out.println("2. Withdraw Money");
                        System.out.println("3. View Balance");
                        System.out.println("4. View Transaction History");
                        System.out.println("5. Logout");
                        System.out.print("Enter your choice: ");
                        int userChoice = sc.nextInt();
                        sc.nextLine(); // Consume newline character

                        switch (userChoice) {
                            case 1:
                                System.out.print("Enter deposit amount: ");
                                double depositAmount = sc.nextDouble();
                                currentUser.deposit(depositAmount);
                                break;
                            case 2:
                                System.out.print("Enter withdrawal amount: ");
                                double withdrawAmount = sc.nextDouble();
                                currentUser.withdraw(withdrawAmount);
                                break;

                            case 3:
                                System.out.println("Your balance"+acc.viewbalance());
                                break;

                            case 4:
                                currentUser.viewTransactionHistory();
                                break;
                            case 5:
                                System.out.println("User logged out.");
                                break y;
                            default:
                                System.out.println("Invalid choice.");
                        }

                        if (userChoice == 4) break; // Exit user menu
                    }
                } else {
                    System.out.println("Invalid User credentials!");
                }

            } else if (choice == 3) {
                System.out.println("Exiting the ATM system...");
                break; // Exit the system
            } else {
                System.out.println("Invalid choice. Please try again.");
            }
        }
    }    
}

      