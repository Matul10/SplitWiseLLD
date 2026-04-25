import Repo.GroupRepo;
import Repo.UserRepo;
import Service.SplitWise;
import enums.SplitType;
import model.Group;
import model.GroupExpense;
import model.NonGroupExpense;
import model.User;

import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        System.out.println("split");

        GroupRepo groupRepo = new GroupRepo();
        UserRepo userRepo = new UserRepo();
        SplitWise splitWise = new SplitWise(groupRepo,userRepo);

        User matul = splitWise.createUser(1,"matul");
        User rahul = splitWise.createUser(2,"rahul");
        User chanchal = splitWise.createUser(3,"chanchal");

        Group lunchPurchase = splitWise.createGroup(1,"lunch expense",
                Map.of(1,matul,2,rahul));

        GroupExpense expense = splitWise.addGroupExpense(matul,1,lunchPurchase,200.0, List.of(matul,rahul), SplitType.PERCENTAGE,"lunch kfc",
                Map.of(1,60.0,2,40.0));

        splitWise.displayExpenseHistory(lunchPurchase.getId());
        splitWise.displayGroupExpenseDetails(lunchPurchase.getId(), expense.getId());

        NonGroupExpense indExp = splitWise.addIndividualExpense(matul,chanchal,2,"macD",300.0);
//        rahul.printNonGroupExpenses();
        splitWise.displayNonGroupExpenses(matul);
        splitWise.displayNonGroupExpenses(rahul);
        splitWise.displayNonGroupExpenses(chanchal);
    }
}
