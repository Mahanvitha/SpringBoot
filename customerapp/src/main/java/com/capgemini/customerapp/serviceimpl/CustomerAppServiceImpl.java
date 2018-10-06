package com.capgemini.customerapp.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.customerapp.entity.Customer;
import com.capgemini.customerapp.repository.CustomerAppRepository;
import com.capgemini.customerapp.service.CustomerAppService;
import com.capgemini.customerapp.service.exceptions.CustomerNotFoundException;

@Service
public class CustomerAppServiceImpl implements CustomerAppService {
	@Autowired
	CustomerAppRepository customerAppRepository;

	@Override
	public Customer authenticate(Customer customer) throws CustomerNotFoundException {
		Optional<Customer> optionalCustomer = customerAppRepository.findById(customer.getCustomerId());
		if (optionalCustomer.isPresent()) {
			Customer cust = optionalCustomer.get();
			if (customer.getCustomerId() == cust.getCustomerId()) {
				if (cust.getCustomerPassword().equals(customer.getCustomerPassword())) {
					return customerAppRepository.findById(customer.getCustomerId()).get();
				}
				throw new CustomerNotFoundException("Id or Password does not exists.");
			}
		}
		throw new CustomerNotFoundException("Customer does not exists");
	}

	@Override
	public Customer updateProfile(Customer customer) {

		return customerAppRepository.save(customer);
	}
    @Override
	public Customer getCustomer(int customerId) throws CustomerNotFoundException {
		Optional<Customer> optionalProduct = customerAppRepository.findById(customerId);
		if (optionalProduct.isPresent())
			return optionalProduct.get();
		throw new CustomerNotFoundException("Customer does not exists");
	}

	@Override
	public Customer addCustomer(Customer customer) {
		return customerAppRepository.save(customer);
	}

	@Override
	public void deleteCustomer(Customer customer) {
		customerAppRepository.delete(customer);
	}

	@Override
	public List<Customer> getAllCustomers() {
		return customerAppRepository.findAll();
	}

	@Override
	public Customer findCustomerById(int customerId) throws CustomerNotFoundException {
		Optional<Customer> optionalCustomer = customerAppRepository.findById(customerId);
		if(optionalCustomer.isPresent())
			return optionalCustomer.get();
		throw new CustomerNotFoundException("Customer does not exists");
	}

}
