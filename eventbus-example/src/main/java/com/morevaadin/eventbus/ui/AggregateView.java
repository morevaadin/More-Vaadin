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
package com.morevaadin.eventbus.ui;

import com.google.common.eventbus.EventBus;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.FormLayout;

@SuppressWarnings("serial")
public class AggregateView extends CustomComponent {

	public AggregateView() {

		EventBus bus = new EventBus();

		FormLayout layout = new FormLayout();

		FirstComponent first = new FirstComponent(bus);

		SecondComponent second = new SecondComponent();

		bus.register(second);

		layout.addComponent(first);
		layout.addComponent(second);

		setCompositionRoot(layout);
	}
}
