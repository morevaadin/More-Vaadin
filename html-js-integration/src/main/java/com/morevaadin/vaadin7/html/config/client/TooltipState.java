package com.morevaadin.vaadin7.html.config.client;

import com.vaadin.terminal.gwt.client.communication.SharedState;

@SuppressWarnings("serial")
public class TooltipState extends SharedState {

    private String display;

    public String getDisplay() {
    
        return display;
    }

    public void setDisplay(String display) {
    
        this.display = display;
    }
}
