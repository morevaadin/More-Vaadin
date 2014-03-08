package com.morevaadin.spring.config;

import com.morevaadin.spring.ui.VaadinSpringExampleUi;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.request.RequestContextListener;
import org.vaadin.spring.UIScope;

@Configuration
public class WebConfig extends MainConfig {

    @Bean
    @ConditionalOnMissingBean(RequestContextListener.class)
    public RequestContextListener requestContextListener() {

        return new RequestContextListener();
    }

    @Bean
    @UIScope
    public VaadinSpringExampleUi exampleUi() {

        return new VaadinSpringExampleUi(helloService());
    }
}
