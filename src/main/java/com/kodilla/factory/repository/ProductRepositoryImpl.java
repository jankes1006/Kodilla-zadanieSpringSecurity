package com.kodilla.factory.repository;

import com.kodilla.factory.domain.Product;

import java.util.ArrayList;
import java.util.List;

class ProductRepositoryImpl implements ProductRepository {

    private List<Product> productList = new ArrayList<>();

    @Override
    public List<Product> findAll() {
        return productList;
    }

    @Override
    public void save(Product product) {
        productList.add(product);
    }

    @Override
    public void delete(int index) {
        productList.remove(index);
    }
}
