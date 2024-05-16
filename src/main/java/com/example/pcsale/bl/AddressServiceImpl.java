package com.example.pcsale.bl;

import com.example.pcsale.repository.AddressRepository;
import com.example.pcsale.model.Address;

import org.springframework.stereotype.Service;

@Service

public class AddressServiceImpl implements AddressService {

    private final AddressRepository addressRepository;

    public AddressServiceImpl(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    @Override
    public void saveAddress(String address, String city, String zip) {
        Address addres = new Address(address, city, zip);
        addressRepository.save(addres);
    }

}
