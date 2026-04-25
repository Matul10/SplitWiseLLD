package model;

import java.util.HashMap;
import java.util.Map;

public class User {
    private int id;
    private String name;
    private Map<Integer,Group> groups;
    private Map<Integer,NonGroupExpense> individualExpenses;

    public User(int id, String name) {
        this.id = id;
        this.name = name;
        this.groups = new HashMap<>();
        this.individualExpenses = new HashMap<>();
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }
    public void addGroup(Group group){
        boolean groupExists = groups.containsKey(group.getId());
        if(groupExists){
            System.out.println("group " + group.getDescription() + " already mapped to user " + name);
        }else{
            groups.put(group.getId(),group);
            System.out.println("group " + group.getDescription() + " mapped to user " + name + " successfully");
        }
    }

    public void addExpense(NonGroupExpense expense){
        boolean alreadyExists = individualExpenses.containsKey(expense.getId());
        if(alreadyExists){
            System.out.println(" expense " + expense.getDescription() + " already mapped to user: " + name);
        }else{
            individualExpenses.put(expense.getId(),expense);
            System.out.println(" expense " + expense.getDescription() + " mapped to user: " + name + " successfully!");
        }
    }

    public boolean expenseExists(int id){
        return individualExpenses.containsKey(id);
    }

    //print methods

    public void printNonGroupExpenses() {
        if (individualExpenses == null || individualExpenses.isEmpty()) {
            System.out.println("\nNo individual expenses found for user: " + this.name);
            return;
        }

        System.out.println("\n========== NON-GROUP EXPENSES FOR: " + name + " ==========");
        System.out.println(String.format("%-5s %-20s %-15s %-15s %-12s %-10s",
                "ID", "Description", "Lender", "Borrower", "Amount", "Status"));
        System.out.println("---------------------------------------------------------------------------------------");

        for (NonGroupExpense expense : individualExpenses.values()) {
            String description = expense.getDescription().length() > 20 ?
                    expense.getDescription().substring(0, 17) + "..." :
                    expense.getDescription();
            String lender = expense.getLender().getName();
            String borrower = expense.getBorrower().getName();
            String amount = "$" + String.format("%.2f", expense.getAmount());
            String status = expense.isCleared() ? "Settled" : "Pending";

            System.out.printf("%-5d %-20s %-15s %-15s %-12s %-10s%n",
                    expense.getId(),
                    description,
                    lender,
                    borrower,
                    amount,
                    status);
        }

        System.out.println("======================================================================================\n");
    }

}
