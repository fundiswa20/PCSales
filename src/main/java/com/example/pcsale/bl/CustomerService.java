package com.example.pcsale.bl;

import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.pcsale.dto.CartDTO;
import com.example.pcsale.dto.ProductDTO;
import com.example.pcsale.model.Cart;
import com.example.pcsale.model.Customer;
import com.example.pcsale.model.Laptop;
import com.example.pcsale.repository.CartRepository;
import com.example.pcsale.repository.CustomerRepository;
import com.example.pcsale.repository.LapTopRepository;

@Service
public class CustomerService {
   @Autowired
    private LapTopRepository laptopRepo;
    @Autowired
    private CustomerRepository customerRepo;

    @Autowired
    private CartRepository cartRepo;

    public List<ProductDTO> getProduct(String brand)
    {
        List<Laptop> laptop =  laptopRepo.findAll();
        List<ProductDTO> productDTOs = new ArrayList<>();

        for (Laptop lt : laptop) {
            if(brand.equalsIgnoreCase(lt.getBrand()))
            {
                productDTOs.add(new ProductDTO(lt.getId().toString(),lt.getBrand(), lt.getName(), lt.getProcessor(), lt.getStorage(), lt.getRam(), lt.getAdditionalFeatures(), lt.getCondition(), lt.getPrice().toString(), "data:image/png;base64," + Base64.getEncoder().encodeToString(lt.getImage())));
            }
        }
        return productDTOs;
    }
    // Method to get cart details
    public CartDTO getCartDetails(Long id) {
        Cart cart = customerRepo.findById(id).get().getCart();
        List<Laptop> list = cart.getProducts();

        CartDTO cartDTO = new CartDTO();
        cartDTO.setNumberOfItems(cart.getNumberOfItems().toString());
        cartDTO.setTotal(cart.getTotal().toString());

        for (Laptop l : list) {
            cartDTO.getProducts().add(new ProductDTO(l.getBrand(), l.getName(), l.getPrice().toString()));
        }

        return cartDTO;
    }


    public void addCustomer(Customer customer)
    {
        customerRepo.save(customer);
    }

    public Boolean findByUsername(String username,String password) {
        List<Customer> list = customerRepo.findAll();


        for (Customer customer : list) {

            if(customer.getUsername().equals(username) && customer.getPassword().equals(password))
            {
                return true;
            }

        }

        //Customer customer = customerRepository.findByUsername(username);
        return false;
    }
        public Long getUserID(String username) {
            Customer cust = customerRepo.findByUsername(username);

            return cust.getId();
        }

        public void addToCart(Long id, Long product_id) {
            Laptop product = laptopRepo.findById(product_id).get();

            Cart cart = customerRepo.findById(id).get().getCart();

            List<Laptop> list = cart.getProducts();

            list.add(product);

            cart.setProducts(list);
            cart.setTotal(cart.getTotal() + product.getPrice());
            cart.setNumberOfItems(cart.getNumberOfItems() + 1);

            cartRepo.save(cart);
        }
        // public List<Cart> getCartItemsByUserId(Long userId) {
        //     return cartRepo.findByUserId(userId);
        // }

}
