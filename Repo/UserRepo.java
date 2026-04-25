package Repo;

import model.Group;
import model.NonGroupExpense;
import model.User;

import java.util.HashMap;
import java.util.Map;

public class UserRepo {
    private Map<Integer, User> users;

    public  UserRepo(){
        users = new HashMap<>();
    }
    public User addUser(int userId, String name){
        boolean alreadyExists = users.containsKey(userId);
        if(alreadyExists){
            System.out.println("User already exists in Splitwise !!");
            return null;
        }else{
            User newUser = new User(userId,name);
            users.put(userId,newUser);
            System.out.println("User added to Splitwise !!");
            return newUser;
        }
    }

    public boolean userExists(int id){
        return users.containsKey(id);
    }

    public void mapNonGroupExpense(User user, NonGroupExpense expense){
          user.addExpense(expense);
//        boolean alreadyExists = user.expenseExists(expense.getId());
//        if(alreadyExists){
//            System.out.println("Individual expense: " + expense.getDescription() + " already mapped to " + user.getName());
//        }else{
//            user.addExpense(expense);
//            System.out.println("Individual expense: " + expense.getDescription() + " mapped Successfully to " + user.getName());
//        }
    }

    public void addGroupToUser(Group group, User user){
        boolean exists = userExists(user.getId());
        if(!exists){
            System.out.println("user does not exist");
        }else{
            user.addGroup(group);
        }
    }

    public void displayIndividualExpenses(User user){
        boolean exists = userExists(user.getId());
        if(!exists){
            System.out.println("user does not exist");
        }else{
            user.printNonGroupExpenses();
        }
    }
}
