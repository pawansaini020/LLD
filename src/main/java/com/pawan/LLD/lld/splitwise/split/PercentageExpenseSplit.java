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
public class PercentageExpenseSplit implements IExpenseSplit {

    @Override
    public List<SplitDetails> splitExpense(Double amount, List<User> users, SplitType splitType, List<Double> splitDetails) {
        List<SplitDetails> splitDetailsList = new ArrayList<>();

        for(int i=0; i<users.size(); i++) {
            SplitDetails split = new SplitDetails(users.get(i), splitDetails.get(i)*amount/100, splitDetails.get(i), "Exact split");
            splitDetailsList.add(split);
        }
        return splitDetailsList;
    }
}
