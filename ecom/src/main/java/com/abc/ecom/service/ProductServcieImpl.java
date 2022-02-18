package com.abc.ecom.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abc.ecom.entity.Product;
import com.abc.ecom.repository.ProductRepository;

@Service
public class ProductServcieImpl implements ProductService {
	
	@Autowired
	private ProductRepository productRepository;

	@Override
	public Product saveProduct(Product product) {
		
		Product savedProduct = productRepository.save(product);
		
		return savedProduct;
	}

	@Override
	public List<Product> getAllProducts() {
		List<Product> products = productRepository.findAll();
		return products;
	}

	@Override
	public Product getProductById(int productId) {
		Product product = null;
		Optional<Product> optionalProduct = productRepository.findById(productId);
		
		if(optionalProduct.isPresent()) {
			return optionalProduct.get();
		}
		else {
			return product;
		}
		
	}

}
