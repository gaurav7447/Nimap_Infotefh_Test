package com.nimap.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;

import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.nimap.model.Category;
import com.nimap.model.Product;
import com.nimap.repository.CategoryRepository;

@Service
public class CategoryService {

	@Autowired
	private CategoryRepository categoryRepository;
	
	public  Page<Category> getAllCategories(Pageable pageable){
		return categoryRepository.findAll(pageable);
	}
	
	public Category createCategory(Category category) {
		if (category.getProducts() != null) {
            for (Product product : category.getProducts()) {
                product.setCategory(category);
            }
        }

        return categoryRepository.save(category);
	}
	
	public Optional<Category> getCategoryById(Long id){
		return categoryRepository.findById(id);
	}
	
	public Category updateCategory(Long id, Category category) {
        return categoryRepository.findById(id).map(existing -> {
            existing.setName(category.getName());
            return categoryRepository.save(existing);
        }).orElseThrow(() -> new RuntimeException("Category not found"));
    }
	
	public void deleteCategory(Long id) {
		categoryRepository.deleteById(id);
	}
}
