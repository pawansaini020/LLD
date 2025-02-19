package com.pawan.LLD.lld.splitwise;

import lombok.Data;

import java.util.Map;

/**
 * @author Pawan Saini
 * Created on 20/02/25.
 */
@Data
public class SettlementDetails {

    private Map<Integer, Balance> totalBalance;
    private User user;
    private Double expenseAmount;
    private Double owe;
    private Double owed;
}
