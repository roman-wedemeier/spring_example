package de.rororo.spring_example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.web.client.RestTemplate;

@SpringBootTest
class ServiceTest {

    @MockBean
    private RestTemplate restTemplate;

    @Autowired
    private MyService service;

    @BeforeEach
    void init() {
        final ShopProductsResponse response = new ShopProductsResponse();
        response.setProducts(new Product[0]);

        Mockito.when(restTemplate.getForObject(Mockito.any(), Mockito.any())).thenReturn(response);
    }

    @Test
    void test() {
        final String expectation = "Found 0 products";

        String result = service.serve();

        Assertions.assertEquals(expectation, result);
    }

}
