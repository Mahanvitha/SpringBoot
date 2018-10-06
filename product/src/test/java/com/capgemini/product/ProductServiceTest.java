package com.capgemini.product;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.capgemini.product.entities.Product;
import com.capgemini.product.repository.ProductRepository;
import com.capgemini.product.service.impl.ProductServiceImpl;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class ProductServiceTest {
	@InjectMocks
	ProductServiceImpl productServiceImpl;

	@Mock
	ProductRepository productRepository;
	private MockMvc mockMvc;

	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		mockMvc = MockMvcBuilders.standaloneSetup(productServiceImpl).build();
	}
//
//	@Test
//	public void addProductTest() {
//		Product product = new Product(123, "samsung", "mobile", 10000.0);
//		when(productRepository.save(product)).thenReturn(product);
//		Product addProduct = productServiceImpl.addProduct(product);
//		assertEquals(123, addProduct.getProductId());
//	}

//	@Test
//	public void updateproductTest() {
//
//		Product product = new Product(123, "oppo", "mobile", 12000.0);
//		when(productRepository.save(product)).thenReturn(product);
//		Product updateProduct = productServiceImpl.updateProduct(product);
//		assertEquals(123, updateProduct.getProductId());
//		assertEquals("oppo", updateProduct.getProductName());
//		assertEquals("mobile", updateProduct.getProductCategory());
//		assertEquals(12000, updateProduct.getProductPrice(), 1);
//
//	}
//
//	@Test
//	public void findProductByIdTest() throws ProductNotFoundException {
//
//		Product product = new Product(123, "oppo", "mobile", 12000.0);
//		when(productRepository.findById(123)).thenReturn(Optional.of(product));
//		Product result = productServiceImpl.findProductById(123);
//		assertEquals(123, result.getProductId());
//		assertEquals("oppo", result.getProductName());
//		assertEquals("mobile", result.getProductCategory());
//		assertEquals(12000, result.getProductPrice(), 1);
//	}

	@Test
	public void deleteProductTest() {
		Product product = new Product(123, "samsung", "mobile", 11100.0);
		productServiceImpl.deleteProduct(product);
		verify(productRepository, times(1)).delete(product);
	}
}