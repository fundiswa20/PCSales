package com.example.pcsale.controller;


import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import com.example.pcsale.bl.PaymentService;
import com.example.pcsale.dto.CheckoutFormDTO;
import com.example.pcsale.model.Cart;
import com.example.pcsale.repository.CartRepository;
import com.example.pcsale.repository.CustomerRepository;

import jakarta.servlet.http.HttpSession;

@Controller
public class CheckoutController {

    @Autowired
    private CustomerRepository customerRepo;
    @Autowired
    private CartRepository cartRepo;
    @Autowired
    private PaymentService paymentService;

    @GetMapping("/user/checkout")
    public String showCheckoutPage(Model model) {
        model.addAttribute("checkoutForm", new CheckoutFormDTO());
        return "checkout";
    }

    @PostMapping("/user/checkout")
    public String handleCheckout(
            @SessionAttribute("userid") Long userId,
            @RequestParam("cardNumber") String cardNumber,
            @RequestParam("expiration") String expiration,
            @RequestParam("cvv") String cvv,
            Model model,
            HttpSession session
    ) {

        CheckoutFormDTO checkoutForm = new CheckoutFormDTO(cardNumber, expiration, cvv);
        // Process the payment using the PaymentService
        boolean paymentSuccessful = paymentService.processPayment(checkoutForm);

        if (paymentSuccessful) {
            // Clear the user's cart or update the order status
            clearCart(userId);
            // Add a success message
            model.addAttribute("message", "Payment successful. Thank you for your purchase!");
            System.out.println("Payment successful. Thank you for your purchase!");
            return "checkout"; // Create a success page template
        } else {
            // Add an error message
            model.addAttribute("error", "Payment failed. Please try again.");
            System.out.println("Payment failed. Please try again.");
            return "checkout"; // Redirect back to the checkout page with an error message
        }
    }



    private void clearCart(Long userId) {
        // Implement your logic to clear the user's cart after successful payment

         Cart cart = customerRepo.findById(userId).get().getCart();
         cart.setProducts(new ArrayList<>());
         cart.setTotal(0.0);
         cart.setNumberOfItems(0L);
         cartRepo.save(cart);
    }
}
