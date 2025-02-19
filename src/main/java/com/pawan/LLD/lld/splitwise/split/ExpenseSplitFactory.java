package com.pawan.LLD.lld.splitwise.split;

import com.pawan.LLD.lld.splitwise.SplitType;

/**
 * @author Pawan Saini
 * Created on 20/02/25.
 */
public class ExpenseSplitFactory {

    public static IExpenseSplit getExpenseSplit(SplitType splitType) {
        switch (splitType) {
            case EQUAL:
                return new EqualExpenseSplit();
            case EXACT:
                return new ExactExpenseSplit();
            case PERCENT:
                return new PercentageExpenseSplit();
            default:
                return null;
        }
    }
}
