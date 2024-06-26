package com.example.pcsale.controller;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Paths;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;


import com.example.pcsale.bl.AdminService;
import com.example.pcsale.dto.CartDTO;
import com.example.pcsale.dto.LaptopDTO;
import com.example.pcsale.model.Laptop;

import jakarta.annotation.Resource;
import jakarta.validation.Path;


@Controller
public class AdminController {
    @Autowired
    private AdminService as;
    

    @GetMapping("/admin/home")
    public String homeRequest()
    {
        return "admin_homepage";
    }
    //add stock
    @GetMapping("/admin/add_product")
    public String addProduct()
    {
        return "add_stock";
    }

    @PostMapping("/admin/add_product")
    public String addStock(
        @RequestParam("brand") String brand,
        @RequestParam("name") String name,
        @RequestParam("processor") String processor,
        @RequestParam("storage") String storage,
        @RequestParam("ram") String ram,
        @RequestParam("features") String features,
        @RequestParam("optradio") String condition,
        @RequestParam("price") Double price,
        @RequestParam("image") MultipartFile file
    ) {
        byte[] image = null;
        try {
            image = file.getBytes();
        } catch (IOException e) {
           System.out.println(e.getMessage());
        }

        // Now you have access to all form fields, you can perform necessary operations here
        Laptop laptop = new Laptop(brand, name, processor, storage, ram, features, condition, price, image);
        as.addLaptop(laptop);
        return "add_stock"; // Or whatever view you want to return
    }
    @GetMapping("/admin/view_products")
    public String viewStock(Model model)
    {
        List<LaptopDTO> laptops = as.getStock();
        model.addAttribute("laptops", laptops);
        for(int i = 0 ; i < laptops.size();i++)
        {
            System.out.println(laptops.get(i).getName());
        }
        return "view_stock";
    }

    // @GetMapping("/admin/downloadCartItems/{userId}")
    // public ResponseEntity<Resource> downloadCartItems(@PathVariable Long userId) {
    //     // Define file path
    //     String fileName = "cart_items" + userId + ".txt";
    //     java.nio.file.Path filePath = Paths.get(fileName);
    //     Resource resource;

    //     try {
    //         // Load file as a resource
    //         resource = (Resource) new UrlResource(filePath.toUri());
    //     } catch (MalformedURLException e) {
    //         e.printStackTrace();
    //         return ResponseEntity.notFound().build();
    //     }

    //     // Set the content type for the response
    //     String contentType = "text/plain";
    //     return ResponseEntity.ok()
    //             .contentType(MediaType.parseMediaType(contentType))
    //             .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + fileName + "\"")
    //             .body(resource);
    // }

}
