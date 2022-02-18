package com.abc.ecom.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.abc.ecom.entity.Product;
import com.abc.ecom.service.ProductService;

@RestController
public class ProductController {

	@Autowired
	private ProductService productService;
	
	@PostMapping("/product/save")
	public ResponseEntity<Product> addProduct(@RequestBody Product product) {
		
		Product newProduct = productService.saveProduct(product);
		
		ResponseEntity<Product> responseEntity = new ResponseEntity<>(newProduct,HttpStatus.CREATED);
		
		return responseEntity;		
		
	}
	
	@GetMapping("/product/all")
	public List<Product> fetchAllProducts() {
		
		List<Product> products = productService.getAllProducts();
		
		return products;
	}
	
	@GetMapping("/product/get/{pid}")
	public  ResponseEntity<?> fetchProductDetails(@PathVariable("pid") int productId) {
		
		ResponseEntity<?> responseEntity = null;
		
		Product product = productService.getProductById(productId);
		
		if(product!= null ) {
			responseEntity = new ResponseEntity<>(product,HttpStatus.OK);
		}
		else {
			responseEntity = new ResponseEntity<>("Product not available with id: "+productId,HttpStatus.NOT_FOUND);
		}
		
		return responseEntity;
	}
	
}
