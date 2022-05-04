package com.kodilla.factory.controller;

import com.kodilla.factory.domain.ProductDto;
import com.kodilla.factory.mapper.ProductMapper;
import com.kodilla.factory.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping
    public List<ProductDto> getProducts() {
        return ProductMapper.mapToProductDtoList(productService.getProducts());
    }

    @PostMapping
    public void saveProduct(@RequestBody ProductDto productDto) {
        productService.createProduct(ProductMapper.mapToProduct(productDto));
    }

    @DeleteMapping("/{index}")
    public void deleteProduct(@PathVariable int index) {
        productService.deleteProduct(index);
    }
}
