package com.morevaadin.vaadin7.html.config;

import com.morevaadin.vaadin7.html.config.client.TooltipState;
import com.vaadin.terminal.AbstractExtension;
import com.vaadin.terminal.ExternalResource;
import com.vaadin.terminal.Resource;
import com.vaadin.ui.Link;

@SuppressWarnings("serial")
public class ConfigurableTooltipExtension extends AbstractExtension {

    public void extend(Link link) {

	Resource resource = link.getResource();
	
	String display = resource instanceof ExternalResource ? ((ExternalResource) resource).getURL().toString() : "???";
	
	getState().setDisplay(display);

	super.extend(link);
    }

    @Override
    public TooltipState getState() {

	return (TooltipState) super.getState();
    }
}
