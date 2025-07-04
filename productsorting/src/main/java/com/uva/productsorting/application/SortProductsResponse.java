package com.uva.productsorting.application;

import com.uva.productsorting.domain.model.Product;
import java.util.List;
import lombok.Builder;
import lombok.NonNull;
import lombok.Value;

/** Response for product sort. */
@Value
@Builder
public class SortProductsResponse {
  /** Sorted products. */
  @NonNull @Builder.Default List<Product> products = List.of();
}
