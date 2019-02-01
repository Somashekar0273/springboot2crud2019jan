package com.springboot.beginner.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
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

	@Cacheable("product")
	public Optional<Product> getProductById(Long myid) {
		// TODO Auto-generated method stub
		//simulate the caching by introducing the artificial delay!
		try {
			System.out.println("Sleep for 4 second to bring caching in action! ONLY FIRST TIME");
			Thread.sleep(4000);
		}catch(Exception e) {
			e.printStackTrace();
		}
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

	public List<Product> getProductByPriceGreaterThan(String order, Long price) {
		// TODO Auto-generated method stub
		return productDao.getProductByPriceGreaterThan(order, price);
	}
	
	

}
