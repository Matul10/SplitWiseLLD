package strategy;

import enums.SplitType;
import model.Expense;
import model.User;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PercentageStrategy implements ExpenseStrategy{
    @Override
    public Expense generateExpense(int userWhoPaid,int expenseId, int groupId, double amount, List<User> users, SplitType splitType, String description, Map<Integer, Double> metaData) {
        double totalPercentage = 0.0;
        for(Map.Entry<Integer, Double> entry : metaData.entrySet()){
            totalPercentage += entry.getValue();
        }

        if(totalPercentage != 100.0) throw new IllegalArgumentException("Percentages don't sum up to 100");
        Map<Integer, Double> splits = new HashMap<>();
        LocalDate currentDate = LocalDate.now();

        for(User u : users){
            splits.put(u.getId(),amount * metaData.get(u.getId())/100.0);
        }

        Expense percentExpense = new Expense(expenseId,description,currentDate,groupId,userWhoPaid,amount,SplitType.PERCENTAGE,splits);
        return percentExpense;

    }
}
