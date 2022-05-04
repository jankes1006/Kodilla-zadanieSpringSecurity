package com.kodilla.factory.service;

import com.kodilla.factory.domain.Product;

import java.util.List;

public interface ProductService {
    void createProduct(Product product);

    void deleteProduct(int index);

    List<Product> getProducts();
}
