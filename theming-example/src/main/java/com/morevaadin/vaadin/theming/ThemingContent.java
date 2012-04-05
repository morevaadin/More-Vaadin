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
package com.morevaadin.vaadin.theming;

import com.vaadin.ui.Button;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.CustomLayout;
import com.vaadin.ui.InlineDateField;
import com.vaadin.ui.MenuBar;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;

@SuppressWarnings("serial")
public class ThemingContent extends CustomComponent {

	private MenuBar menuBar = new MenuBar();

	public ThemingContent() {

		CustomLayout layout = new CustomLayout("layout");

		setCompositionRoot(layout);

		layout.addComponent(menuBar, "top");
		layout.addComponent(new Button("Does nothing"), "bottom");

		VerticalLayout vLayout = new VerticalLayout();

		vLayout.addComponent(new InlineDateField());
		vLayout.addComponent(new TextField("", "Nothing to put in here"));
		vLayout.setSpacing(true);
		vLayout.setMargin(true);

		layout.addComponent(vLayout, "left");
	}

	void afterApplicationSet() {

		menuBar.addItem("Reindeer", new ThemeCommand(getApplication(), "reindeer"));
		menuBar.addItem("Reindeer mods", new ThemeCommand(getApplication(), "reindeermods"));
		menuBar.addItem("Custom theme", new ThemeCommand(getApplication(), "custom"));
	}
}
