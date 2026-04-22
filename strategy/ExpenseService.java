package strategy;

import enums.SplitType;
import factory.ExpenseFactory;
import model.Expense;
import model.User;

import java.util.List;
import java.util.Map;

public class ExpenseService {

    public static Expense createExpense(int userWhoPaid, int expenseId, int groupId, double amount, List<User> users, SplitType splitType, String description, Map<Integer, Double> metaData){
        ExpenseStrategy strategy = ExpenseFactory.get(splitType);
        Expense newExpense = strategy.generateExpense(userWhoPaid,expenseId,groupId,amount,users,splitType,description,metaData);
        return newExpense;
    }
}
