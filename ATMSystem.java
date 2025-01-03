import java.util.ArrayList;

public class ATMSystem {

    private static double atmbalance;
    private static ArrayList<User> users=new ArrayList<>();
    private static ArrayList<Admin> admins=new ArrayList<>();
    private static ArrayList<Notes> notes=new ArrayList<>();
    private static ArrayList<Transaction> transactions=new ArrayList<>();




    public static double getAtmbalance() {
        return atmbalance;
    }

    public static void setAtmbalance(double atmbalance) {
        ATMSystem.atmbalance = atmbalance;
    }

    public static ArrayList<User> getUsers() {
        return users;
    }

    public static void setUsers(ArrayList<User> users) {
        ATMSystem.users = users;
    }

    public static ArrayList<Admin> getAdmins() {
        return admins;
    }

    public static void setAdmins(ArrayList<Admin> admins) {
        ATMSystem.admins = admins;
    }

    public static ArrayList<Notes> getNotes() {
        return notes;
    }

    public static void setNotes(ArrayList<Notes> notes) {
        ATMSystem.notes = notes;
    }

    public static ArrayList<Transaction> getTransactions() {
        return transactions;
    }

    public static void setTransactions(ArrayList<Transaction> transactions) {
        ATMSystem.transactions = transactions;
    }
}
