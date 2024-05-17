package com.example.pcsale.model;



import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "cart")
    private Customer customer;

    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<Laptop> products;
    private Double total;
    private Long numberOfItems;

    public Cart() {
    }

    public Cart(Customer customer, List<Laptop> products, Double total, Long numberOfItems) {
        this.customer = customer;
        this.products = products;
        this.total = total;
        this.numberOfItems = numberOfItems;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Laptop> getProducts() {
        return products;
    }

    public void setProducts(List<Laptop> products) {
        this.products = products;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }



    public Long getNumberOfItems() {
        return numberOfItems;
    }



    public void setNumberOfItems(Long numberOfItems) {
        this.numberOfItems = numberOfItems;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }


}
