package com.pawan.LLD.lld.splitwise.split;

import com.pawan.LLD.lld.splitwise.SplitDetails;
import com.pawan.LLD.lld.splitwise.SplitType;
import com.pawan.LLD.lld.splitwise.User;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Pawan Saini
 * Created on 20/02/25.
 */
public class EqualExpenseSplit implements IExpenseSplit {

    @Override
    public List<SplitDetails> splitExpense(Double amount, List<User> users, SplitType splitType, List<Double> splitDetails) {
        double equalAmount = amount / users.size();
        List<SplitDetails> splitDetailsList = new ArrayList<>();

        for(User user : users) {
            SplitDetails split = new SplitDetails(user, equalAmount, 0d, "Equal split");
            splitDetailsList.add(split);
        }
        return splitDetailsList;
    }
}
