package com.example.pcsale.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.pcsale.dto.ProductDTO;
import com.example.pcsale.bl.CustomerService;



@Controller
public class ProductController {
    @Autowired
    private CustomerService cs;
    @GetMapping("/user/brand")
    public String showBrandList(
        @RequestParam("brand") String brand,
        Model model
    ) {
        List<ProductDTO> productDTOs = cs.getProduct(brand);
        model.addAttribute("productDTOs", productDTOs);
        System.out.println(productDTOs.size());
        return "products";
    }

    @GetMapping("/user/shop")
    public String showLaptopList(Model model, String brand) {
        return "laptop_list";
    }

    @GetMapping("/user/customer_serv")
    public String customerServ() {

        return "";
    }
    @GetMapping("/user/customer_signup")
    public String customerSignup() {

        return "signup";
    }
    @GetMapping("/user/customer_login")
    public String customerLogin() {

        return "login";
    }

    @GetMapping("/user/add_to_cart")
    public String addToCart() {

        return "cart";
    }
    @GetMapping("/user/checkout")
    public String checkoutPage() {

        return "checkout";
    }
    @GetMapping("/user/confirm_pay")
    public String confirmPayment() {

        return "payment_result";
    }

}
