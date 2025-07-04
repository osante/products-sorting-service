package com.uva.productsorting.application;

import com.uva.productsorting.domain.ProductSortingService;
import com.uva.productsorting.domain.model.Product;
import java.util.List;
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
  List<Product> sortProducts(@RequestBody SortProductsRequest sortProductsRequest) {
    return productSortingService.sortProducts(
        sortProductsRequest.getProducts(), sortProductsRequest.getSortingCriteriaList());
  }
}
