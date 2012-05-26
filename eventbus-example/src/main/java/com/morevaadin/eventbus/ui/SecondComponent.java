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

import java.util.Arrays;

import com.google.common.eventbus.Subscribe;
import com.morevaadin.eventbus.data.Capital;
import com.morevaadin.eventbus.data.Country;
import com.morevaadin.eventbus.ui.event.CountryChangedEvent;
import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.CustomComponent;

@SuppressWarnings("serial")
public class SecondComponent extends CustomComponent {

	private ComboBox cb = new ComboBox("Locale");

	public SecondComponent() {

		BeanItemContainer<Capital> container = new BeanItemContainer<Capital>(Capital.class);

		for (Capital capital : Capital.values()) {

			container.addBean(capital);
		}

		cb.setContainerDataSource(container);
		cb.setItemCaptionPropertyId("label");

		setCompositionRoot(cb);
	}

	@Subscribe
	public void changeLocaleOnCountryChange(CountryChangedEvent event) {

		Country country = event.getCountry();

		int index = Arrays.asList(Country.values()).indexOf(country);

		if (index > -1) {

			cb.select(Capital.values()[index]);

		} else {

			cb.select(null);
		}
	}
}
