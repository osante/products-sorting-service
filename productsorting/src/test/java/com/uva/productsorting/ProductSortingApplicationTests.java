package com.uva.productsorting;

import static org.assertj.core.api.Assertions.assertThat;

import com.uva.productsorting.application.SortProductsRequest;
import com.uva.productsorting.application.SortProductsResponse;
import com.uva.productsorting.domain.model.Product;
import com.uva.productsorting.domain.model.SortingCriteria;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ProductSortingApplicationTests {

  @LocalServerPort private int port;
  @Autowired private TestRestTemplate restTemplate;

  @Test
  void contextLoads() {}

  @Test
  void testProductsSorting() {
    String baseUrl = "http://localhost:" + port + "/";
    SortProductsRequest sortProductsRequest =
        SortProductsRequest.builder()
            .products(
                List.of(
                    Product.builder()
                        .id(1)
                        .name("V-NECH BASIC SHIRT")
                        .salesUnits(100)
                        .stock(Product.Stock.builder().small(4).medium(9).large(0).build())
                        .build(),
                    Product.builder()
                        .id(2)
                        .name("CONTRASTING FABRIC T-SHIRT")
                        .salesUnits(50)
                        .stock(Product.Stock.builder().small(35).medium(9).large(9).build())
                        .build(),
                    Product.builder()
                        .id(3)
                        .name("RAISED PRINT T-SHIRT")
                        .salesUnits(80)
                        .stock(Product.Stock.builder().small(20).medium(2).large(20).build())
                        .build(),
                    Product.builder()
                        .id(4)
                        .name("PLEATED T-SHIRT")
                        .salesUnits(3)
                        .stock(Product.Stock.builder().small(25).medium(30).large(10).build())
                        .build(),
                    Product.builder()
                        .id(5)
                        .name("CONTRASTING LACE T-SHIRT")
                        .salesUnits(650)
                        .stock(Product.Stock.builder().small(0).medium(1).large(0).build())
                        .build(),
                    Product.builder()
                        .id(6)
                        .name("SLOGAN T-SHIRT")
                        .salesUnits(20)
                        .stock(Product.Stock.builder().small(9).medium(2).large(5).build())
                        .build()))
            .sortingCriteriaList(
                List.of(
                    SortingCriteria.builder()
                        .type(SortingCriteria.Type.SALE_UNITS)
                        .weight(1f)
                        .build(),
                    SortingCriteria.builder().type(SortingCriteria.Type.STOCK).weight(1f).build()))
            .build();

    SortProductsResponse sortProductsResponse =
        restTemplate.postForObject(
            baseUrl + "/products/sorting", sortProductsRequest, SortProductsResponse.class);

    assertThat(sortProductsResponse)
        .isEqualTo(
            SortProductsResponse.builder()
                .products(
                    List.of(
                        Product.builder()
                            .id(5)
                            .name("CONTRASTING LACE T-SHIRT")
                            .salesUnits(650)
                            .stock(Product.Stock.builder().small(0).medium(1).large(0).build())
                            .build(),
                        Product.builder()
                            .id(3)
                            .name("RAISED PRINT T-SHIRT")
                            .salesUnits(80)
                            .stock(Product.Stock.builder().small(20).medium(2).large(20).build())
                            .build(),
                        Product.builder()
                            .id(1)
                            .name("V-NECH BASIC SHIRT")
                            .salesUnits(100)
                            .stock(Product.Stock.builder().small(4).medium(9).large(0).build())
                            .build(),
                        Product.builder()
                            .id(2)
                            .name("CONTRASTING FABRIC T-SHIRT")
                            .salesUnits(50)
                            .stock(Product.Stock.builder().small(35).medium(9).large(9).build())
                            .build(),
                        Product.builder()
                            .id(4)
                            .name("PLEATED T-SHIRT")
                            .salesUnits(3)
                            .stock(Product.Stock.builder().small(25).medium(30).large(10).build())
                            .build(),
                        Product.builder()
                            .id(6)
                            .name("SLOGAN T-SHIRT")
                            .salesUnits(20)
                            .stock(Product.Stock.builder().small(9).medium(2).large(5).build())
                            .build()))
                .build());
  }

  @Test
  void testEmptyProductList_emptySortingCriteria() {
    String baseUrl = "http://localhost:" + port + "/";
    SortProductsRequest sortProductsRequest = SortProductsRequest.builder().build();

    SortProductsResponse sortProductsResponse =
        restTemplate.postForObject(
            baseUrl + "/products/sorting", sortProductsRequest, SortProductsResponse.class);

    assertThat(sortProductsResponse).isEqualTo(SortProductsResponse.builder().build());
  }

  @Test
  void testEmptyProductList_onlySaleUnitsCriteria() {
    String baseUrl = "http://localhost:" + port + "/";
    SortProductsRequest sortProductsRequest =
        SortProductsRequest.builder()
            .products(
                List.of(
                    Product.builder()
                        .id(1)
                        .name("V-NECH BASIC SHIRT")
                        .salesUnits(100)
                        .stock(Product.Stock.builder().small(100).medium(100).large(100).build())
                        .build(),
                    Product.builder()
                        .id(2)
                        .name("CONTRASTING FABRIC T-SHIRT")
                        .salesUnits(150)
                        .stock(Product.Stock.builder().small(35).medium(9).large(9).build())
                        .build()))
            .sortingCriteriaList(
                List.of(
                    SortingCriteria.builder()
                        .type(SortingCriteria.Type.SALE_UNITS)
                        .weight(1f)
                        .build()))
            .build();

    SortProductsResponse sortProductsResponse =
        restTemplate.postForObject(
            baseUrl + "/products/sorting", sortProductsRequest, SortProductsResponse.class);

    assertThat(sortProductsResponse)
        .isEqualTo(
            SortProductsResponse.builder()
                .products(
                    List.of(
                        Product.builder()
                            .id(2)
                            .name("CONTRASTING FABRIC T-SHIRT")
                            .salesUnits(150)
                            .stock(Product.Stock.builder().small(35).medium(9).large(9).build())
                            .build(),
                        Product.builder()
                            .id(1)
                            .name("V-NECH BASIC SHIRT")
                            .salesUnits(100)
                            .stock(
                                Product.Stock.builder().small(100).medium(100).large(100).build())
                            .build()))
                .build());
  }

  @Test
  void testEmptyProductList_onlyStockCriteria() {
    String baseUrl = "http://localhost:" + port + "/";
    SortProductsRequest sortProductsRequest =
        SortProductsRequest.builder()
            .products(
                List.of(
                    Product.builder()
                        .id(1)
                        .name("V-NECH BASIC SHIRT")
                        .salesUnits(100)
                        .stock(Product.Stock.builder().small(100).medium(100).large(100).build())
                        .build(),
                    Product.builder()
                        .id(2)
                        .name("CONTRASTING FABRIC T-SHIRT")
                        .salesUnits(150)
                        .stock(Product.Stock.builder().small(35).medium(9).large(9).build())
                        .build()))
            .sortingCriteriaList(
                List.of(
                    SortingCriteria.builder().type(SortingCriteria.Type.STOCK).weight(1f).build()))
            .build();

    SortProductsResponse sortProductsResponse =
        restTemplate.postForObject(
            baseUrl + "/products/sorting", sortProductsRequest, SortProductsResponse.class);

    assertThat(sortProductsResponse)
        .isEqualTo(
            SortProductsResponse.builder()
                .products(
                    List.of(
                        Product.builder()
                            .id(1)
                            .name("V-NECH BASIC SHIRT")
                            .salesUnits(100)
                            .stock(
                                Product.Stock.builder().small(100).medium(100).large(100).build())
                            .build(),
                        Product.builder()
                            .id(2)
                            .name("CONTRASTING FABRIC T-SHIRT")
                            .salesUnits(150)
                            .stock(Product.Stock.builder().small(35).medium(9).large(9).build())
                            .build()))
                .build());
  }
}
