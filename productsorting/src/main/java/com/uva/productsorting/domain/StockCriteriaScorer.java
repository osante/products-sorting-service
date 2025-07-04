package com.uva.productsorting.domain;

import com.uva.productsorting.domain.model.Product;
import com.uva.productsorting.domain.model.SortingCriteria;

/** Implementation of CriteriaScorer for the stock sorting criteria. */
public class StockCriteriaScorer implements CriteriaScorer {
  @Override
  public double scoreProductBySortingCriteria(Product product, SortingCriteria sortingCriteria) {
    return (product.getStock().getSmall()
            + product.getStock().getMedium()
            + product.getStock().getLarge())
        * sortingCriteria.getWeight();
  }
}
