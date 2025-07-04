package com.uva.productsorting.domain.model;

import lombok.Builder;
import lombok.NonNull;
import lombok.Value;

@Value
@Builder
public class Product {

  int id;
  @NonNull @Builder.Default String name = "";
  int salesUnits;
  @NonNull @Builder.Default Stock stock = Stock.builder().build();

  @Value
  @Builder
  public static class Stock {
    int small;
    int medium;
    int large;
  }
}
