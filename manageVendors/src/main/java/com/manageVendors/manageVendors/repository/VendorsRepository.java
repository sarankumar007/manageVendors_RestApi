package com.manageVendors.manageVendors.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.manageVendors.manageVendors.entity.Vendors;



public interface VendorsRepository extends JpaRepository<Vendors,Integer> {
    Vendors findByName(String name);
}