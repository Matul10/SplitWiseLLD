package Repo;

import model.GroupExpense;
import model.Group;
import model.User;

import java.util.HashMap;
import java.util.Map;

public class GroupRepo {
    private Map<Integer, Group> groups;

    public GroupRepo(){
        groups = new HashMap<>();
    }
    private boolean groupExists(int id){
        return groups.containsKey(id);
    }
    public Group addGroup(int groupId, String groupName, Map<Integer,User> users){
        boolean groupExists = groupExists(groupId);

        if(!groupExists){
            Group newGroup = new Group(groupId,groupName,users);
            groups.put(groupId,newGroup);
            System.out.println("Group id: " + groupId + " added successfully!!");
            return newGroup;
        }else{

            System.out.println("Group id: " + groupId + " already exists!!");
            return null;
        }
    }

    public boolean addUser(int groupId, User user){
        boolean groupExists = groupExists(groupId);

        if(!groupExists){
            System.out.println("Can't add user, group id: "+ groupId + " doesn't exists!!");
            return false;
        }else{
            Group currentGroup = groups.get(groupId);
            boolean added = currentGroup.addUser(user);
            return added;
        }
    }

    public void addExpense(int groupId, GroupExpense groupExpense){
        boolean groupExists = groupExists(groupId);
        if(!groupExists){
            System.out.println("Can't add expense, group id: "+ groupId + " doesn't exists!!");
        }else{
            Group currentGroup = groups.get(groupId);
            currentGroup.addExpense(groupExpense);
        }
    }

    public void printExpenseHistory(int groupId){
        boolean groupExists = groupExists(groupId);
        if(!groupExists){
            System.out.println("group id: "+ groupId + " doesn't exists!!");
        }else{
            Group group = groups.get(groupId);
            group.printExpenseHistory();
        }
    }

    public void printGroupExpense(int groupId, int expenseId){
        boolean groupExists = groupExists(groupId);
        if(!groupExists){
            System.out.println("group id: "+ groupId + " doesn't exists!!");
        }else{
            Group group = groups.get(groupId);
            group.displayExpenseDetails(expenseId);
        }
    }
}
