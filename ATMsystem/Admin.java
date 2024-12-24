import java.util.ArrayList;


class Admin {
    public ArrayList<Account> useracc = new ArrayList<>();
    private String adminname;
    private int adminpin;


    public Admin(String adminUsername, int adminPassword) {
        this.adminname = adminUsername;
        this.adminpin = adminPassword;
    }

    public Admin() {

    }

    public String getAdminname() {
        return adminname;
    }

    public int getAdminpin() {
        return adminpin;
    }



    public void addUserAccount(String username, int password) {
        Account acc = new Account(username, password);
        useracc.add(acc);
        System.out.println("user Account Added!");
    }


    public void deleteuserAccount(String usernameToDelete) {
        Account userToDelete = null;
        for (Account account : useracc) {
            if (account.getUsername().equals(usernameToDelete)) {
                userToDelete = account;
                break;
            }
        }
        if (userToDelete != null) {
            useracc.remove(userToDelete);
            System.out.println("User account deleted successfully!");
        } else {
            System.out.println("User not found!");
        }
    }
    public void trahis(String username) {
        for (Account account : useracc) {
            if (account.getUsername().equals(username)) {
                account.viewTransactionHistory();
                return;
            }
        }
        System.out.println("User not found!");
    }


    public void userlist() {
        for (Account account : useracc){
            System.out.println(account.toString());
        }
    }
}

















