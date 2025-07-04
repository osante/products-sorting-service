package com.uva.productsorting.application;

import com.uva.productsorting.domain.model.Product;
import com.uva.productsorting.domain.model.SortingCriteria;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;

/** Request to sort products. */
@Value
@AllArgsConstructor
@Builder
@Jacksonized
public class SortProductsRequest {
  /** Products to be sorted. */
  @Builder.Default List<Product> products = List.of();

  /** List of sorting criteria to use for the sorting. */
  @Builder.Default List<SortingCriteria> sortingCriteriaList = List.of();
}
