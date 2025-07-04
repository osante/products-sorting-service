package com.uva.productsorting.domain;

import com.uva.productsorting.domain.model.Product;
import com.uva.productsorting.domain.model.SortingCriteria;

public class SaleUnitsCriteriaScorer implements CriteriaScorer {

  @Override
  public double scoreProductBySortingCriteria(Product product, SortingCriteria sortingCriteria) {
    return product.getSalesUnits() * sortingCriteria.getWeight();
  }
}
