package com.mentee.polymorphism.payments;

public interface Refundable {
    boolean refund(double amount);
    String getRefundPolicy();

}