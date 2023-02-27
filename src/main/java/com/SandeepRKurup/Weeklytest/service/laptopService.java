package com.SandeepRKurup.Weeklytest.service;

import com.SandeepRKurup.Weeklytest.model.Laptop;
import com.SandeepRKurup.Weeklytest.repository.laptopRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class laptopService {
    @Autowired
    laptopRepository laptopRepository;

    public void addLaptop(Laptop laptop) {
        laptopRepository.save(laptop);
    }

    public List<Laptop> getAllLaptop() {
        return laptopRepository.findAll();
    }

    public String deleteLaptop(String laptopId) {
        for (Laptop laptop : laptopRepository.findAll()) {
            if (Objects.equals(laptop.getLaptop_id(), Integer.valueOf(laptopId))){
                laptopRepository.delete(laptop);
                return "Deleted";
            }
        }
        return "Not found";
    }

}
