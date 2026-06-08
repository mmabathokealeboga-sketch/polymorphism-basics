package com.mentee.polymorphism.payments;

public abstract class Payment {

    protected String transactionId;
    protected double amount;
    protected String currency;

    // TODO: Constructor
    public Payment(String transactionId, Double amount, String currency){
        this.transactionId = transactionId;
        this.amount = amount;
        this.currency = currency;
    }

    // Abstract methods
    public abstract boolean processPayment();
    public abstract String getPaymentType();

    // Concrete methods
    public double getAmount() {
        return amount;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void logTransaction() {
        System.out.println("Transaction " + transactionId + " | Amount: " + amount + " " + currency);
    }
}