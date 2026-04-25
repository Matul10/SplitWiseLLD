package Service;

import Repo.GroupRepo;
import Repo.UserRepo;
import enums.SplitType;
import model.GroupExpense;
import model.Group;
import model.NonGroupExpense;
import model.User;
import strategy.ExpenseService;

import java.util.List;
import java.util.Map;

public class SplitWise {
    private GroupRepo groupRepo;
    private UserRepo userRepo;
//    private Map<Integer, User> users;

    public SplitWise(GroupRepo groupRepo, UserRepo nonGroupRepo) {
        this.groupRepo = groupRepo;
        this.userRepo = nonGroupRepo;
    }

    public Group createGroup(int groupId, String groupName, Map<Integer,User> users){
        Group newGroup = groupRepo.addGroup(groupId,groupName,users);

        if(newGroup == null) return null;

//        for(Map.Entry<Integer,User> entry : users.entrySet()){
//            addUserToGroup(newGroup, entry.getValue());
//        }
        return newGroup;
    }

    public void addUserToGroup(Group group, User user){
        boolean userExists = userRepo.userExists(user.getId());
        if(!userExists){
            System.out.println("User does not exist in Splitwise !!");
            return;
        }
        boolean added = groupRepo.addUser(group.getId(),user);
        if(added){
           userRepo.addGroupToUser(group,user);
        }
    }

    public GroupExpense addGroupExpense(User userWhoPaid, int expenseId, Group group, double amount, List<User> users, SplitType splitType, String description, Map<Integer, Double> metaData){
        GroupExpense newGroupExpense = ExpenseService.createExpense(userWhoPaid.getId(), expenseId, group.getId(), amount, users, splitType, description, metaData);
        groupRepo.addExpense(group.getId(), newGroupExpense);
        return newGroupExpense;
    }

    public User createUser(int userId, String name){
        return userRepo.addUser(userId,name);
    }

    public NonGroupExpense addIndividualExpense(User lender, User borrower,int expenseId, String expenseDescription, double amount){
        NonGroupExpense expense = new NonGroupExpense(expenseId,expenseDescription,lender,borrower,amount/2.0);
        userRepo.mapNonGroupExpense(lender,expense);
        userRepo.mapNonGroupExpense(borrower,expense);
        System.out.println("Individual expense added successfully!! ");
        return expense;
    }

    public void displayExpenseHistory(int groupId){
        groupRepo.printExpenseHistory(groupId);
    }

    public void displayGroupExpenseDetails(int groupId, int expenseId){
        groupRepo.printGroupExpense(groupId,expenseId);
    }
    public void displayNonGroupExpenses(User user){
        userRepo.displayIndividualExpenses(user);
    }
}
