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
package com.morevaadin.vaadin7.custom.client.ui;

import com.github.gwtbootstrap.client.ui.constants.ButtonType;
import com.github.gwtbootstrap.client.ui.resources.ButtonSize;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Widget;
import com.vaadin.terminal.gwt.client.MouseEventDetails;
import com.vaadin.terminal.gwt.client.MouseEventDetailsBuilder;
import com.vaadin.terminal.gwt.client.communication.RpcProxy;
import com.vaadin.terminal.gwt.client.communication.StateChangeEvent;
import com.vaadin.terminal.gwt.client.ui.AbstractComponentConnector;
import com.vaadin.terminal.gwt.client.ui.Connect;

@SuppressWarnings("serial")
@Connect(com.morevaadin.vaadin7.custom.BootstrapButton.class)
public class BootstrapButtonConnector extends AbstractComponentConnector implements ClickHandler {

	private BootstrapButtonRpc rpc = RpcProxy.create(BootstrapButtonRpc.class, this);

	public BootstrapButtonConnector() {
		
        getWidget().addClickHandler(this);
	}
	
	@Override
	protected Widget createWidget() {

		return GWT.create(VBootstrapButton.class);
	}

	@Override
	public BootstrapButtonState getState() {

		return (BootstrapButtonState) super.getState();
	}

	@Override
	public VBootstrapButton getWidget() {

		return (VBootstrapButton) super.getWidget();
	}

	@Override
	public void onStateChanged(StateChangeEvent stateChangeEvent) {

		super.onStateChanged(stateChangeEvent);

		BootstrapButtonState state = getState();

		VBootstrapButton button = getWidget();

		button.setText(state.getText());
		button.setSize(ButtonSize.valueOf(state.getSize()));
		button.setType(ButtonType.valueOf(state.getType()));
	}

	public void onClick(ClickEvent event) {

		MouseEventDetails details = MouseEventDetailsBuilder.buildMouseEventDetails(
				event.getNativeEvent(), getWidget().getElement());

		rpc.click(details);
	}
}
