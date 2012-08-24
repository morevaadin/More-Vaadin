package com.morevaadin.vaadin7.springsecurity.ui;

import com.google.common.eventbus.EventBus;
import com.morevaadin.vaadin7.springsecurity.event.LoginEvent;
import com.vaadin.navigator.View;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.PasswordField;
import com.vaadin.ui.TextField;

@SuppressWarnings("serial")
public class LoginView extends FormLayout implements View  {

	private TextField loginField = new TextField("Login");

	private PasswordField passwordField = new PasswordField("Password");
	
	public LoginView(final EventBus eventBus) {

		setMargin(true);

		addComponent(loginField);
		addComponent(passwordField);

		Button button = new Button("Let me in");

		button.addListener(new ClickListener() {
			
			@Override
			public void buttonClick(ClickEvent clickEvent) {

				LoginEvent loginEvent = new LoginEvent(loginField.getValue(), passwordField.getValue());

				eventBus.post(loginEvent);
				
				loginField.setValue("");
				passwordField.setValue("");
			}
		});
		
		addComponent(button);
	}
	
	@Override
	public void navigateTo(String fragmentParameters) {}
}
