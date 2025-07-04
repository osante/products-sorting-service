package com.uva.productsorting.domain.model;

import lombok.Builder;
import lombok.NonNull;
import lombok.Value;

/** Represents a product in the system. */
@Value
@Builder
public class Product {

  /** Id of the product. */
  int id;

  /** Name of the product. */
  @NonNull @Builder.Default String name = "";

  /** Total units sold of this product. */
  int salesUnits;

  /** Stock of the product. */
  @NonNull @Builder.Default Stock stock = Stock.builder().build();

  /** Represents the stock of a product. */
  @Value
  @Builder
  public static class Stock {
    /** Total number of stock for the small size */
    int small;

    /** Total number of stock for the medium size */
    int medium;

    /** Total number of stock for the large size */
    int large;
  }
}
