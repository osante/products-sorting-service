package com.uva.productsorting.domain.model;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class Product {

    int id;
    @Builder.Default
    String name = "";
    int salesUnits;
    Stock stock;

    @Value
    @Builder
    public static class Stock {
        int small;
        int medium;
        int large;
    }
}
