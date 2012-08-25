package com.morevaadin.vaadin7.springsecurity.ui;

/*
 * #%L
 * Vaadin 7 Spring Security Integration
 * %%
 * Copyright (C) 2012 Nicolas Fränkel
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */

import org.springframework.security.core.context.SecurityContextHolder;

import com.google.common.eventbus.EventBus;
import com.morevaadin.vaadin7.springsecurity.event.LogoutEvent;
import com.vaadin.navigator.View;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.Label;
import com.vaadin.ui.Panel;

@SuppressWarnings("serial")
public class MainView extends Panel implements View {

	private Label label;

	public MainView(final EventBus eventBus) {

		label = new Label();

		addComponent(label);
		
		Button button = new Button("Logout");
		
		button.addListener(new ClickListener() {

			@Override
			public void buttonClick(ClickEvent event) {

				eventBus.post(new LogoutEvent());
			}
		});
		
		addComponent(button);
	}

	@Override
	public void navigateTo(String fragmentParameters) {

		String user = SecurityContextHolder.getContext().getAuthentication().getName();

		label.setValue("Welcome to " + user);
	}
}
