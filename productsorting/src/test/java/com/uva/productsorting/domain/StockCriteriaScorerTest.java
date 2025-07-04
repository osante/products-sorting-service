package com.uva.productsorting.domain;

import static org.assertj.core.api.Assertions.assertThat;

import com.uva.productsorting.domain.model.Product;
import com.uva.productsorting.domain.model.SortingCriteria;
import org.junit.jupiter.api.Test;

public class StockCriteriaScorerTest {
    private final StockCriteriaScorer stockCriteriaScorer = new StockCriteriaScorer();

    @Test
    void testSaleUnitsScore() {
        Product product =
                Product.builder()
                        .id(1)
                        .salesUnits(100)
                        .stock(Product.Stock.builder().large(10).medium(15).small(5).build())
                        .build();
        SortingCriteria sortingCriteria =
                SortingCriteria.builder().field(SortingCriteria.Field.STOCK).weight(0.5F).build();

        double score = stockCriteriaScorer.scoreProductBySortingCriteria(product, sortingCriteria);

        assertThat(score).isEqualTo(15);
    }
}
