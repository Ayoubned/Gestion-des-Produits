package com.Products.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Products.demo.model.Product;


public interface Productrepository extends JpaRepository<Product, Long>{

	Product save(Product product);

}
