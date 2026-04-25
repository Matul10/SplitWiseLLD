package strategy;

import enums.SplitType;
import model.GroupExpense;
import model.User;

import java.util.List;
import java.util.Map;

public interface ExpenseStrategy {
    GroupExpense generateExpense(int userWhoPaid, int expenseId, int groupId, double amount, List<User> users, SplitType splitType, String description, Map<Integer, Double> metaData);
}
