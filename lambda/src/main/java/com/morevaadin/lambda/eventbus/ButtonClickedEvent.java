package com.morevaadin.lambda.eventbus;

import com.vaadin.ui.ComponentContainer;

public class ButtonClickedEvent {

    private ComponentContainer container;

    public ButtonClickedEvent(ComponentContainer container) {

        this.container = container;
    }

    public ComponentContainer getContainer() {

        return container;
    }
}
