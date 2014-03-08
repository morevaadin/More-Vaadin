package com.morevaadin.spring.ui;

import com.morevaadin.spring.service.HelloService;
import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.Label;
import com.vaadin.ui.UI;
import org.vaadin.spring.VaadinUI;

@VaadinUI
public class VaadinSpringExampleUi extends UI {

    private HelloService helloService;

    public VaadinSpringExampleUi(HelloService helloService) {

        this.helloService = helloService;
    }

    @Override
    protected void init(VaadinRequest vaadinRequest) {

        String hello = helloService.sayHello();

        setContent(new Label(hello));
    }
}
