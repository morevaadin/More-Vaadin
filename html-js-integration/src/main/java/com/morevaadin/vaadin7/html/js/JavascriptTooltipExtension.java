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
