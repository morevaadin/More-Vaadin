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

import com.morevaadin.vaadin7.custom.Button.Size;
import com.morevaadin.vaadin7.custom.Button.Type;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
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

		
		layout.addComponent(new com.vaadin.ui.Button("Vaadin"));
		Button button = new Button("Default");
		button.addListener(new ClickListener() {
			
			@Override
			public void buttonClick(ClickEvent event) {

				Root.getCurrentRoot().showNotification("I was clicked");
			}
		});
		layout.addComponent(button);
		layout.addComponent(new Button("Large", Size.LARGE));
		layout.addComponent(new Button("Small", Size.SMALL));
		layout.addComponent(new Button("Mini", Size.MINI));
		layout.addComponent(new Button("Primary", Type.PRIMARY));
		layout.addComponent(new Button("Info", Type.INFO));
		layout.addComponent(new Button("Success", Type.SUCCESS));
		layout.addComponent(new Button("Warning", Type.WARNING));
		layout.addComponent(new Button("Danger", Type.DANGER));
		layout.addComponent(new Button("Inverse", Type.INVERSE));
	}
}
