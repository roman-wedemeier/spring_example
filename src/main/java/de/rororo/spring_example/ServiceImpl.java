package de.rororo.spring_example;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ServiceImpl implements MyService {

    private final RestTemplate restTemplate;

    public ServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public String serve() {
        ShopProductsResponse result = restTemplate.getForObject(
                "https://api.predic8.de/shop/products/",
                ShopProductsResponse.class
        );

        if (result == null) {
            return "Error occurred";
        }

        return String.format("Found %s products", result.getProducts().length);
    }
}
