package strategy;

import enums.SplitType;
import model.Expense;
import model.User;

import java.util.List;
import java.util.Map;

public interface ExpenseStrategy {
    Expense generateExpense(int userWhoPaid,int expenseId, int groupId, double amount, List<User> users, SplitType splitType, String description, Map<Integer, Double> metaData);
}
