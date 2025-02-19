package com.pawan.LLD.lld.splitwise.split;

import com.pawan.LLD.lld.splitwise.SplitDetails;
import com.pawan.LLD.lld.splitwise.SplitType;
import com.pawan.LLD.lld.splitwise.User;

import java.util.List;

/**
 * @author Pawan Saini
 * Created on 20/02/25.
 */
public interface IExpenseSplit {

    List<SplitDetails> splitExpense(Double amount, List<User> users, SplitType splitType, List<Double> splitDetails);
}
