package com.springboot.beginner.restcontroller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.beginner.entity.Product;
import com.springboot.beginner.service.ProductService;

@RestController
public class HelloRestController {
	
	@Autowired
	private ProductService productService;
	
	@Autowired
	private CacheManager cacheManager;
	
	
	@RequestMapping("/welcome")
	public String welcome() {
		return "Hello from STS!!!! again...once";
	}

	@RequestMapping(value = "/add", method=RequestMethod.POST)
	public List<Product> addProduct(@RequestBody Product p) {
		
		System.out.println("Received : "  + p.toString());
		System.out.println("Name: " + p.getName());
		System.out.println("Description: " + p.getDescription());
		System.out.println("Category: " + p.getCategoryId());
		List<Product> p1 = productService.addProduct(p);
		System.out.println(p1.getClass().getTypeName());
		return p1;
	}
	
	@RequestMapping("/get")
	public List<Product> getAllProducts(){
		return productService.getAllProducts();
	}
	
	
	/**
	 * http://localhost:1234/get/1
	 * http://localhost:1234/get/2
	 * http://localhost:1234/update/1
	 * http://localhost:1234/update/2
	 * http://localhost:1234/delete/1
	 * http://localhost:1234/delete/2
	 * http://localhost:1234/get/category/5
	 * http://localhost:1234/get/category/5
	 * http://localhost:1234/get/name/phone
	 *  http://localhost:1234/get/sort/name           //http://localhost:1234/get/sort/{entityVariable}/{order}
	 *  http://localhost:1234/get/sort/categoryId
	 *  
	 */
	
	@RequestMapping(value="/get/{id}", method=RequestMethod.GET)
	public Optional<Product> getProductById(@PathVariable("id") Long myid ) {
		return productService.getProductById(myid);		
	}
	
	@RequestMapping(value="/update/{id}", method=RequestMethod.POST)
	public Optional<Product> updateProductById(@PathVariable("id") Long myid, @RequestBody Product p ){
		return productService.updateProductById(myid, p);
	}
	
	@RequestMapping(value="/delete/{id}", method=RequestMethod.DELETE)
	public List<Product> deleteProductById(@PathVariable Long id ){
		return productService.deleteProductById(id);
	}
	
	@RequestMapping(value="/get/category/{id}")                                   //         /get/** //user role
	public  List<Product> getProductByCategoryId(@PathVariable int id){
		return productService.getProductByCategoryId(id);
	}
	
	//http://localhost:1234/get/name/phone
	@RequestMapping(value="/get/name/{pname}")
	public List<Product> getProductByName(@PathVariable String pname){
		return productService.getProductByName(pname);
	}
	 //http://localhost:1234/get/sort/{entityVariable}
	@RequestMapping("/get/sort/{entityVariable}")
	public List<Product> getAllProducts(@PathVariable String entityVariable){
		return productService.getAllProductsSort(entityVariable);
	}
	
	@RequestMapping("/get/{order}/{price}")
	public List<Product> getProductByPriceGreaterThan(@PathVariable String order, @PathVariable Long price){
		return productService.getProductByPriceGreaterThan(order, price);
	}
	
	@GetMapping("/clearallcache")
	public void clearAllCache() {
		System.out.println(cacheManager.getCacheNames());
		cacheManager.getCache("product").clear();
	}
	
	 //http://localhost:1234/get/sort/{entityVariable}/{order}
}
