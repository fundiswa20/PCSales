package com.example.pcsale.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.example.pcsale.bl.AddressService;
import com.example.pcsale.bl.PaymentService;
import com.example.pcsale.dto.AddressDTO;
import com.example.pcsale.dto.PaymentDTO;

@Controller
@RequestMapping("payment")
public class PaymentController {
    private final PaymentService paymentService;
    private final AddressService addressService;

    public PaymentController(PaymentService paymentService, AddressService addressService) {
        this.paymentService = paymentService;
        this.addressService = addressService;
    }

    @PostMapping
    public String postPayment(@RequestBody PaymentDTO paymentDTO, @RequestBody AddressDTO addressDTO) {
        paymentService.processPayment(paymentDTO.getCardNumber(), paymentDTO.getExpiration(), paymentDTO.getCvc());
        addressService.saveAddress(addressDTO.getAddress(), addressDTO.getCity(), addressDTO.getZip());
        return "Payment Successful";
    }
}
