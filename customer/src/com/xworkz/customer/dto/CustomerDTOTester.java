package com.xworkz.customer.dto;

import java.util.Arrays;
import java.util.Collection;
import java.util.Optional;

import com.xworkz.customer.constants.EducationType;
import com.xworkz.customer.dao.CustomerServiceDAO;
import com.xworkz.customer.dao.CustomerServiceDAOImpl;

public class CustomerDTOTester {

	public static void main(String[] args) {
		CustomerDTO dto = new CustomerDTO("Arun", "Banglore", "Chennai", "@HanumanNagar", false, "HU56PO",
				EducationType.BE);

		CustomerServiceDAO dao = new CustomerServiceDAOImpl();
		dao.validateAndSave(dto);

		System.out.println("save all");

		Collection<CustomerDTO> collect = Arrays.asList(dto);
		dao.validateAndSaveAll(collect);

		System.out.println("Find One");

		Optional<CustomerDTO> one = dao.findOne(d -> d.getName().equals("Sunita"));
		if (one.isPresent()) {
			CustomerDTO name = one.get();
			System.out.println(name);
		}

		System.out.println("Find All");
		Collection<CustomerDTO> all = dao.findAll();
		all.forEach(t -> System.out.println(t));

		System.out.println("fina all predicate");
		Collection<CustomerDTO> findAll = dao.findAll(r -> r.getId() == 9);
		findAll.forEach(r -> System.out.println(r));

		System.out.println("Names in Descending order");
		Collection<CustomerDTO> byName = dao.findAllSortByNameDesc();
		byName.forEach(f -> System.out.println(f));
		
		System.out.println("total");
		int total = dao.total();
		System.out.println(total);
		CustomerServiceDAO da = new CustomerServiceDAOImpl();

	}

}
