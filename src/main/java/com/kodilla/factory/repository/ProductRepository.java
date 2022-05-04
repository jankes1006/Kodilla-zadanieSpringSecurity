package com.kodilla.factory.repository;

import com.kodilla.factory.domain.Product;

import java.util.List;

public interface ProductRepository {
    List<Product> findAll();

    void save(Product product);

    void delete(int index);
}
