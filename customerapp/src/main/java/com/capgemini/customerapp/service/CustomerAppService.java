package com.capgemini.customerapp.service;

import java.util.List;

import com.capgemini.customerapp.entity.Customer;
import com.capgemini.customerapp.service.exceptions.CustomerNotFoundException;

public interface CustomerAppService {
	public Customer addCustomer(Customer customer);
	public Customer updateProfile(Customer customer);
	public Customer authenticate(Customer customer) throws CustomerNotFoundException;
	public Customer getCustomer(int customerId) throws CustomerNotFoundException;
	public void deleteCustomer(Customer customer);
	public Customer findCustomerById(int customerId) throws CustomerNotFoundException;
	public List<Customer> getAllCustomers();
	
}
