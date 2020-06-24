package com.demomicro.cartservice.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

public class ProductList {
    List<Product> products;

    public ProductList(List<Product> products) {
        this.products = products;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
