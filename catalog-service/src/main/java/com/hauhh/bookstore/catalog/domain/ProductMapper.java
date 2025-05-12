package com.hauhh.bookstore.catalog.domain;

public class ProductMapper {

    static ProductEntity toProductEntity(Product product) {
        return null;
    }

    static Product toProduct(ProductEntity product) {
        return new Product(
                product.getCode(),
                product.getName(),
                product.getDescription(),
                product.getImageUrl(),
                product.getPrice());
    }
}
