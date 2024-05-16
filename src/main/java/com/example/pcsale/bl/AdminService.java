package com.example.pcsale.bl;

import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.pcsale.dto.LaptopDTO;
import com.example.pcsale.model.Laptop;
import com.example.pcsale.repository.LapTopRepository;

@Service
public class AdminService {

    @Autowired
    private LapTopRepository laptopRepo;

    public void addLaptop(Laptop laptop) {

        laptopRepo.save(laptop);
    }

    public List<LaptopDTO> getStock() {
        List<Laptop> laptop =  laptopRepo.findAll();
        List<LaptopDTO> laptopDTOs = new ArrayList<>();

        for (Laptop lt : laptop) {
            laptopDTOs.add(new LaptopDTO(lt.getBrand(), lt.getName(), lt.getProcessor(), lt.getStorage(), lt.getRam(), lt.getAdditionalFeatures(), lt.getCondition(), lt.getPrice().toString(), "data:image/png;base64," + Base64.getEncoder().encodeToString(lt.getImage())));
        }
       return laptopDTOs;
    }
}
