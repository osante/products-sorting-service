package com.uva.productsorting.domain;

import com.uva.productsorting.domain.model.Product;
import com.uva.productsorting.domain.model.SortingCriteria;
import java.util.List;

/** Service to sort products based on a list of sorting criteria. */
public class ProductSortingService {

  /**
   * Sorts the list of products provided based on the list of sorting criteria provided. The
   * original list is not modified, the method returns a new list sorted.
   *
   * @param products the list of products to sort.
   * @param sortingCriteriaList the list of sorting criteria to use.
   * @return a immutable list of products ordered based on the sorting criteria provided.
   */
  public List<Product> sortProducts(
      List<Product> products, List<SortingCriteria> sortingCriteriaList) {
    return products.stream()
        .sorted(
            (product1, product2) ->
                Double.compare(
                    calculateSortValue(product2, sortingCriteriaList),
                    calculateSortValue(product1, sortingCriteriaList)))
        .toList();
  }

  private double calculateSortValue(Product product, List<SortingCriteria> sortingCriteriaList) {
    return sortingCriteriaList.stream()
        .mapToDouble(
            sortingCriteria ->
                sortingCriteria
                    .getType()
                    .getCriteriaScorer()
                    .scoreProductBySortingCriteria(product, sortingCriteria))
        .sum();
  }
}
