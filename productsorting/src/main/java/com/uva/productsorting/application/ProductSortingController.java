package com.uva.productsorting.application;

import com.uva.productsorting.domain.ProductSortingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductSortingController {

  private final ProductSortingService productSortingService;

  @Autowired
  public ProductSortingController(ProductSortingService productSortingService) {
    this.productSortingService = productSortingService;
  }

  @PostMapping("/products/sorting")
  SortProductsResponse sortProducts(@RequestBody SortProductsRequest sortProductsRequest) {
    return SortProductsResponse.builder()
        .products(
            productSortingService.sortProducts(
                sortProductsRequest.getProducts(), sortProductsRequest.getSortingCriteriaList()))
        .build();
  }
}
