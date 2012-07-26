package com.morevaadin.vaadin7.html;

import com.morevaadin.vaadin7.html.basic.BasicHtmlIntegrationView;
import com.morevaadin.vaadin7.html.config.ConfigurableHtmlIntegrationView;
import com.morevaadin.vaadin7.html.js.JavascriptIntegrationView;
import com.vaadin.terminal.WrappedRequest;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Root;
import com.vaadin.ui.TabSheet;

@SuppressWarnings("serial")
public class HtmlIntegrationRoot extends Root {

    @Override
    protected void init(WrappedRequest request) {

	getPage().setTitle("HTML JavaScript integration examples");

	HorizontalLayout layout = new HorizontalLayout();

	layout.setSizeFull();

	setContent(layout);

	TabSheet tabsheet = new TabSheet();

	layout.addComponent(tabsheet);

	tabsheet.addTab(new BasicHtmlIntegrationView()).setCaption("Basic HTML");
	tabsheet.addTab(new ConfigurableHtmlIntegrationView()).setCaption("Configurable HTML");
	tabsheet.addTab(new JavascriptIntegrationView()).setCaption("Javascript");
    }
}
