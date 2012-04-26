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
package com.morevaadin.vaadin.externallayout;

import org.vaadin.risto.externallayout.ExternalLayout;

import com.vaadin.Application;
import com.vaadin.ui.Window;

@SuppressWarnings("serial")
public class ExternalLayoutApplication extends Application {

	@Override
	public void init() {

		Window window = new Window();

		window.addComponent(new ExternalLayout("menu", new EclipseMenuBar()));
		window.addComponent(new View());

		setMainWindow(window);
	}
}
