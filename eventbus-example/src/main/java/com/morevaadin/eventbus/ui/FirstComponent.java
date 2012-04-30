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
import com.morevaadin.eventbus.data.Country;
import com.morevaadin.eventbus.ui.event.CountryChangedEvent;
import com.vaadin.data.Property.ValueChangeEvent;
import com.vaadin.data.Property.ValueChangeListener;
import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.CustomComponent;

@SuppressWarnings("serial")
public class FirstComponent extends CustomComponent {

	private ComboBox cb = new ComboBox("Country");

	public FirstComponent(final EventBus bus) {
		
		BeanItemContainer<Country> container = new BeanItemContainer<Country>(Country.class);

		for (Country country : Country.values()) {
			
			container.addBean(country);
		}

		cb.setContainerDataSource(container);
		cb.setItemCaptionPropertyId("label");
		cb.setImmediate(true);

		setCompositionRoot(cb);

		cb.addListener(new ValueChangeListener() {

			@Override
			public void valueChange(ValueChangeEvent vcEvent) {

				CountryChangedEvent event = new CountryChangedEvent((Country) vcEvent.getProperty().getValue());

				bus.post(event);
			}
		});
	}
}
