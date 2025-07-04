package com.uva.productsorting.application;

import com.uva.productsorting.domain.model.Product;
import com.uva.productsorting.domain.model.SortingCriteria;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;

import java.util.List;

@Value
@AllArgsConstructor
@Builder
@Jacksonized
public class SortProductsRequest {
    @Builder.Default
    List<Product> products = List.of();
    @Builder.Default
    List<SortingCriteria> sortingCriteriaList = List.of();
}
