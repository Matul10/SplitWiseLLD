package model;

import java.util.Map;

public class Group {
    private int id;
    private String name;
    private Map<Integer,User> users;
    private Map<Integer,Expense> expenses;

    public Group(int id, String name, Map<Integer, User> users) {
        this.id = id;
        this.name = name;
        this.users = users;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void addUser(User user){
        boolean userExists = users.containsKey(user.getId());
        if(userExists){
            System.out.println("User id: " + user.getId() + " already exists in the Group " + this.id);
        }else{
            users.put(user.getId(),user);
            System.out.println("User id: " + user.getId() + " added successfully in the Group " + this.id);
        }
    }

    public void addExpense(Expense expense){
        boolean expenseExists = expenses.containsKey(expense.getId());
        if(expenseExists){
            System.out.println("Expense id: " + expense.getId() + " already exists in the Group " + this.id);
        }else{
            expenses.put(expense.getId(),expense);
            System.out.println("Expense id: " + expense.getId() + " added successfully in the Group " + this.id);
        }
    }
}
