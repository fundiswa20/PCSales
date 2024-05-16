package com.example.pcsale.bl;

public interface PaymentService {
    void processPayment(String cardNumber, String expiration, String cvc);
}
