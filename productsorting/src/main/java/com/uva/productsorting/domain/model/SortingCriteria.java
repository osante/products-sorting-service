package com.uva.productsorting.domain.model;

import com.uva.productsorting.domain.CriteriaScorer;
import com.uva.productsorting.domain.SaleUnitsCriteriaScorer;
import com.uva.productsorting.domain.StockCriteriaScorer;
import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;
import lombok.Value;

/** Represents a sorting criteria. */
@Value
@Builder
public class SortingCriteria {
  /**
   * The type of this sorting criteria, the type is linked to the sorting criteria implementation.
   */
  @NonNull @Builder.Default SortingCriteria.Type type = Type.UNKNOWN;

  /** The weigh to use for the sorting criteria. */
  @Builder.Default float weight = 1F;

  /**
   * Types of sorting criteria, to add a new sorting criteria you must add the new type in the
   * enumeration with the criteria scorer implementation.
   */
  @Getter
  public enum Type {
    SALE_UNITS(new SaleUnitsCriteriaScorer()),
    STOCK(new StockCriteriaScorer()),
    UNKNOWN((product, sortingCriteria) -> 0);

    private final CriteriaScorer criteriaScorer;

    Type(CriteriaScorer criteriaScorer) {
      this.criteriaScorer = criteriaScorer;
    }
  }
}
