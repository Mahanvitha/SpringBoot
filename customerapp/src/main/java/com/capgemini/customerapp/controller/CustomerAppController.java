package com.capgemini.customerapp.controller;

import java.util.List;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.customerapp.entity.Customer;
import com.capgemini.customerapp.service.CustomerAppService;
import com.capgemini.customerapp.service.exceptions.CustomerNotFoundException;



@RestController
public class CustomerAppController {
private final static Logger LOGGER = Logger.getLogger(CustomerAppController.class.getName());
	@Autowired
	CustomerAppService customerAppService;
	
//	@PostMapping("/customer")
//	public ResponseEntity<Customer> addCustomer(@RequestBody Customer customer){
//		ResponseEntity<Customer> responseEntity = new ResponseEntity<Customer>(customerAppService.addCustomer(customer),HttpStatus.OK);
//		LOGGER.info("xyz");
//		return responseEntity;
//	}

//	@PutMapping("/customer")
//	public ResponseEntity<Customer> updateCustomer(@RequestBody Customer customer){
//		try {
//			Customer c= customerAppService.findCustomerById(customer.getCustomerId());
//			if(c!=null)
//				return new ResponseEntity<Customer>(customerAppService.updateProfile(customer),HttpStatus.OK);
//		}
//		catch(CustomerNotFoundException exception) {
//			
//		}
//		return new ResponseEntity<Customer>(HttpStatus.NOT_FOUND);
//	}
//
//	@PostMapping("/customer")
//	public ResponseEntity<Customer> authenticateCustomer(@RequestBody Customer customer) throws CustomerNotFoundException{
//		return new ResponseEntity<Customer>(customerAppService.authenticate(customer),HttpStatus.OK);
//	}
//	
//	@DeleteMapping("/customer/{customerId}")
//	public ResponseEntity<Customer> deleteCustomer(@PathVariable int customerId){
//		try {
//			Customer customerFromDb =  customerAppService.findCustomerById(customerId);
//			if(customerFromDb != null) {
//				customerAppService.deleteCustomer(customerFromDb);
//				return new ResponseEntity<Customer>(HttpStatus.OK);
//			}
//		}catch(CustomerNotFoundException exception) {
//			
//		}
//		return new ResponseEntity<Customer>(HttpStatus.NOT_FOUND);
//	}
//
//	@GetMapping("/customer/{customerId}")
//	public ResponseEntity<Customer> findCustomerById(@PathVariable int customerId){
//		try {
//			Customer c = customerAppService.findCustomerById(customerId);
//		if(c!=null)
//			return new ResponseEntity<Customer>(c,HttpStatus.OK);
//		}
//		catch(CustomerNotFoundException exception) {
//			
//		}
//		return new ResponseEntity<Customer>(HttpStatus.NOT_FOUND);
//	}
	@GetMapping("/customer/{customerId}")
	public ResponseEntity<Customer> getCustomer(@PathVariable int customerId){
		try {
			Customer c = customerAppService.findCustomerById(customerId);
		if(c!=null)
			return new ResponseEntity<Customer>(c,HttpStatus.OK);
		}
		catch(CustomerNotFoundException exception) {
			
		}
		return new ResponseEntity<Customer>(HttpStatus.NOT_FOUND);
	}
	
//	@GetMapping("/customer/{customerId}")
//	public @ResponseBody ResponseEntity<List<Customer>> findAllCustomer(){
//		return new ResponseEntity<List<Customer>>(customerAppService.getAllCustomers(),HttpStatus.OK);
//	}
//	
//	
//
//}
//
//
//
}