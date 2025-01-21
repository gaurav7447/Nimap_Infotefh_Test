package com.nimap.service.dto;

import java.io.Serializable;

import com.nimap.model.Category;

public class ProductRequestDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Category category;
    private Double price;
    private String name;

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
