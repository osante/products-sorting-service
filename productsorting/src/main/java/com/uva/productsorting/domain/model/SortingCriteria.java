package com.uva.productsorting.domain.model;

import com.uva.productsorting.domain.CriteriaScorer;
import com.uva.productsorting.domain.SaleUnitsCriteriaScorer;
import com.uva.productsorting.domain.StockCriteriaScorer;
import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;
import lombok.Value;

@Value
@Builder
public class SortingCriteria {
  @NonNull @Builder.Default Field field = Field.UNKNOWN;
  @Builder.Default float weight = 1F;

  @Getter
  public enum Field {
    SALE_UNITS(new SaleUnitsCriteriaScorer()),
    STOCK(new StockCriteriaScorer()),
    UNKNOWN((product, sortingCriteria) -> 0);

    private final CriteriaScorer criteriaScorer;

    Field(CriteriaScorer criteriaScorer) {
      this.criteriaScorer = criteriaScorer;
    }
  }
}
