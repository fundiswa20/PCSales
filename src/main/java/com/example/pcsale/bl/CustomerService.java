package com.example.pcsale.bl;

import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.pcsale.dto.ProductDTO;
import com.example.pcsale.model.Laptop;
import com.example.pcsale.repository.LapTopRepository;

@Service
public class CustomerService {
   @Autowired
    private LapTopRepository laptopRepo;

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

}
