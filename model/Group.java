package model;

import java.util.HashMap;
import java.util.Map;

public class Group {
    private int id;
    private String description;
    private Map<Integer,User> users;
    private Map<Integer, GroupExpense> expenses;

    public Group(int id, String name, Map<Integer, User> users) {
        this.id = id;
        this.description = name;
        this.users = users;
        this.expenses = new HashMap<>();
    }

    public int getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public boolean addUser(User user){
        boolean userExists = users.containsKey(user.getId());
        if(userExists){
            System.out.println("User id: " + user.getId() + " already exists in the Group " + this.description);
            return false;
        }else{
            users.put(user.getId(),user);
            System.out.println("User id: " + user.getId() + " added successfully in the Group " + this.description);
            return true;
        }
    }

    public void addExpense(GroupExpense groupExpense){
        boolean expenseExists = expenses.containsKey(groupExpense.getId());
        if(expenseExists){
            System.out.println("Expense id: " + groupExpense.getId() + " already exists in the Group " + this.description);
        }else{
            expenses.put(groupExpense.getId(), groupExpense);
            System.out.println("Expense id: " + groupExpense.getId() + " added successfully in the Group " + this.description);
        }
    }


    //printing functions
    public void printExpenseHistory() {
        if (expenses == null || expenses.isEmpty()) {
            System.out.println("No expenses found for group: " + this.description);
            return;
        }

        System.out.println("\n========== EXPENSE HISTORY FOR GROUP: " + this.description + " ==========");

        for (GroupExpense expense : expenses.values()) {
            System.out.println("\n--- Expense ID: " + expense.getId() + " ---");
            System.out.println("Description: " + expense.getDescription());
            System.out.println("Total Amount: $" + expense.getAmount());
            System.out.println("Date: " + expense.getDate());

            System.out.println("Users Associated:");
            // Get users from the splits map (keys are user IDs)
            for (Integer userId : expense.getSplits().keySet()) {
                User user = users.get(userId);
                if (user != null) {
                    System.out.println("  - " + user.getName() + " (ID: " + userId + ")");
                }
            }
        }

        System.out.println("\n========== END OF EXPENSE HISTORY ==========\n");
    }

    public void displayExpenseDetails(int expenseId) {
        GroupExpense expense = expenses.get(expenseId);

        if (expense == null) {
            System.out.println("Expense ID: " + expenseId + " not found in group: " + this.description);
            return;
        }

        System.out.println("\n========== EXPENSE DETAILS ==========");
        System.out.println("Expense ID: " + expense.getId());
        System.out.println("Description: " + expense.getDescription());
        System.out.println("Total Amount: $" + expense.getAmount());
        System.out.println("Date: " + expense.getDate());
        System.out.println("Paid By: " + users.get(expense.getPaidBy()).getName() + " (ID: " + expense.getPaidBy() + ")");

        System.out.println("\nBreakdown - Amount Each User Owes:");
        System.out.println("---------------------------------");

        for (Integer userId : expense.getSplits().keySet()) {
            User user = users.get(userId);
            double owedAmount = expense.getSplits().get(userId);

            if (user != null) {
                System.out.println(user.getName() + " owes: $" + owedAmount);
            }
        }

        System.out.println("========== END OF DETAILS ==========\n");
    }


}
