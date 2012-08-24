package com.morevaadin.vaadin7.springsecurity.ui;

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
