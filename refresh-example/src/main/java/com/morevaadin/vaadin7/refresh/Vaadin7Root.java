/*
* Copyright 2011 Nicolas Frankel
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

package com.morevaadin.vaadin7.refresh;

import static java.text.DateFormat.LONG;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import com.vaadin.data.Property.ValueChangeEvent;
import com.vaadin.data.Property.ValueChangeListener;
import com.vaadin.terminal.DeploymentConfiguration;
import com.vaadin.terminal.WrappedRequest;
import com.vaadin.terminal.WrappedRequest.BrowserDetails;
import com.vaadin.terminal.gwt.server.WebBrowser;
import com.vaadin.ui.CheckBox;
import com.vaadin.ui.GridLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Root;
import com.vaadin.ui.VerticalLayout;

@SuppressWarnings("serial")
public class Vaadin7Root extends Root {

	private VerticalLayout mainLayout = new VerticalLayout();

	private GridLayout gridLayout = new GridLayout();

	public Vaadin7Root() {

		addComponent(mainLayout);

		final CheckBox checkBox = new CheckBox("Preserve root");
		
		checkBox.setImmediate(true);

		checkBox.addListener(new ValueChangeListener() {

			@Override
			public void valueChange(ValueChangeEvent event) {

				getApplication().setRootPreserved(checkBox.getValue());
			}
		});

		mainLayout.addComponent(checkBox);

		gridLayout.setColumns(2);

		mainLayout.addComponent(gridLayout);
	}

	@Override
	public void init(WrappedRequest wrapped) {

		BrowserDetails details = wrapped.getBrowserDetails();

		addInfoLine("Window name", details.getWindowName());
		addInfoLine("URI fragment", details.getUriFragment());

		WebBrowser browser = details.getWebBrowser();

		addInfoLine("Default theme", browser.getDefaultTheme());

		addInfoLine("Client IP", browser.getAddress());
		addInfoLine("User agent", browser.getBrowserApplication());
		addInfoLine("User agent major version", String.valueOf(browser.getBrowserMajorVersion()));
		addInfoLine("User agent minor version", String.valueOf(browser.getBrowserMinorVersion()));

		addInfoLine("Window height", String.valueOf(browser.getClientHeight()));
		addInfoLine("Window width", String.valueOf(browser.getClientWidth()));
		addInfoLine("Screen height", String.valueOf(browser.getScreenHeight()));
		addInfoLine("Screen width", String.valueOf(browser.getScreenWidth()));

		Date date = browser.getCurrentDate();
		Locale locale = browser.getLocale();

		DateFormat format = DateFormat.getDateTimeInstance(LONG, LONG, locale);

		addInfoLine("Init. date", format.format(date));
		addInfoLine("Language", locale.getDisplayLanguage(locale));
		addInfoLine("Country", locale.getDisplayCountry(locale));

		DeploymentConfiguration deploy = wrapped.getDeploymentConfiguration();

		addInfoLine("Configured widgetset", deploy.getConfiguredWidgetset(wrapped));
		addInfoLine("Static file location", deploy.getStaticFileLocation(wrapped));
		addInfoLine("Configured theme", deploy.getConfiguredTheme(wrapped));
	}

	private void addInfoLine(String label, String info) {

		Label key = new Label(label);
		Label value = new Label(info);

		gridLayout.addComponent(key);
		gridLayout.addComponent(value);
	}
}
