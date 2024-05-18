package com.example.pcsale.bl;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.pcsale.dto.CheckoutFormDTO;
import com.example.pcsale.model.Card;
import com.example.pcsale.repository.CardRepository;
import com.example.pcsale.repository.CustomerRepository;

@Service

public class PaymentService  {

    @Autowired
    CardRepository cardRepo;

    @Autowired
    CustomerRepository customerRepo;

    public boolean processPayment(CheckoutFormDTO checkoutForm,Long userId) {
        // Simulate payment processing logic
        // In a real-world scenario, integrate with a payment gateway here
        Card card = customerRepo.findById(userId).get().getCard();
        String cardNumber = checkoutForm.getCardNumber();
        String expiration = checkoutForm.getExpiration();
        String cvv = checkoutForm.getCvv();

        // Placeholder logic to simulate a payment process
        if (isCardNumberValid(cardNumber) && isExpirationValid(expiration) && isCvvValid(cvv)) {

            card.setCardNumber(cardNumber);
            card.setExpiration(expiration);
            card.setCvc(cvv);
            cardRepo.save(card);
            // Assume payment is successful
            return true;
        } else {
            // Payment failed
            return false;
        }
    }

    private boolean isCardNumberValid(String cardNumber) {
        // Implement basic validation for card number
        return cardNumber != null && cardNumber.length() == 16;
    }

    private boolean isExpirationValid(String expiration) {
        // Implement basic validation for expiration date (MM/YY format)
        return expiration != null && expiration.matches("(0[1-9]|1[0-2])/\\d{2}");
    }

    private boolean isCvvValid(String cvv) {
        // Implement basic validation for CVV
        return cvv != null && cvv.length() == 3;
    }

}
