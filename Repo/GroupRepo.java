package Repo;

import model.Expense;
import model.Group;
import model.User;

import java.util.Map;

public class GroupRepo {
    private Map<Integer, Group> groups;

    private boolean groupExists(int id){
        return groups.containsKey(id);
    }
    public void addGroup(Group group){
        boolean groupExists = groupExists(group.getId());

        if(!groupExists){
            groups.put(group.getId(),group);
            System.out.println("Group id: " + group.getId() + " added successfully!!");
        }else{
            System.out.println("Group id: " + group.getId() + " already exists!!");
        }
    }

    public void addUser(int groupId, User user){
        boolean groupExists = groupExists(groupId);

        if(!groupExists){
            System.out.println("Can't add user, group id: "+ groupId + " doesn't exists!!");
        }else{
            Group currentGroup = groups.get(groupId);
            currentGroup.addUser(user);
        }
    }

    public void addExpense(int groupId, Expense expense){
        boolean groupExists = groupExists(groupId);
        if(!groupExists){
            System.out.println("Can't add expense, group id: "+ groupId + " doesn't exists!!");
        }else{
            Group currentGroup = groups.get(groupId);
            currentGroup.addExpense(expense);
        }
    }
}
