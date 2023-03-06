package com.manageVendors.manageVendors.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.manageVendors.manageVendors.entity.Vendors;
import com.manageVendors.manageVendors.exception.ResponseMessage;
import com.manageVendors.manageVendors.exception.UserException;
import com.manageVendors.manageVendors.service.VendorService;

import jakarta.servlet.http.HttpServletRequest;

import java.util.List;

@RestController
public class VendorController {

    @Autowired
    private VendorService service;

    @PostMapping("/addVendor")
    public ResponseEntity<ResponseMessage> addVendors(@RequestBody Vendors vendor,HttpServletRequest req) throws UserException{
    	try {
         service.savevendor(vendor);
         return new ResponseEntity<ResponseMessage>(new ResponseMessage("Added User successfully","Added",req.getRequestURI()),HttpStatus.OK);
    	}catch (Exception ex) {
    		return new ResponseEntity<ResponseMessage>(new ResponseMessage("Vendor code must be unique",ex.getMessage(), req.getRequestURI()),HttpStatus.NOT_FOUND);
		}
    }

    @PostMapping("/addVendors")
    public ResponseEntity<ResponseMessage> addVendorss(@RequestBody List<Vendors> vendors,HttpServletRequest req)throws UserException {
    	try {
            service.savevendors(vendors);
            return new ResponseEntity<ResponseMessage>(new ResponseMessage("Added User successfully","Added",req.getRequestURI()),HttpStatus.OK);
       	}catch (Exception ex) {
       		return new ResponseEntity<ResponseMessage>(new ResponseMessage("Vendor code must be unique",ex.getMessage(), req.getRequestURI()),HttpStatus.NOT_FOUND);
   		}
    }

    @GetMapping("/vendors")
    public List<Vendors> findAllVendorss() {
        return service.getvendors();
    }

    @GetMapping("/vendorById/{id}")
    public Vendors findVendorsById(@PathVariable int id) {
        return service.getvendorById(id);
    }

    @GetMapping("/vendoryByName/{name}")
    public Vendors findVendorsByName(@PathVariable String name) {
        return service.getvendorByName(name);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<ResponseMessage> updateVendors(@PathVariable int  id , @RequestBody Vendors product,HttpServletRequest req) throws UserException{
    	try {
         service.updatevendor(id,product);
         return new ResponseEntity<ResponseMessage>(new ResponseMessage("Updated User successfully","Updated",req.getRequestURI()),HttpStatus.OK);
    	}
    	catch (Exception ex) {
    		return new ResponseEntity<ResponseMessage>(new ResponseMessage("Cannot find user with an id:"+id+"",ex.getMessage(), req.getRequestURI()),HttpStatus.NOT_FOUND);
		}
    }

    @DeleteMapping("/delete/{id}")
    public String deleteVendors(@PathVariable int id) {
        return service.deletevendor(id);
    }
}