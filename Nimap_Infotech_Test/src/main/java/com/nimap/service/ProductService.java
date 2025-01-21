package com.nimap.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.nimap.model.Category;
import com.nimap.model.Product;
import com.nimap.repository.CategoryRepository;
import com.nimap.repository.ProductRepository;
import com.nimap.service.dto.ProductRequestDTO;

import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    public Page<Product> getAllProducts(Pageable pageable) {
        return productRepository.findAll(pageable);
    }

    public Optional<Product> getProductById(Long id) {
        return productRepository.findById(id);
    }

    public Product createProduct(ProductRequestDTO productRequestDTO) {
        Product product = new Product();
        product.setName(productRequestDTO.getName());
        product.setPrice(productRequestDTO.getPrice());
        Category category = categoryRepository.findById(productRequestDTO.getCategory().getId())
            .orElseThrow(() -> new IllegalArgumentException("Category not found with ID: " + productRequestDTO.getCategory().getId()));
        product.setCategory(category);
        return productRepository.save(product);
    }

    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }

    public void deleteProductById(Long id) {
        productRepository.deleteById(id);
    }
}
