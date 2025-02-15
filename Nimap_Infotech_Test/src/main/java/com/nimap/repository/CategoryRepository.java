package com.nimap.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nimap.model.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {

}
