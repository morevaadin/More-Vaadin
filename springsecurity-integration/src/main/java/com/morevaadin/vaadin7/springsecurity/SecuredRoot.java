package com.morevaadin.vaadin7.springsecurity;

/*
 * #%L
 * Vaadin 7 Spring Security Integration
 * %%
 * Copyright (C) 2012 Nicolas Frankel
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


import static com.vaadin.ui.Notification.TYPE_ERROR_MESSAGE;

import org.springframework.security.authentication.BadCredentialsException;

import com.google.common.eventbus.EventBus;
import com.google.common.eventbus.Subscribe;
import com.morevaadin.vaadin7.springsecurity.event.LoginEvent;
import com.morevaadin.vaadin7.springsecurity.event.LogoutEvent;
import com.morevaadin.vaadin7.springsecurity.service.AuthenticationService;
import com.morevaadin.vaadin7.springsecurity.ui.LoginView;
import com.morevaadin.vaadin7.springsecurity.ui.MainView;
import com.morevaadin.vaadin7.springsecurity.util.RequestHolder;
import com.morevaadin.vaadin7.springsecurity.util.ViewChangeSecurityChecker;
import com.vaadin.annotations.EagerInit;
import com.vaadin.navigator.Navigator;
import com.vaadin.navigator.Navigator.SimpleViewDisplay;
import com.vaadin.terminal.WrappedRequest;
import com.vaadin.ui.Notification;
import com.vaadin.ui.Root;

@SuppressWarnings("serial")
@EagerInit
public class SecuredRoot extends Root {

	private static final String MAIN_VIEW_NAME = "main";

	private static final String LOGIN_VIEW_NAME = "login";

	private EventBus bus = new EventBus();

	private Navigator navigator;

	@Override
	protected void init(WrappedRequest wrappedRequest) {

		getPage().setTitle("Vaadin Spring Security integration example");

		SimpleViewDisplay viewDisplay = new SimpleViewDisplay();

		setContent(viewDisplay);

		navigator = new Navigator(getPage(), viewDisplay);
		
		navigator.addListener(new ViewChangeSecurityChecker());

		navigator.addView(LOGIN_VIEW_NAME, new LoginView(bus));
		navigator.addView(MAIN_VIEW_NAME, new MainView(bus));

		navigator.navigateTo(LOGIN_VIEW_NAME);

		bus.register(this);
	}

	@Subscribe
	public void login(LoginEvent event) {

		AuthenticationService authHandler = new AuthenticationService();

		try {

			authHandler.handleAuthentication(event.getLogin(), event.getPassword(), RequestHolder.getRequest());

			navigator.navigateTo(MAIN_VIEW_NAME);

		} catch (BadCredentialsException e) {

			Notification.show("Bad credentials", TYPE_ERROR_MESSAGE);
		}
	}

	@Subscribe
	public void logout(LogoutEvent event) {

		AuthenticationService authHandler = new AuthenticationService();
		
		authHandler.handleLogout(RequestHolder.getRequest());

		navigator.navigateTo(LOGIN_VIEW_NAME);
	}
}
