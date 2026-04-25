package strategy;

import enums.SplitType;
import model.GroupExpense;
import model.User;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EqualStrategy implements ExpenseStrategy{
    @Override
    public GroupExpense generateExpense(int userWhoPaid, int expenseId, int groupId, double amount, List<User> users, SplitType splitType, String description, Map<Integer, Double> metaData) {
        double amountPerUser = amount/users.size();
        Map<Integer, Double> splits = new HashMap<>();
        LocalDate currentDate = LocalDate.now();

        for(User u : users){
            splits.put(u.getId(),amountPerUser);
        }

        GroupExpense equalGroupExpense = new GroupExpense(expenseId,description,currentDate,groupId,userWhoPaid,amount,SplitType.EQUAL,splits);
        return equalGroupExpense;
    }
}
