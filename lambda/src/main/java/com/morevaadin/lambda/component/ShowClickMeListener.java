package com.morevaadin.lambda.component;

import com.vaadin.ui.Button;
import com.vaadin.ui.ComponentContainer;
import com.vaadin.ui.Label;

public class ShowClickMeListener implements Button.ClickListener {

    private ComponentContainer container;

    public ShowClickMeListener(ComponentContainer container) {

        this.container = container;
    }

    @Override
    public void buttonClick(Button.ClickEvent event) {

        container.addComponent(new Label("Button clicked"));
    }
}
