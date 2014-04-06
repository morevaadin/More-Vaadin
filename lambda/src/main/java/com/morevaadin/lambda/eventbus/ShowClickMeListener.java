package com.morevaadin.lambda.eventbus;

import com.google.gwt.thirdparty.guava.common.eventbus.Subscribe;
import com.vaadin.ui.Button;
import com.vaadin.ui.ComponentContainer;
import com.vaadin.ui.Label;

public class ShowClickMeListener {

    @Subscribe
    public void onClick(ButtonClickedEvent event) {

        event.getContainer().addComponent(new Label("Button clicked"));
    }
}
