package strategy;

import enums.SplitType;
import factory.ExpenseFactory;
import model.GroupExpense;
import model.User;

import java.util.List;
import java.util.Map;

public class ExpenseService {

    public static GroupExpense createExpense(int userWhoPaid, int expenseId, int groupId, double amount, List<User> users, SplitType splitType, String description, Map<Integer, Double> metaData){
        ExpenseStrategy strategy = ExpenseFactory.get(splitType);
        GroupExpense newGroupExpense = strategy.generateExpense(userWhoPaid,expenseId,groupId,amount,users,splitType,description,metaData);
        return newGroupExpense;
    }
}
