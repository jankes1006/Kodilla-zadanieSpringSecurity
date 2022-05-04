package com.kodilla.factory.service;

import com.kodilla.factory.domain.Product;
import com.kodilla.factory.repository.ProductRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;

    @Override
    public void createProduct(Product product) {
        productRepository.save(product);
    }

    @Override
    public void deleteProduct(int index) {
        productRepository.delete(index);
    }

    @Override
    public List<Product> getProducts() {
        return productRepository.findAll();
    }
}
