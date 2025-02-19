package com.pawan.LLD.lld.splitwise;

import com.pawan.LLD.lld.splitwise.split.ExpenseSplitFactory;
import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Pawan Saini
 * Created on 20/02/25.
 */
@Slf4j
public class GroupManager {

    private Map<String, Group> GROUPS = new HashMap<>();

    public Group createGroup(String groupId, String name, List<User> users) {
        Group group = new Group(groupId, name, users);
        GROUPS.put(groupId, group);
        return group;
    }

    public void addExpense(String groupId, Double amount, User paidBy, SplitType splitType, List<Double> amountDetails, String description) {
        Group group = GROUPS.get(groupId);
        List<SplitDetails> splitDetails = ExpenseSplitFactory.getExpenseSplit(splitType).splitExpense(amount, group.getUsers(), splitType, amountDetails);
        Expense expense = new Expense(description, amount, paidBy, splitType, splitDetails);
        group.getExpenseList().add(expense);
        log.info("Expense added successfully: {}, {}, {}, {}", groupId, amount, paidBy.getName(), splitType);
    }

    public void printExpense(String groupId) {
        Group group = GROUPS.get(groupId);
        for(Expense expense : group.getExpenseList()) {
            log.info("Expense Id: " + expense.getExpenseId());
            log.info("Description: " + expense.getDescription());
            log.info("Amount: " + expense.getAmount());
            log.info("Paid By: " + expense.getPaidBy().getName());
            log.info("Split Type: " + expense.getSplitType());
            log.info("Split Details: ");
            for(SplitDetails splitDetails : expense.getSplitDetails()) {
                log.info(splitDetails.getUser().getName() + " " + splitDetails.getAmount());
            }
            System.out.println();
        }
    }

    public void showSettlement(String groupId) {
        Group group = GROUPS.get(groupId);
        group.showBalances();
    }
}
