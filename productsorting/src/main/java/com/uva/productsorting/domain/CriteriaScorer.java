package com.uva.productsorting.domain;

import com.uva.productsorting.domain.model.Product;
import com.uva.productsorting.domain.model.SortingCriteria;

@FunctionalInterface
public interface CriteriaScorer {
  double scoreProductBySortingCriteria(Product product, SortingCriteria sortingCriteria);
}
