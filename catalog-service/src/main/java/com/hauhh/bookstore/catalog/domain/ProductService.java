package com.hauhh.bookstore.catalog.domain;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    public PagedResult<Product> getProducts(int pageNo) {
        Sort sort = Sort.by("name").ascending();

        pageNo = pageNo <= 1 ? 0 : pageNo - 1;

        Pageable pageable = PageRequest.of(pageNo, 10, sort);

        var productsPage = productRepository.findAll(pageable)
                .map(ProductMapper::toProduct);

        return PagedResult.<Product>builder()
                .data(productsPage.getContent())
                .totalElements(productsPage.getTotalElements())
                .pageNumber(productsPage.getNumber() + 1)
                .totalPages(productsPage.getTotalPages())
                .isFirst(productsPage.isFirst())
                .isLast(productsPage.isLast())
                .hasNext(productsPage.hasNext())
                .hasPrevious(productsPage.hasPrevious())
                .build();

    }
}
