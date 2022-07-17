package com.san.tech.rent.book.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class CustomerConfig {

    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
