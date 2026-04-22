package factory;

import enums.SplitType;
import strategy.EqualStrategy;
import strategy.ExpenseStrategy;
import strategy.PercentageStrategy;

public class ExpenseFactory {
    public static ExpenseStrategy get(SplitType splitType){
        return switch (splitType){
            case EQUAL -> new EqualStrategy();
            case PERCENTAGE -> new PercentageStrategy();
            default -> throw new IllegalArgumentException("invalid split type, can't generate split strategy!!");
        };
    }
}
