package model;

import enums.SplitType;

import java.time.LocalDate;
import java.util.Map;

public class GroupExpense {
    private int id;
    private String description;
    private LocalDate date;
    private int groupId;
    private int paidBy;
    private double amount;
    private SplitType splitType;
    private Map<Integer,Double> splits;

    public GroupExpense(int id, String description, LocalDate date, int groupId, int paidBy, double amount, SplitType splitType, Map<Integer, Double> splits) {
        this.id = id;
        this.description = description;
        this.date = date;
        this.groupId = groupId;
        this.paidBy = paidBy;
        this.amount = amount;
        this.splitType = splitType;
        this.splits = splits;
    }

    public int getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }
    public LocalDate getDate() {
        return date;
    }

    public double getAmount() {
        return amount;
    }

    public Map<Integer, Double> getSplits() {
        return splits;
    }

    public int getPaidBy() {
        return paidBy;
    }

}

