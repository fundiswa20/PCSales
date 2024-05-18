package com.example.pcsale.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CheckoutFormDTO {
    private String cardNumber;
    private String expiration;
    private String cvv;

}
