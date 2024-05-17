package com.example.pcsale.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
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

    public Card(String cardNumber, String expiration, String cvc, Customer customer) {
        this.cardNumber = cardNumber;
        this.expiration = expiration;
        this.cvc = cvc;
        this.customer = customer;
    }

    
}
