package com.uva.productsorting.configuration;

import com.uva.productsorting.domain.ProductSortingService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/** Spring bean configuration. */
@Configuration
public class ProductSortingConfiguration {
  @Bean
  ProductSortingService getProductSortingService() {
    return new ProductSortingService();
  }
}
