package com.abc.ecom.controller;

import org.springframework.beans.factory.annotation.Autowired;
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
	public void addProduct(@RequestBody Product product) {
		
		productService.saveProduct(product);
		
	}
	
}
