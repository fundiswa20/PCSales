package com.example.pcsale.bl;



import org.springframework.stereotype.Service;

import com.example.pcsale.model.Card;
import com.example.pcsale.repository.CardRepository;

@Service

public class PaymentServiceImpl implements PaymentService {

    private final CardRepository cardRepository;

    public PaymentServiceImpl(CardRepository cardRepository) {
        this.cardRepository = cardRepository;
    }

    @Override
    public void processPayment(String cardNumber, String expiration, String cvc) {
        Card card = new Card(cardNumber, expiration, cvc, null);
        cardRepository.save(card);
    }

}
