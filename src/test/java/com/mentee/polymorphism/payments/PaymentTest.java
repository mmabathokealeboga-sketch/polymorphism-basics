package com.mentee.polymorphism.payments;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PaymentTest {

    @Test
    void testCreditCardPayment() {
        Payment payment = new CreditCardPayment("TXN001", 150.75, "USD",
                "4111111111111111", "John Doe");

        assertEquals("Credit Card", payment.getPaymentType());
        assertTrue(payment.processPayment());
        assertTrue(((PaymentValidator) payment).validate());
    }

    @Test
    void testPayPalPayment() {
        Payment payment = new PayPalPayment("TXN002", 89.99, "EUR", "user@example.com");

        assertEquals("PayPal", payment.getPaymentType());
        assertTrue(payment.processPayment());
    }

    @Test
    void testPolymorphicBehavior() {
        Payment[] payments = {
                new CreditCardPayment("TXN001", 200, "USD", "4111111111111111", "Alice"),
                new PayPalPayment("TXN002", 75.50, "USD", "bob@example.com"),
                new CreditCardPayment("TXN003", 300, "EUR", "4222222222222222", "Charlie")
        };

        for (Payment p : payments) {
            assertNotNull(p.getPaymentType());
            assertTrue(p.processPayment());
            p.logTransaction();

            // Demonstrate interface polymorphism
            if (p instanceof PaymentValidator validator) {
                assertTrue(validator.validate());
            }

            if (p instanceof Refundable refundable) {
                assertTrue(refundable.refund(50.0));
            }
        }
    }

    @Test
    void testRefundableInterface() {
        Refundable creditCard = new CreditCardPayment("TXN004", 500, "USD",
                "4333333333333333", "David");

        assertTrue(creditCard.refund(100.0));
        assertNotNull(creditCard.getRefundPolicy());
    }

    @Test
    void testValidationUsingInterfaceReference() {
        PaymentValidator validator = new PayPalPayment("TXN005", 99.99, "USD", "test@email.com");
        assertTrue(validator.validate());
    }

    @Test
    void testInvalidPaymentValidation() {
        PaymentValidator invalidCard = new CreditCardPayment("TXN006", 50, "USD",
                "1234", "Invalid User");

        assertFalse(invalidCard.validate());
    }
}