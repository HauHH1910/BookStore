package com.hauhh.bookstore.catalog.web.controllers;

import com.hauhh.bookstore.catalog.domain.PagedResult;
import com.hauhh.bookstore.catalog.domain.Product;
import com.hauhh.bookstore.catalog.domain.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequiredArgsConstructor
@RequestMapping("/api/products")
public class ProductController {

    private final ProductService productService;

    @GetMapping
    public PagedResult<Product> getProducts(
            @RequestParam(name = "page", defaultValue = "1") int pageNo
    ) {
        return productService.getProducts(pageNo);
    }
}
