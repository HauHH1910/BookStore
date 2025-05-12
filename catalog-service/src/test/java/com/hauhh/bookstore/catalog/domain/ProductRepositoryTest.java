package com.hauhh.bookstore.catalog.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;

@Sql("/test-data.sql")
@DataJpaTest(properties = {
    "spring.test.database.replace=none",
    "spring.datasource.url=jdbc:tc:postgresql:lastest:///db"
})
class ProductRepositoryTest {

  @Autowired
  private ProductRepository productRepository;

  @Test
  void shouldGetAllProducts() {
    List<ProductEntity> products = productRepository.findAll();
    assertThat(products).hasSize(15);
  }

}
