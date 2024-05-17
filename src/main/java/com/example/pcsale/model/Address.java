package com.example.pcsale.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "address")
    private String address;
    @Column(name = "city")
    private String city;
    @Column(name = "zip")
    private String zip;

    @OneToOne(cascade = CascadeType.ALL,mappedBy = "address")
    private Customer customer;

    public Address(String address, String city, String zip, Customer customer) {
        this.address = address;
        this.city = city;
        this.zip = zip;
        this.customer = customer;
    }

    
}
