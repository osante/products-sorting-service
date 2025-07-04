package com.uva.productsorting.domain;

import static org.assertj.core.api.Assertions.assertThat;

import com.uva.productsorting.domain.model.Product;
import com.uva.productsorting.domain.model.SortingCriteria;
import java.util.List;
import org.junit.jupiter.api.Test;

public class ProductSortingServiceTest {
  private final ProductSortingService productSortingService = new ProductSortingService();

  @Test
  void testSortProducts() {
    List<Product> products =
        List.of(
            Product.builder()
                .id(1)
                .salesUnits(100)
                .stock(Product.Stock.builder().small(10).medium(15).large(0).build())
                .build(),
            Product.builder()
                .id(2)
                .salesUnits(50)
                .stock(Product.Stock.builder().small(10).medium(15).large(0).build())
                .build(),
            Product.builder()
                .id(3)
                .salesUnits(100)
                .stock(Product.Stock.builder().small(20).medium(15).large(0).build())
                .build());
    List<SortingCriteria> sortingCriteriaList =
        List.of(
            SortingCriteria.builder().type(SortingCriteria.Type.SALE_UNITS).weight(1.5F).build(),
            SortingCriteria.builder().type(SortingCriteria.Type.STOCK).weight(0.5F).build());

    List<Product> sortedProducts =
        productSortingService.sortProducts(products, sortingCriteriaList);

    assertThat(sortedProducts)
        .isEqualTo(
            List.of(
                Product.builder()
                    .id(3)
                    .salesUnits(100)
                    .stock(Product.Stock.builder().small(20).medium(15).large(0).build())
                    .build(),
                Product.builder()
                    .id(1)
                    .salesUnits(100)
                    .stock(Product.Stock.builder().small(10).medium(15).large(0).build())
                    .build(),
                Product.builder()
                    .id(2)
                    .salesUnits(50)
                    .stock(Product.Stock.builder().small(10).medium(15).large(0).build())
                    .build()));
  }

  @Test
  void testSortProducts_emptyProductsList() {
    List<Product> products = List.of();
    List<SortingCriteria> sortingCriteriaList = List.of();

    List<Product> sortedProducts =
        productSortingService.sortProducts(products, sortingCriteriaList);

    assertThat(sortedProducts).isEmpty();
  }
}
