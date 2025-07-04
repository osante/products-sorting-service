package com.uva.productsorting.domain;

import com.uva.productsorting.domain.model.Product;
import com.uva.productsorting.domain.model.SortingCriteria;

/**
 * Interface to evaluate the product score for sorting purposes. To add a new sorting criteria a new
 * implementation of this interface should be added.
 */
@FunctionalInterface
public interface CriteriaScorer {

  /**
   * This method calculates the score for a product based on the provided sorting criteria.
   *
   * @param product to score.
   * @param sortingCriteria to use for the score calculation.
   * @return the calculated score for the product using the specified sorting criteria.
   */
  double scoreProductBySortingCriteria(Product product, SortingCriteria sortingCriteria);
}
