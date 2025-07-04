package com.uva.productsorting.configuration;

import com.uva.productsorting.domain.CriteriaScorer;
import com.uva.productsorting.domain.ProductSortingService;
import com.uva.productsorting.domain.SaleUnitsCriteriaScorer;
import com.uva.productsorting.domain.StockCriteriaScorer;
import com.uva.productsorting.domain.model.SortingCriteria;
import java.util.Map;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProductSortingConfiguration {
  @Bean
  ProductSortingService getProductSortingService() {
    return new ProductSortingService();
  }
}
