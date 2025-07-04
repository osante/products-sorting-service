package com.uva.productsorting.domain;

import com.uva.productsorting.domain.model.Product;
import com.uva.productsorting.domain.model.SortingCriteria;
import java.util.List;

public class ProductSortingService {

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
                    .getField()
                    .getCriteriaScorer()
                    .scoreProductBySortingCriteria(product, sortingCriteria))
        .sum();
  }
}
