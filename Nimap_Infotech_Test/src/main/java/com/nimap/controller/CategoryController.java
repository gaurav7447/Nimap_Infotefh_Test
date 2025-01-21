package com.nimap.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.nimap.model.Category;
import com.nimap.service.CategoryService;
import com.nimap.service.ProductService;
@RequestMapping("/api/categories")
@RestController
public class CategoryController {
	@Autowired
	private CategoryService categoryService;
	
	@GetMapping
	public Page<Category> getAllCategories(
			@RequestParam(defaultValue = "0") int page,
			@RequestParam(defaultValue = "30") int size) {
		Pageable pageable = PageRequest.of(page, size);
		return categoryService.getAllCategories(pageable);
	}
	
	@PostMapping
	public Category createCategory(@RequestBody Category category) {
		return categoryService.createCategory(category);
	}
	
	@GetMapping("/{id}")
	public Category getCategoryById(@PathVariable Long id) {
		return categoryService.getCategoryById(id).orElseThrow(() -> new RuntimeException("Category not found"));
	}
	
	@PutMapping("/{id}")
	public Category updateCategory(@PathVariable Long id,@RequestBody Category category) {
		return categoryService.updateCategory(id, category);
	}
	
	@DeleteMapping("/{id}")
	public void deleteCategory(@PathVariable Long id) {
		categoryService.deleteCategory(id);
	}
}
