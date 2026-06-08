package com.mentee.polymorphism.payments;

public class CreditCardPayment extends Payment implements PaymentValidator, Refundable {

    private String cardNumber;
    private  String cardHolderName;

    // TODO: Constructor + implement all abstract + interface methods
    public CreditCardPayment(String transactionId, double amount, String currency, String cardNumber, String cardHolderName ){
        super(transactionId,amount,currency);
        this.cardNumber = cardNumber;
        this.cardHolderName = cardHolderName;
    }

    @Override
    public boolean processPayment() {
        return true;
    }
    @Override
    public String getPaymentType(){
        return "Credit Card";
    }
    @Override
    public  boolean validate(){
        return false;
    }
    @Override
    public boolean refund(double amount){
        return true;
    }
    @Override
    public  String getRefundPolicy(){
        return "Credit Card Refund Policy";
    }
}