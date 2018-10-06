package com.capgemini.customerapp.test;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.capgemini.customerapp.controller.CustomerAppController;
import com.capgemini.customerapp.entity.Customer;
import com.capgemini.customerapp.service.CustomerAppService;


@RunWith(SpringRunner.class)
@SpringBootTest
public class CustomerControllerTest {
	private MockMvc mockMvc;

	@Mock
	private CustomerAppService customerAppService;
	@InjectMocks
	private CustomerAppController customerAppController;
	
	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		mockMvc = MockMvcBuilders.standaloneSetup(customerAppController).build();
	}
	@Test
	public void testAddCustomer() throws Exception {
		String content = "{\"customerId\" : 111,\r\n" + 
				" \"customerName\" : \"Tom\",\r\n" + 
				" \"customerPassword\" : \"t1\",\r\n" + 
				" \"customerEmail\" : \"tom@gmail.com\",\r\n" + 
				" \"customerAddress\" : \"abc\"}";
		when(customerAppService.addCustomer(Mockito.isA(Customer.class)))
		.thenReturn(new Customer(111, "Tom", "t1","tom@gmail.com", "abc"));
mockMvc.perform(post("/customer").contentType(MediaType.APPLICATION_JSON_UTF8).content(content)).andDo(print())
		.andExpect(jsonPath("$.customerId").value(111));

}

}

