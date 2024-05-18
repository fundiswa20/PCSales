package com.example.pcsale.controller;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.example.pcsale.bl.CustomerService;
import com.example.pcsale.model.Card;
import com.example.pcsale.model.Cart;
import com.example.pcsale.model.Customer;

import jakarta.servlet.http.HttpSession;



@Controller
public class CustomerController implements Serializable{

    @Autowired
    private CustomerService cs;
    @PostMapping("/user/add_customer")
    public String addCustomer(
            @RequestParam("name") String name,
            @RequestParam("surname") String surname,
            @RequestParam("id") String id,
            @RequestParam("username") String username,
            @RequestParam("password") String password,
            @RequestParam("confirmPassword") String confirmPassword
    ) {
        // Check if the password matches the confirm password
        if (!password.equals(confirmPassword)) {
            // Password and confirm password do not match, handle the error (e.g., show an error message)
            return "redirect:/customer_signup"; // Redirect to an error page
        }

        // Passwords match, proceed with adding the customer (you can add your logic here)
        // For now, let's just print the details
        System.out.println("Name: " + name);
        System.out.println("Surname: " + surname);
        System.out.println("ID: " + id);
        System.out.println("Username: " + username);
        System.out.println("Password: " + password);

        // Assuming there's a method to add the customer in your service or repository
        // userService.addCustomer(name, surname, id, username, password);
        Card card = new Card();

        Cart cart = new Cart();

        Customer customer = new Customer(name,surname,id,username,password,cart,card);
        cs.addCustomer(customer);
        // Redirect to a success page or any other appropriate page
        return "redirect:/user/customer_login";
    }

    @GetMapping("/user/home_p")
    public String goToHome()
    {
        return "homepage2";
    }

    @PostMapping("/user/login")
    public String login(
            @RequestParam("username") String username,
            @RequestParam("password") String password,
            HttpSession session,
            Model model
    ) {
        // Retrieve user from the database based on the provided username
        Boolean isFound = cs.findByUsername(username, password);

        // Check if the user exists and if the provided password matches the stored password
        if (isFound ) {

            System.out.println("Login successful for user: " + username);

            session.setAttribute("userid", cs.getUserID(username));

            // Redirect the user to the home page or any other appropriate page
            return "homepage2";
        } else {

            model.addAttribute("error", "Invalid username or password");
            return "login_page"; // Redirect the user back to the login page with an error message
        }
    }


}
