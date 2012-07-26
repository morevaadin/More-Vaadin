package com.morevaadin.vaadin7.html.config.client;

import com.google.gwt.event.dom.client.MouseOutEvent;
import com.google.gwt.event.dom.client.MouseOutHandler;
import com.google.gwt.event.dom.client.MouseOverEvent;
import com.google.gwt.event.dom.client.MouseOverHandler;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.Widget;
import com.morevaadin.vaadin7.html.config.ConfigurableTooltipExtension;
import com.vaadin.terminal.gwt.client.ComponentConnector;
import com.vaadin.terminal.gwt.client.ServerConnector;
import com.vaadin.terminal.gwt.client.extensions.AbstractExtensionConnector;
import com.vaadin.terminal.gwt.client.ui.Connect;
import com.vaadin.terminal.gwt.client.ui.VOverlay;

@SuppressWarnings("serial")
@Connect(ConfigurableTooltipExtension.class)
public class ConfigurableTooltipConnector extends AbstractExtensionConnector {

    @Override
    protected void extend(ServerConnector target) {

	final Widget hyperlink = ((ComponentConnector) target).getWidget();

	final VOverlay tooltip = new VOverlay();

	String display = getState().getDisplay();
	
	tooltip.add(new HTML("<div class='c-tooltip'>" + display + "</div>"));

	hyperlink.addDomHandler(new MouseOverHandler() {

	    @Override
	    public void onMouseOver(MouseOverEvent event) {

		tooltip.showRelativeTo(hyperlink);
	    }

	}, MouseOverEvent.getType());

	hyperlink.addDomHandler(new MouseOutHandler() {

	    @Override
	    public void onMouseOut(MouseOutEvent event) {

		tooltip.hide();
	    }

	}, MouseOutEvent.getType());
    }

    @Override
    public TooltipState getState() {

	return (TooltipState) super.getState();
    }
}
