package com.manageVendors.manageVendors.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.manageVendors.manageVendors.entity.Vendors;
import com.manageVendors.manageVendors.repository.VendorsRepository;

import java.util.List;

@Service
public class VendorService {
    @Autowired
    private VendorsRepository repository;

    public Vendors savevendor(Vendors vendor) {
        return repository.save(vendor);
    }

    public List<Vendors> savevendors(List<Vendors> vendors) {
        return repository.saveAll(vendors);
    }

    public List<Vendors> getvendors() {
        return repository.findAll();
    }

    public Vendors getvendorById(int id) {
        return repository.findById(id).orElse(null);
    }

    public Vendors getvendorByName(String name) {
        return repository.findByName(name);
    }

    public String deletevendor(int id) {
        repository.deleteById(id);
        return "vendor removed !! " + id;
    }

    public Vendors updatevendor(int id,Vendors vendor) {
    	
        Vendors existingvendor = repository.findById(id).orElse(null);
        existingvendor.setName(vendor.getName());
        existingvendor.setCode(vendor.getCode());
        existingvendor.setAddress(vendor.getAddress());
        existingvendor.setCity(vendor.getCity());
        existingvendor.setState(vendor.getState());
        existingvendor.setPincode(vendor.getPincode());
        existingvendor.setPhone(vendor.getPhone());
        existingvendor.setEmail(vendor.getEmail());
        existingvendor.setPrice(vendor.getPrice());
       
        return  repository.save(existingvendor);
    }


}
