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
package com.moorevaadin.vaadin7.beanvalidation;

import static com.vaadin.ui.Notification.TYPE_ERROR_MESSAGE;
import static com.vaadin.ui.Notification.TYPE_HUMANIZED_MESSAGE;

import com.vaadin.data.fieldgroup.FieldGroup;
import com.vaadin.data.fieldgroup.FieldGroup.CommitException;
import com.vaadin.data.util.BeanItem;
import com.vaadin.terminal.WrappedRequest;
import com.vaadin.ui.AbstractTextField;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.DateField;
import com.vaadin.ui.Field;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.Root;
import com.vaadin.ui.Select;

@SuppressWarnings("serial")
public class BeanValidationRoot extends Root {

	private FieldGroup group;

	private FormLayout layout = new FormLayout();

	private AbstractTextField firstName;
	private AbstractTextField lastName;
	private AbstractTextField email;

	@Override
	protected void init(WrappedRequest request) {

		setCaption("Vaadin 7 Bean validation example");

		layout.setMargin(true);

		setContent(layout);

		BeanItem<Person> item = new BeanItem<Person>(new Person());

		group = new FieldGroup(item);

		//group.setFieldFactory(new EnhancedFieldGroupFieldFactory());

		Field<?> gender = group.buildAndBind("Gender", "gender", Select.class);
		firstName = (AbstractTextField) group.buildAndBind("First name", "firstName");
		lastName = (AbstractTextField) group.buildAndBind("Last name", "lastName");
		email = (AbstractTextField) group.buildAndBind("email");
		Field<?> birthdate = group.buildAndBind("Birth date", "birthdate", DateField.class);

		firstName.setNullRepresentation("");
		lastName.setNullRepresentation("");
		email.setNullRepresentation("");

		firstName.addListener(new InstallPersonValidatorBlurListener(firstName, "firstName"));
		lastName.addListener(new InstallPersonValidatorBlurListener(lastName, "lastName"));
		email.addListener(new InstallPersonValidatorBlurListener(email, "email"));

		layout.addComponent(gender);
		layout.addComponent(firstName);
		layout.addComponent(lastName);
		layout.addComponent(email);
		layout.addComponent(birthdate);

		Button commit = new Button("Commit");

		commit.addListener(ClickEvent.class, this, "commit");

		layout.addComponent(commit);
	}

	public void commit() {

		try {

            ValidatorUtils.installSingleValidator(firstName, "firstName");
            ValidatorUtils.installSingleValidator(lastName, "lastName");
            ValidatorUtils.installSingleValidator(email, "email");
            
            group.commit();

			showNotification("Creation done", TYPE_HUMANIZED_MESSAGE);

		} catch (CommitException e) {

			showNotification("Please correct errors before commiting", TYPE_ERROR_MESSAGE);
		}
	}
}
