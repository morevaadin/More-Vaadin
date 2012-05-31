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

import com.vaadin.terminal.gwt.client.ComponentState;

@SuppressWarnings("serial")
public class BootstrapButtonState extends ComponentState {

	private String text = "";

	private String type = "DEFAULT";

	private String size = "DEFAULT";

	public String getSize() {

		return size;
	}

	public String getText() {

		return text;
	}

	public String getType() {

		return type;
	}

	public void setSize(String size) {

		this.size = size;
	}

	public void setText(String text) {

		this.text = text;
	}

	public void setType(String type) {

		this.type = type;
	}
}
