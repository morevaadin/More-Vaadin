package com.morevaadin.vaadin7.html.js;

import com.morevaadin.vaadin7.html.js.client.BootstrapTooltipState;
import com.vaadin.annotations.JavaScript;
import com.vaadin.terminal.AbstractJavaScriptExtension;
import com.vaadin.terminal.ExternalResource;
import com.vaadin.terminal.Resource;
import com.vaadin.terminal.gwt.server.ClientConnector;
import com.vaadin.ui.Link;

@SuppressWarnings("serial")
@JavaScript({ "https://ajax.googleapis.com/ajax/libs/jquery/1.7.2/jquery.js", "bootstrap.js", "bootstrap_connector.js" })
public class JavascriptTooltipExtension extends AbstractJavaScriptExtension {

    public void extend(Link link) {

	Resource resource = link.getResource();

	String display = resource instanceof ExternalResource ? ((ExternalResource) resource).getURL().toString() : "???";

	getState().setDisplay(display);

	super.extend(link);
	
	attachTooltip();
    }

    protected void attachTooltip(Object... commandAndArguments) {

	invokeCallback("attach", commandAndArguments);
    }

    @Override
    protected Class<? extends ClientConnector> getSupportedParentType() {

	return Link.class;
    }

    @Override
    public BootstrapTooltipState getState() {

	return (BootstrapTooltipState) super.getState();
    }
}
