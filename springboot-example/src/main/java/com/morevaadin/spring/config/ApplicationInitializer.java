package com.morevaadin.spring.config;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.vaadin.spring.boot.VaadinAutoConfiguration;
import org.vaadin.spring.config.VaadinConfiguration;

public class ApplicationInitializer extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {

        return application.showBanner(false)
                .sources(MainConfig.class)
                .sources(VaadinAutoConfiguration.class, VaadinConfiguration.class)
                .sources(WebConfig.class);
    }
}
