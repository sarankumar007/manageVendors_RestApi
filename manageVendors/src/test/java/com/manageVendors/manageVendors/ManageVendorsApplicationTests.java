package com.manageVendors.manageVendors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.manageVendors.manageVendors.entity.Vendors;
import com.manageVendors.manageVendors.repository.VendorsRepository;


@SpringBootTest
class ManageVendorsApplicationTests {
	@Autowired
	private VendorsRepository repository;
	
	
	@Test
	@Order(1)
	public void testCreate() {
		Vendors vendors=new Vendors();
		vendors.setAddress("abc");
		vendors.setName("v");
		vendors.setCode("343dfdf");
		vendors.setCity("chennai");
		vendors.setState("tn");
		vendors.setPrice(55);
		vendors.setPincode(600076);
		vendors.setPhone(8876543231l);
		vendors.setEmail("saran@gmail.com");
		repository.save(vendors);
		assertNotNull(repository.findByName("hari"));
	}
	@Test
	@Order(2)
	public void testRead() {
		List list=repository.findAll();
		assertThat(list).size().isGreaterThan(0);
	}
	
	@Test
	@Order(3)
	public void testUpdate() {
		Vendors vendors=repository.findByName("hari");
		vendors.setPrice(800.00);
		repository.save(vendors);
		assertNotEquals(700.00,repository.findByName("hari").getPrice());
	}
	
	@Test
	@Order(4)
	public void testDelete() {
		repository.deleteById(1);
		assertThat(repository.existsById(1)).isFalse();
	}
	
	

}
