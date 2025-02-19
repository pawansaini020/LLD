package com.pawan.LLD.lld.splitwise;

import lombok.Data;

import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * @author Pawan Saini
 * Created on 20/02/25.
 */
@Data
public class Expense {

    private String expenseId;
    private String description;
    private Date date;
    private Double amount;
    private User paidBy;
    private SplitType splitType;
    private List<SplitDetails> splitDetails;

    public Expense(String description, Double amount, User paidBy, SplitType splitType, List<SplitDetails> splitDetails) {
        this.expenseId = UUID.randomUUID().toString();
        this.description = description;
        this.date = new Date();
        this.amount = amount;
        this.paidBy = paidBy;
        this.splitType = splitType;
        this.splitDetails = splitDetails;
    }
}
