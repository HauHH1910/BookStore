package com.hauhh.bookstore.catalog.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.math.BigDecimal;
import lombok.*;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "products")
public class ProductEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "product_id_generator")
    @SequenceGenerator(name = "product_id_generator", sequenceName = "product_id_seq")
    private Long id;

    @Column(nullable = false, unique = true)
    @NotBlank(message = "Product code is required") private String code;

    @Column(nullable = false)
    @NotBlank(message = "Product name is required") private String name;

    private String description;

    private String imageUrl;

    @DecimalMin("0.1") @Column(nullable = false)
    @NotNull(message = "Product price is required") private BigDecimal price;
}
