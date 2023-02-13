package com.Products.demo.Controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Products.demo.model.Product;
import com.Products.demo.service.Productservice;

@RestController
@RequestMapping("/api/products")
public class Productcontroller {
	
	private Productservice productservice;

	public Productcontroller(Productservice productservice) {
		super();
		this.productservice = productservice;
	}
	
	//create product REST API
	@PostMapping
	public ResponseEntity<Product> saveProduct(@RequestBody Product product){
		
		return new ResponseEntity<Product>(productservice.saveProduct(product), HttpStatus.CREATED);
		
	}
	
	//get all products REST API
	@GetMapping
	public List<Product> getAllProducts(){
		return productservice.getAllProducts();
	}
	
	//get product by id REST API 
	// http://localhost:8080/api/products/1
	@GetMapping("{id}")
	public ResponseEntity<Product> getProductById(@PathVariable("id") long productid){
		return new ResponseEntity<Product>(productservice.getProductById(productid), HttpStatus.OK);
	}
	
	//update product REST API
	@PutMapping("{id}")
	public ResponseEntity<Product> UpdateProduct(@PathVariable("id") long id,@RequestBody Product product ){
		return new ResponseEntity<Product>(productservice.UpdateProduct(product, id), HttpStatus.OK);
	}
	
	//delete product REST API
	@DeleteMapping("{id}")
	public ResponseEntity<String> Deleteproduct(@PathVariable("id") long id){
		productservice.Deleteproduct(id);
		
		return new ResponseEntity<String>("Product deleted successfully", HttpStatus.OK);
	}

}
