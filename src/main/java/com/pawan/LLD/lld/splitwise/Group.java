package com.pawan.LLD.lld.splitwise;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Pawan Saini
 * Created on 20/02/25.
 */
@Data
public class Group {

    private String groupId;
    private String name;
    private List<User> users;
    private List<Expense> expenseList;
    private List<SettlementDetails> shuttledExpenseList;

    public Group(String groupId, String name, List<User> users) {
        this.groupId = groupId;
        this.name = name;
        this.users = users;
        expenseList = new ArrayList<>();
        shuttledExpenseList = new ArrayList<>();
    }

    public void showBalances() {
        for(SettlementDetails settlementDetails : shuttledExpenseList) {
            System.out.println(settlementDetails.getUser().getName() + " owes " + settlementDetails.getOwe() + " to " + settlementDetails.getOwed());
        }
    }
}
