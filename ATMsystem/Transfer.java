public class Transfer {
    private String type;
    private double amount;

    // Constructor
    public Transfer(String type, double amount) {
        this.type = type;
        this.amount = amount;
    }

    // Getter methods
    public String getType() {
        return type;
    }

    public double getAmount() {
        return amount;
    }

    @Override
    public String toString() {
        return "Type: " + type + ", Amount: " + amount;
    }

}
