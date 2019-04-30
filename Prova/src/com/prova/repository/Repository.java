package com.prova.repository;

import java.util.List;

import com.prova.entity.Customer;
import com.prova.entity.Sale;
import com.prova.entity.Salesman;

public interface Repository {

	List<Salesman> getSalesmans();

	List<Customer> getCustomers();

	List<Sale> getSales();
	

}