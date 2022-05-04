package com.kodilla.factory.mapper;

import com.kodilla.factory.domain.Product;
import com.kodilla.factory.domain.ProductDto;

import java.util.List;

import static java.util.stream.Collectors.toList;

public class ProductMapper {

    public static Product mapToProduct(ProductDto productDto) {
        return Product.of(productDto.getName(), productDto.getDescription(), productDto.getCost());
    }

    public static ProductDto mapToProductDto(Product product) {
        return new ProductDto(product.getName(), product.getDescription(), product.getCost());
    }

    public static List<Product> mapToProductList(List<ProductDto> productDtoList) {
        return productDtoList
                .stream()
                .map(ProductMapper::mapToProduct)
                .collect(toList());
    }

    public static List<ProductDto> mapToProductDtoList(List<Product> productList) {
        return productList
                .stream()
                .map(ProductMapper::mapToProductDto)
                .collect(toList());
    }

}
