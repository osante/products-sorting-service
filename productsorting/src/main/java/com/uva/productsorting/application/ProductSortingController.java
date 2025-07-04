package com.uva.productsorting.application;

import com.uva.productsorting.domain.ProductSortingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/** Rest controller for the products sorting. */
@RestController
public class ProductSortingController {

  private final ProductSortingService productSortingService;

  @Autowired
  public ProductSortingController(ProductSortingService productSortingService) {
    this.productSortingService = productSortingService;
  }

  /**
   * Sort products using the provided request.
   *
   * @param sortProductsRequest with the products and criteria to use for the sorting.
   * @return a response that contains the sorted list of products.
   */
  @PostMapping("/products/sorting")
  SortProductsResponse sortProducts(@RequestBody SortProductsRequest sortProductsRequest) {
    return SortProductsResponse.builder()
        .products(
            productSortingService.sortProducts(
                sortProductsRequest.getProducts(), sortProductsRequest.getSortingCriteriaList()))
        .build();
  }
}
