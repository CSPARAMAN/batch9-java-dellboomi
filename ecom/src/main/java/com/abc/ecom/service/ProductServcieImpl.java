package com.abc.ecom.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abc.ecom.entity.Product;
import com.abc.ecom.repository.ProductRepository;

@Service
public class ProductServcieImpl implements ProductService {
	
	@Autowired
	private ProductRepository productRepository;

	@Override
	public void saveProduct(Product product) {
		
		productRepository.save(product);
	}

}
