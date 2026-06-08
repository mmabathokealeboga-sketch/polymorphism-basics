package com.mentee.polymorphism.payments;

public class PayPalPayment extends Payment implements PaymentValidator {

    private String email;

    // TODO: Constructor + implement all abstract + interface methods
    public PayPalPayment(String transactionId, double amount, String currency,String email ){
        super(transactionId,amount,currency);
        this.email = email;
    }
    @Override
    public String getPaymentType(){
        return "PayPal";
    }
    @Override
    public boolean processPayment(){
        return true;
    }
    @Override
    public boolean validate(){
        return true;
    }

}