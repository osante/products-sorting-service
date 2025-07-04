package com.uva.productsorting.domain.model;

import com.uva.productsorting.domain.CriteriaScorer;
import com.uva.productsorting.domain.SaleUnitsCriteriaScorer;
import com.uva.productsorting.domain.StockCriteriaScorer;
import lombok.Builder;
import lombok.Getter;
import lombok.Value;

@Value
@Builder
public class SortingCriteria {
  @Builder.Default Field field = Field.UNKNOWN;
  float weight = 1F;

  @Getter
  public enum Field {
    SALES_UNIT(new SaleUnitsCriteriaScorer()),
    STOCK(new StockCriteriaScorer()),
    UNKNOWN((product, sortingCriteria) -> 0);

    private final CriteriaScorer criteriaScorer;

    Field(CriteriaScorer criteriaScorer) {
        this.criteriaScorer = criteriaScorer;
    }
  }
}
