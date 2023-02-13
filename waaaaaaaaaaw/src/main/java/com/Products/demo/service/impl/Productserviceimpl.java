package com.Products.demo.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.stereotype.Service;

import com.Products.demo.exception.ressourcenotfoundexception;
import com.Products.demo.model.Product;
import com.Products.demo.repository.Productrepository;
import com.Products.demo.service.Productservice;

@Service
public class Productserviceimpl implements Productservice{
	
	private Productrepository productreository;
	
	

	public Productserviceimpl(Productrepository productreository) {
		super();
		this.productreository = productreository;
	}



	@Override
	public Product saveProduct(Product product) {
		return productreository.save(product);
	}



	@Override
	public List<Product> getAllProducts() {
		return productreository.findAll();
	}



	@Override
	public Product getProductById(long id) {
		Optional<Product> product = productreository.findById(id);
		if(product.isPresent()) {
			return product.get();
		}else {
			throw new ressourcenotfoundexception("Product", "id", id);
		}
		
		// or : return productreository.findById(id).orElseThrow(() -> new ressourcenotfoundexception("Product", "id", id));
	}



	@Override
	public Product UpdateProduct(Product product, long id) {
		Product existingproduct = productreository.findById(id).orElseThrow(() -> new ressourcenotfoundexception("Product", "id", id));
		existingproduct.setName(product.getName());
		existingproduct.setPrice(product.getPrice());
		
		productreository.save(existingproduct);
		return existingproduct;
	}



	@Override
	public void Deleteproduct(long id) {
		
		productreository.findById(id).orElseThrow(() -> new ressourcenotfoundexception("Product", "id", id));
		
		productreository.deleteById(id);
		
	}

}
