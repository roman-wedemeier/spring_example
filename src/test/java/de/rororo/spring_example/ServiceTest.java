package de.rororo.spring_example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.web.client.RestTemplate;

class ServiceTest {

    private MyService service;

    @BeforeEach
    void init() {
        final ShopProductsResponse response = new ShopProductsResponse();
        response.setProducts(new Product[0]);

        RestTemplate restTemplate = Mockito.mock(RestTemplate.class);
        Mockito.when(restTemplate.getForObject(Mockito.anyString(), Mockito.any())).thenReturn(response);

        this.service = new ServiceImpl(restTemplate);
    }

    @Test
    void test() {
        final String expectation = "Found 0 products";

        String result = service.serve();

        Assertions.assertEquals(expectation, result);
    }

}
