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

import com.morevaadin.vaadin7.custom.BootstrapButton.Size;
import com.morevaadin.vaadin7.custom.BootstrapButton.Type;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.Root;
import com.vaadin.ui.VerticalLayout;

@SuppressWarnings("serial")
public class CustomComponentView extends CustomComponent {

	public CustomComponentView() {

		VerticalLayout layout = new VerticalLayout();

		layout.setMargin(true);
		layout.setSpacing(true);

		setCompositionRoot(layout);

		Button button = new Button("Vaadin");
		button.addListener(ClickEvent.class, this, "showClick");
		layout.addComponent(button);

		BootstrapButton customButton = new BootstrapButton("Default");
		customButton.addListener(BootstrapClickEvent.class, this, "showClick");
		layout.addComponent(customButton);

		layout.addComponent(new BootstrapButton("Large", Size.LARGE));
		layout.addComponent(new BootstrapButton("Small", Size.SMALL));
		layout.addComponent(new BootstrapButton("Mini", Size.MINI));
		layout.addComponent(new BootstrapButton("Primary", Type.PRIMARY));
		layout.addComponent(new BootstrapButton("Info", Type.INFO));
		layout.addComponent(new BootstrapButton("Success", Type.SUCCESS));
		layout.addComponent(new BootstrapButton("Warning", Type.WARNING));
		layout.addComponent(new BootstrapButton("Danger", Type.DANGER));
		layout.addComponent(new BootstrapButton("Inverse", Type.INVERSE));
	}

	public void showClick() {

		Root.getCurrentRoot().showNotification("I was clicked");
	}
}
