package com.pawan.LLD.lld.splitwise;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Pawan Saini
 * Created on 20/02/25.
 */
public class SettlementService {

    private static List<List<String>> minTransactions = new ArrayList<>();

    public static final void main(String[] args) {

        int expenses[][] = {
                {0, 1, 10},
                {2, 0, 5},
                {1, 2, 5},
                {2, 1, 150},
                {2, 0, 150},
                {3, 0, 10}
        };
        List<String> transactions = new ArrayList<>();
        int[] minTrx = {Integer.MAX_VALUE};
        minTransfers(expenses, 0, minTrx, transactions);
        System.out.println("Minimum number of transactions: " + minTrx[0]);
        for (String transaction : minTransactions.get(0)) {
            System.out.println(transaction);
        }
    }

    public static void minTransfers(int[][] expensesList, int trx, int minTrx[], List<String> transactions) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int[] expense : expensesList) {
            map.put(expense[0], map.getOrDefault(expense[0], 0) - expense[2]);
            map.put(expense[1], map.getOrDefault(expense[1], 0) + expense[2]);
        }

        int expenses[] = new int[map.size()];
        for(int i = 0; i < map.size(); i++) {
            expenses[i] = map.get(i);
        }


        dfs(0, expenses, trx, minTrx, transactions);
    }

    public static void dfs(int i, int[] expenses, int trx, int minTrx[], List<String> transactions) {
        if(i==expenses.length) {
             if(minTrx[0] > trx) {
                 minTrx[0] = trx;
                 if(minTransactions.size() > 0) {
                     minTransactions.remove(0);
                 }
                 minTransactions.add(new ArrayList<>(transactions));
             }
            return ;
        }
        if(expenses[i] == 0) {
            dfs(i+1, expenses, trx, minTrx, transactions);
            return;
        }

        for(int j = i+1; j<expenses.length; j++) {
            if(expenses[i] * expenses[j] < 0) {
                int amount = Math.min(Math.abs(expenses[i]), Math.abs(expenses[j]));
                expenses[j] = expenses[j] + expenses[i];
                transactions.add(i + " pays " + j + " : " + amount);
                dfs(i+1, expenses, trx+1, minTrx,  transactions);
                transactions.remove(transactions.size()-1);
                expenses[j] = expenses[j] - expenses[i];
            }
            if(expenses[j] + expenses[i] == 0) {
                break;
            }
        }
    }
}
