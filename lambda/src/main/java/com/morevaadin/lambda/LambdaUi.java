package com.morevaadin.lambda;

import com.morevaadin.lambda.component.DedicatedComponentTab;
import com.morevaadin.lambda.eventbus.EventBusTab;
import com.morevaadin.lambda.java8.Java8LambdaTab;
import com.morevaadin.lambda.prejava8.PreJava8Tab;
import com.vaadin.annotations.Title;
import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.TabSheet;
import com.vaadin.ui.UI;

@Title("Lambda example")
public class LambdaUi extends UI {

    @Override
    protected void init(VaadinRequest vaadinRequest) {

        TabSheet tabs = new TabSheet();

        tabs.setSizeFull();

        tabs.addTab(new PreJava8Tab(), "Pre-Java 8");
        tabs.addTab(new Java8LambdaTab(), "Lambda Java 8");
        tabs.addTab(new DedicatedComponentTab(), "Dedicated Component");
        tabs.addTab(new EventBusTab(), "Event Bus w/ Java 8");

        setContent(tabs);
    }
}
