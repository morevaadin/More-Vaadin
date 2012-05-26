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

import java.lang.reflect.Method;

import com.morevaadin.vaadin7.custom.client.ui.ButtonState;
import com.vaadin.ui.AbstractComponent;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;

@SuppressWarnings("serial")
public class Button extends AbstractComponent {

	/** Copied from {@link com.vaadin.ui.Button}. */
    private static final Method BUTTON_CLICK_METHOD;

    static {
    
    	try {

    		BUTTON_CLICK_METHOD = ClickListener.class.getDeclaredMethod(
                    "buttonClick", new Class[] { ClickEvent.class });
        
    	} catch (final java.lang.NoSuchMethodException e) {

            throw new java.lang.RuntimeException(
                    "Internal error finding methods in Button");
        }
    }

    public enum Size {

		LARGE, DEFAULT, SMALL, MINI;
	}

	public enum Type {

		DEFAULT, PRIMARY, INFO, SUCCESS, WARNING, DANGER, INVERSE;
	}

	public Button() {

		this("", Type.DEFAULT, Size.DEFAULT);
		
		setImmediate(true);
	}

	public Button(String caption, Size size) {

		this(caption, Type.DEFAULT, size);
	}

	public Button(String caption, Type type) {

		this(caption, type, Size.DEFAULT);
	}

	public Button(String caption, Type type, Size size) {

		setText(caption);
		setSize(size);
		setType(type);
	}

	public Button(String caption) {

		this(caption, Size.DEFAULT);
	}

	public Button(Size size) {

		this("", size);
	}

	public Button(Type type) {

		this("", type);
	}

    public void addListener(ClickListener listener) {

    	addListener(ClickEvent.class, listener, BUTTON_CLICK_METHOD);
    }

	public Size getSize() {

		return Size.valueOf(getState().getSize());
	}

	public Type getType() {

		return Type.valueOf(getState().getType());
	}

	@Override
	public ButtonState getState() {

		return (ButtonState) super.getState();
	}

	public String getText() {

		return getState().getText();
	}

	public void setSize(Size size) {

		getState().setSize(size.toString());
	}

	public void setType(Type size) {

		getState().setType(size.toString());
	}

	public void setText(String text) {

		getState().setText(text);
	}
}
