package com.morevaadin.vaadin7.sass;

/*
 * #%L
 * sass-example
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
