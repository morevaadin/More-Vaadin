package com.morevaadin.vaadin7.sass;

import com.vaadin.annotations.Theme;
import com.vaadin.server.WrappedRequest;
import com.vaadin.ui.Button;
import com.vaadin.ui.Label;
import com.vaadin.ui.UI;

@SuppressWarnings("serial")
@Theme("custom")
public class SassUI extends UI {

	@Override
	protected void init(WrappedRequest request) {

		Button button = new Button("Do nothing");

		Label label = new Label("Rounded borders");

		label.setStyleName("rounded-borders");
		
		addComponent(button);
		addComponent(label);
	}
}
