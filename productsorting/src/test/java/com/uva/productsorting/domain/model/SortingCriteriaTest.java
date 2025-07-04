package com.uva.productsorting.domain.model;

import static org.assertj.core.api.Assertions.assertThat;

import com.uva.productsorting.domain.CriteriaScorer;
import com.uva.productsorting.domain.SaleUnitsCriteriaScorer;
import com.uva.productsorting.domain.StockCriteriaScorer;
import org.junit.jupiter.api.Test;

public class SortingCriteriaTest {

  @Test
  void testSaleUnitsField_isLinkedToSaleUnitsCriteriaScorer() {
    CriteriaScorer criteriaScorer = SortingCriteria.Field.SALE_UNITS.getCriteriaScorer();

    assertThat(criteriaScorer).isInstanceOf(SaleUnitsCriteriaScorer.class);
  }

  @Test
  void testStockField_isLinkedToStockCriteriaScorer() {
    CriteriaScorer criteriaScorer = SortingCriteria.Field.STOCK.getCriteriaScorer();

    assertThat(criteriaScorer).isInstanceOf(StockCriteriaScorer.class);
  }
}
