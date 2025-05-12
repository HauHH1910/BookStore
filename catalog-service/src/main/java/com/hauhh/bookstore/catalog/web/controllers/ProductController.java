package com.hauhh.bookstore.catalog.web.controllers;

import com.hauhh.bookstore.catalog.domain.PagedResult;
import com.hauhh.bookstore.catalog.domain.Product;
import com.hauhh.bookstore.catalog.domain.ProductNotFoundException;
import com.hauhh.bookstore.catalog.domain.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/products")
public class ProductController {

    private final ProductService productService;

    @GetMapping
    public PagedResult<Product> getProducts(
            @RequestParam(name = "page", defaultValue = "1") int pageNo) {
        return productService.getProducts(pageNo);
    }

    @GetMapping("/{code}")
    public ResponseEntity<Product> getProductByCode(@PathVariable("code") String code) {
        return productService.getProductByCode(code)
                .map(ResponseEntity::ok)
                .orElseThrow(() -> ProductNotFoundException.forCode(code));
    }

}
