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
package com.morevaadin.vaadin7.navigation;

import com.vaadin.navigator.Navigator;
import com.vaadin.terminal.WrappedRequest;
import com.vaadin.ui.Label;
import com.vaadin.ui.MenuBar;
import com.vaadin.ui.MenuBar.Command;
import com.vaadin.ui.MenuBar.MenuItem;
import com.vaadin.ui.Panel;
import com.vaadin.ui.Root;
import com.vaadin.ui.VerticalLayout;

/**
 * @author <a href="http://blog.frankel.ch/">Nicolas Frankel</a>
 * @since 6 juil. 2012
 * @version 1.0
 */
@SuppressWarnings("serial")
public class NavigationRoot extends Root {

	private static final String[] VIEWS = { "Alternate", "Main", "Secondary", "Principal" };

	@Override
	protected void init(WrappedRequest request) {

		VerticalLayout layout = new VerticalLayout();

		MenuBar bar = new MenuBar();

		layout.addComponent(bar);

		Panel panel = new Panel() {
			
			{ addComponent(new Label("Default")); }
		};

		layout.addComponent(panel);

		setContent(layout);

		final Navigator navigator = new Navigator(panel);

		for (final String view : VIEWS) {

			bar.addItem(view, new Command() {

				@Override
				public void menuSelected(MenuItem selectedItem) {

					navigator.navigateTo(view);
				}
			});

			navigator.addView(view, new ViewLayout(view));
		}
	}
}
