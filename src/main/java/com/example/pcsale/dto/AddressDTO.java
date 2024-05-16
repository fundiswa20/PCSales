package com.example.pcsale.dto;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class AddressDTO {
    private String address;
    private String city;
    private String zip;

    public AddressDTO(String address, String city, String zip) {
        this.address = address;
        this.city = city;
        this.zip = zip;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getZip() {
        return zip;
    }

    public void setCvc(String zip) {
        this.zip = zip;
    }
}
