package com.example.pcsale.bl;

import com.example.pcsale.repository.AddressRepository;
import com.example.pcsale.model.Address;

import java.io.Serializable;

import org.springframework.stereotype.Service;

@Service

public class AddressServiceImpl implements Serializable {

    private  AddressRepository addressRepository;

    public void saveAddress(Address address) {
        addressRepository.save(address);
    }

}
