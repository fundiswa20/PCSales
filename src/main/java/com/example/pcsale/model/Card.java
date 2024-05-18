package com.example.pcsale.model;

import jakarta.persistence.*;
import lombok.*;

@Entity

public class Card {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "card_number")
    private String cardNumber;
    @Column(name = "expiration")
    private String expiration;
    @Column(name = "cvc")
    private String cvc;

    @OneToOne(cascade = CascadeType.ALL,mappedBy = "card")
    private Customer customer;


    public Card() {
        this.cardNumber = "";
        this.expiration = "";
        this.cvc = "";
    }


    public Card(String cardNumber, String expiration, String cvc, Customer customer) {
        this.cardNumber = cardNumber;
        this.expiration = expiration;
        this.cvc = cvc;
        this.customer = customer;
    }


    public Long getId() {
        return id;
    }


    public void setId(Long id) {
        this.id = id;
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


    public Customer getCustomer() {
        return customer;
    }


    public void setCustomer(Customer customer) {
        this.customer = customer;
    }



}
