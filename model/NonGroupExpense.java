package model;

public class NonGroupExpense {
    private int id;
    private String description;
    private User lender;
    private User borrower;
    private double amount;
    private boolean cleared;

    public NonGroupExpense(int id, String description, User lender, User borrower, double amount) {
        this.id = id;
        this.description = description;
        this.lender = lender;
        this.borrower = borrower;
        this.amount = amount;
        this.cleared = false;
    }

    public int getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public User getLender() {
        return lender;
    }

    public User getBorrower() {
        return borrower;
    }

    public double getAmount() {
        return amount;
    }

    public boolean isCleared() {
        return cleared;
    }
}
