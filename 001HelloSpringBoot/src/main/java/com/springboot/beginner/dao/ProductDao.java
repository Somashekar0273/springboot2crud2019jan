package com.springboot.beginner.dao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Repository;

import com.springboot.beginner.entity.Product;
import com.springboot.beginner.repository.ProductRepository;



@Repository("productDao")
public class ProductDao {
	
	@Autowired
	private ProductRepository productRepository;

	public List<Product> addProduct(Product p) {
		// TODO Auto-generated method stub
		productRepository.saveAndFlush(p);
		List<Product>  productList = productRepository.findAll();
		return productList;
	}

	public List<Product> getAllProducts() {
		// TODO Auto-generated method stub
		/*
		 * use below code to sort it by given entity class variable - categoryId as in given example
		 */
		//Sort mysort = new Sort(new Sort.Order(Direction.ASC, "categoryId"));
		//return productRepository.findAll(mysort);
		
		/*
		 * sort ends
		 */
		return productRepository.findAll();
	}

	public Optional<Product> getProductById(Long myid) {
		// TODO Auto-generated method stub
		return productRepository.findById(myid);	
	}

	public Optional<Product> updateProductById(Long myid, Product p) {
		Optional<Product> pCheck = productRepository.findById(myid);
		if(pCheck.isPresent()) {
			p.setId(myid);
			productRepository.save(p);
			return productRepository.findById(myid);
		}else {
			System.out.println("I am NULL");
			return Optional.empty();
		}		
	}

	public List<Product> deleteProductById(Long id) {
		// TODO Auto-generated method stub
		Optional<Product> pCheck = productRepository.findById(id);
		if(pCheck.isPresent()) {
			productRepository.deleteById(id);
			return productRepository.findAll();
		}else {
			System.out.println("I am NULL");
			return Collections.EMPTY_LIST;
		}
	}

	public List<Product> getProductByCategoryId(int id) {
		
		
		return productRepository.findByCategoryId(id);
		
	}

	public List<Product> getProductByName(String pname) {
		// TODO Auto-generated method stub
		//return productRepository.findByName(pname);			//look for exact name 
		return productRepository.findByNameContaining(pname);	//look for substring
	}

	public List<Product> getAllProductsSort(String entityVariable) {
		// TODO Auto-generated method stub
		/*
		 * use below code to sort it by given entity class variable - categoryId as in given example
		 */
		Sort mysort = new Sort(new Sort.Order(Direction.ASC, entityVariable));
		return productRepository.findAll(mysort);
		
		/*
		 * sort ends
		 */
	}

	public List<Product> getProductByPriceGreaterThan(String order, Long price) {
		// TODO Auto-generated method stub
		
		if(order.equalsIgnoreCase("asc")) {
			Sort mysort = new Sort(new Sort.Order(Direction.ASC, "price"));
			return productRepository.findByPriceGreaterThan(price, mysort);
		}else if(order.equalsIgnoreCase("dsc")) {
			Sort mysort = new Sort(new Sort.Order(Direction.DESC, "price"));
			return productRepository.findByPriceGreaterThan(price, mysort);
		}
		
		return Collections.EMPTY_LIST;
	}

}
