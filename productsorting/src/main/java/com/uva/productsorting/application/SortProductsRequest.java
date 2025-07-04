package com.uva.productsorting.application;

import com.uva.productsorting.domain.model.Product;
import com.uva.productsorting.domain.model.SortingCriteria;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;

@Value
@AllArgsConstructor
@Builder
@Jacksonized
public class SortProductsRequest {
  @Builder.Default List<Product> products = List.of();
  @Builder.Default List<SortingCriteria> sortingCriteriaList = List.of();
}
