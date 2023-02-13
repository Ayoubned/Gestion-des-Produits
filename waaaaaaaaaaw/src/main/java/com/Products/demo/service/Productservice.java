package com.Products.demo.service;

import java.util.List;

import com.Products.demo.model.Product;

public interface Productservice {
	
	Product saveProduct(Product product);
	List<Product> getAllProducts();
	Product getProductById(long id);
	Product UpdateProduct(Product product,long id);
	void Deleteproduct(long id);

}
