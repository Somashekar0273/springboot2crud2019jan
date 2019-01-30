package com.springboot.beginner.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.beginner.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

	List<Product> findByCategoryId(int categoryId);
	List<Product> findByName(String name);
	
	List<Product> findByNameContaining(String name);
	
	List<Product> findByPriceGreaterThan(Long price, Sort sort);
	
	
}
