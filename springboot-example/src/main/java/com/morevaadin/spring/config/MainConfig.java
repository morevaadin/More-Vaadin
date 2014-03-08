package com.morevaadin.spring.config;

import com.morevaadin.spring.service.HelloService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MainConfig {

    @Bean
    public HelloService helloService() {

        return new HelloService();
    }
}
