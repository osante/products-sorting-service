package com.uva.productsorting.domain;

import static org.assertj.core.api.Assertions.assertThat;

import com.uva.productsorting.domain.model.Product;
import com.uva.productsorting.domain.model.SortingCriteria;
import org.junit.jupiter.api.Test;

public class SaleUnitsCriteriaScorerTest {
  private final SaleUnitsCriteriaScorer saleUnitsCriteriaScorer = new SaleUnitsCriteriaScorer();

  @Test
  void testSaleUnitsScore() {
    Product product =
        Product.builder()
            .id(1)
            .salesUnits(100)
            .stock(Product.Stock.builder().large(10).medium(15).small(5).build())
            .build();
    SortingCriteria sortingCriteria =
        SortingCriteria.builder().type(SortingCriteria.Type.SALE_UNITS).weight(0.5F).build();

    double score = saleUnitsCriteriaScorer.scoreProductBySortingCriteria(product, sortingCriteria);

    assertThat(score).isEqualTo(50);
  }
}
