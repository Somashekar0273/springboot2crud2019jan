package com.springboot.beginner.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springboot.beginner.dao.ProductDao;
import com.springboot.beginner.entity.Product;

@Service("productService")
public class ProductService {
	
	@Autowired
	private ProductDao productDao;

	@Transactional
	public List<Product> addProduct(Product p) {
		// TODO Auto-generated method stub
		return productDao.addProduct(p);
	}

	public List<Product> getAllProducts() {
		// TODO Auto-generated method stub
		return productDao.getAllProducts();
	}

	public Optional<Product> getProductById(Long myid) {
		// TODO Auto-generated method stub
		return productDao.getProductById(myid);
	}

	public Optional<Product> updateProductById(Long myid, Product p) {
		// TODO Auto-generated method stub
		return productDao.updateProductById(myid, p);
	}

	public List<Product> deleteProductById(Long id) {
		// TODO Auto-generated method stub
		return productDao.deleteProductById(id);
	}

	public List<Product> getProductByCategoryId(int id) {
		// TODO Auto-generated method stub
		return productDao.getProductByCategoryId(id);
	}

	public List<Product> getProductByName(String pname) {
		// TODO Auto-generated method stub
		return productDao.getProductByName(pname);
	}

	public List<Product> getAllProductsSort(String entityVariable) {
		// TODO Auto-generated method stub
		return productDao.getAllProductsSort(entityVariable);
	}
	
	

}
