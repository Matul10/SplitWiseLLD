package Service;

import Repo.GroupRepo;
import enums.SplitType;
import model.Expense;
import model.Group;
import model.User;
import strategy.ExpenseService;

import java.util.List;
import java.util.Map;

public class SplitWise {
    private GroupRepo groupRepo;
    private Map<Integer, User> users;

    public SplitWise(GroupRepo groupRepo){
        this.groupRepo = groupRepo;
    }

    public void createGroup(int groupId, String groupName, Map<Integer,User> users){
        Group newGroup = new Group(groupId,groupName,users);
        groupRepo.addGroup(newGroup);
    }

    public void addUserToGroup(int groupId, User user){
        groupRepo.addUser(groupId,user);
    }

    public void addExpense(int userWhoPaid, int expenseId, int groupId, double amount, List<User> users, SplitType splitType, String description, Map<Integer, Double> metaData){
        Expense newExpense = ExpenseService.createExpense(userWhoPaid, expenseId, groupId, amount, users, splitType, description, metaData);
        groupRepo.addExpense(groupId,newExpense);
    }
}
