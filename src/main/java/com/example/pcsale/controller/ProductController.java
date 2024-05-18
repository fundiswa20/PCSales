package com.example.pcsale.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.example.pcsale.dto.CartDTO;
import com.example.pcsale.dto.ProductDTO;
import com.example.pcsale.model.Cart;

import jakarta.servlet.http.HttpSession;

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

    @GetMapping("user/add_to_cart")
    public String addToCart(
        HttpSession session,
        @RequestParam("id") Long product_id,
        Model model
    ) {
        Long id = (Long)session.getAttribute("userid");
        System.out.println("User id: " + id);

        cs.addToCart(id, product_id);
        // Cart cart = cs.getCartDetails(username);
        // model.addAttribute("cart", cart);

        return "redirect:/user/home";

    }

    @GetMapping("user/cart")
    public String getCartDetails(
        @SessionAttribute("userid") Long id,
        Model model
    ) {
        CartDTO cartDTO = cs.getCartDetails(id);
        model.addAttribute("cartDTO", cartDTO);

        return "cart";
    }


}
