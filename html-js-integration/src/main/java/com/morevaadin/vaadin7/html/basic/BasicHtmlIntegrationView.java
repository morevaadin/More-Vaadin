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
package com.morevaadin.vaadin7.html.basic;

import com.vaadin.terminal.ExternalResource;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.Link;
import com.vaadin.ui.Panel;

@SuppressWarnings("serial")
public class BasicHtmlIntegrationView extends Panel {

    public BasicHtmlIntegrationView() {

	FormLayout layout = new FormLayout();

	addComponent(layout);

	Link blog = new Link("A Java Geek", new ExternalResource("http://blog.frankel.ch/"));
	Link morevaadin = new Link("More Vaadin", new ExternalResource("http://morevaadin.com/"));
	
	new BasicTooltipExtension().extend(blog);
	new BasicTooltipExtension().extend(morevaadin);

	layout.addComponent(blog);
	layout.addComponent(morevaadin);
    }
}
