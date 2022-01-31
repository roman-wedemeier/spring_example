package de.rororo.spring_example;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class DependencyConfig {

    @Bean
    public MyService service(RestTemplate restTemplate) {
        return new ServiceImpl(restTemplate);
    }

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
