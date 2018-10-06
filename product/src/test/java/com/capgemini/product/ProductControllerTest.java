package com.capgemini.product;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

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
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.capgemini.product.controller.ProductController;
import com.capgemini.product.entities.Product;
import com.capgemini.product.service.ProductService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductControllerTest {

	private MockMvc mockMvc;
	@Mock
	private ProductService productService;

	@InjectMocks
	private ProductController productController;

	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		mockMvc = MockMvcBuilders.standaloneSetup(productController).build();
	}

	@Test
	public void testAddProduct() throws Exception {
		String content = "{ \"productId\": 123,\"productName\": \"Lenovo\",\"productCategory\": \"computer\",\"productPrice\": 10000}";

		when(productService.addProduct(Mockito.isA(Product.class)))
				.thenReturn(new Product(123, "Lenovo 5", "computer", (double) 10000));
		mockMvc.perform(post("/product").contentType(MediaType.APPLICATION_JSON_UTF8).content(content)).andDo(print())
				.andExpect(jsonPath("$.productId").value(123));

	}

	@Test
	public void testUpdateProduct() throws Exception {
		String content = "{ \"productId\": 123,\"productName\": \"Lenovo\",\"productCategory\": \"computer\",\"productPrice\": 10000}";
		when(productService.addProduct(Mockito.isA(Product.class)))
		.thenReturn(new Product(123, "Lenovo 5", "computer", (double) 15000));
	    when(productService.findProductById(123)).thenReturn(new Product(123,"oppo","mobile",10000.0));
	    
	  mockMvc.perform(put("/product").contentType(MediaType.APPLICATION_JSON).content(content)
	    .accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
		.andExpect(jsonPath("$.productId").exists()).andExpect(jsonPath("$.productName").exists())
		.andExpect(jsonPath("$.productCategory").exists()).andExpect(jsonPath("$.productPrice").exists())
		.andExpect(jsonPath("$.productId").value(123)).andExpect(jsonPath("$.productId").value("oppo"))
		.andExpect(jsonPath("$.productCategory").value("mobile")).andExpect(jsonPath("$.productPrice").value(10000)).andDo(print());

	}
	@Test
	public void testFindProductById() throws Exception {

		when(productService.findProductById(123)).thenReturn(new Product(123, "vivo", "mobile", 12000.0));

		mockMvc.perform(MockMvcRequestBuilders.get("/product/123").accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk()).andExpect(jsonPath("$.productId").exists())
				.andExpect(jsonPath("$.productName").exists()).andExpect(jsonPath("$.productCategory").exists())
				.andExpect(jsonPath("$.productPrice").exists()).andExpect(jsonPath("$.productId").value(123))
				.andExpect(jsonPath("$.productName").value("vivo"))
				.andExpect(jsonPath("$.productCategory").value("mobile"))
				.andExpect(jsonPath("$.productPrice").value(12000.0)).andDo(print());
	}
	@Test
	public void testDeleteproduct() throws Exception {
		when(productService.findProductById(1234)).thenReturn(new Product(123, "vivo", "mobile", 12000.0));
		mockMvc.perform(delete("/product/1234").accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk());
	}
}

	