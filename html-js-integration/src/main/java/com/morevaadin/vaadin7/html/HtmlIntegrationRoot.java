/*
 * Copyright 2012 Nicolas Frankel
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
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
