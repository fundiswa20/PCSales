package com.example.pcsale.dto;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class PaymentDTO {
    private String cardNumber;
    private String expiration;
    private String cvc;

    public PaymentDTO(String cardNumber, String expiration, String cvv) {
        this.cardNumber = cardNumber;
        this.expiration = expiration;
        this.cvc = cvv;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getExpiration() {
        return expiration;
    }

    public void setExpiration(String expiration) {
        this.expiration = expiration;
    }

    public String getCvc() {
        return cvc;
    }

    public void setCvc(String cvc) {
        this.cvc = cvc;
    }
}
