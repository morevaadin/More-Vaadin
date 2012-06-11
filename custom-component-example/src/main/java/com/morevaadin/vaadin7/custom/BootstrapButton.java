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
package com.morevaadin.vaadin7.custom;

import com.morevaadin.vaadin7.custom.client.ui.BootstrapButtonRpc;
import com.morevaadin.vaadin7.custom.client.ui.BootstrapButtonState;
import com.vaadin.terminal.gwt.client.MouseEventDetails;
import com.vaadin.ui.AbstractComponent;

@SuppressWarnings("serial")
public class BootstrapButton extends AbstractComponent {

    private BootstrapButtonRpc rpc = new BootstrapButtonRpc() {
		
		@Override
		public void click(MouseEventDetails details) {

			fireEvent(new BootstrapClickEvent(BootstrapButton.this));
		}
	};
    
    public enum Size {

		LARGE, DEFAULT, SMALL, MINI;
	}

	public enum Type {

		DEFAULT, PRIMARY, INFO, SUCCESS, WARNING, DANGER, INVERSE;
	}

	public BootstrapButton() {

		this("", Type.DEFAULT, Size.DEFAULT);
	}

	public BootstrapButton(String caption, Size size) {

		this(caption, Type.DEFAULT, size);
	}

	public BootstrapButton(String caption, Type type) {

		this(caption, type, Size.DEFAULT);
	}

	public BootstrapButton(String caption, Type type, Size size) {

		setText(caption);
		setSize(size);
		setType(type);

		setImmediate(true);
		
		registerRpc(rpc);
	}

	public BootstrapButton(String caption) {

		this(caption, Size.DEFAULT);
	}

	public BootstrapButton(Size size) {

		this("", size);
	}

	public BootstrapButton(Type type) {

		this("", type);
	}

	public Size getSize() {

		return Size.valueOf(getState().getSize());
	}

	public Type getType() {

		return Type.valueOf(getState().getType());
	}

	@Override
	public BootstrapButtonState getState() {

		return (BootstrapButtonState) super.getState();
	}

	public String getText() {

		return getState().getText();
	}

	public void setSize(Size size) {

		getState().setSize(size.toString());
		
		requestRepaint();
	}

	public void setType(Type size) {

		getState().setType(size.toString());
		
		requestRepaint();
	}

	public void setText(String text) {

		getState().setText(text);
		
		requestRepaint();
	}
}
