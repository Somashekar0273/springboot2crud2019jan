package com.springboot.beginner.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springboot.beginner.entity.Product;
import com.springboot.beginner.service.ProductService;

@Controller
public class ThymeleafController {
	
	@Autowired
	private ProductService productService;
	
	@RequestMapping("/")
	public String welcomePage() {
		return "index";
	}
	
	@RequestMapping("/addpage")
	public String addProductPage(Model model) {
		model.addAttribute("product", new Product());
		return "addproduct";
	}
	
	@PostMapping("/addproduct")
	public String addProduct(@Valid @ModelAttribute Product product, Model model, BindingResult result) {
		
		if(result.hasErrors()) {
			return "redirect:/addpage";
		}
		
		System.out.println(product.getName() + " " + product.getDescription() + " " + product.getPrice() + " " + product.getCategoryId());
		List<Product> productList = productService.addProduct(product);
		model.addAttribute("productList", productList);
		return "listproduct";
	}
	
	@RequestMapping("/listpage")
	public String listProductPage(Model model) {
		List<Product> productList = productService.getAllProducts();
		model.addAttribute("productList", productList);
		return "listproduct";
	}

}
