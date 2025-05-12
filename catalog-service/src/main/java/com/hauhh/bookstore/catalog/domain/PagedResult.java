package com.hauhh.bookstore.catalog.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.util.List;

@Builder
public record PagedResult<T>(
                List<T> data,
                long totalElements,
                int pageNumber,
                int totalPages,
                boolean isFirst,
                boolean isLast,
                boolean hasNext,
                boolean hasPrevious) {

}
