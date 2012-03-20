package com.moorevaadin.vaadin7.beanvalidation;

import java.util.Collection;

import com.vaadin.data.Validator;
import com.vaadin.data.fieldgroup.FieldGroup;
import com.vaadin.data.fieldgroup.FieldGroup.CommitException;
import com.vaadin.data.util.BeanItem;
import com.vaadin.data.validator.BeanValidator;
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

		group.setFieldFactory(new EnhancedFieldGroupFieldFactory());

		Field<?> gender = group.buildAndBind("Gender", "gender", Select.class);
		firstName = (AbstractTextField) group.buildAndBind("First name", "firstName");
		lastName = (AbstractTextField) group.buildAndBind("Last name", "lastName");
		email = (AbstractTextField) group.buildAndBind("email");
		Field<?> birthdate = group.buildAndBind("Birth date", "birthdate", DateField.class);

		firstName.setNullRepresentation("");
		lastName.setNullRepresentation("");
		email.setNullRepresentation("");

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

		clearValidators();
		installValidators();

		try {

			group.commit();

		} catch (CommitException e) {

		}
	}

	private void clearValidators() {

		AbstractTextField[] fields = new AbstractTextField[] { firstName, lastName, email };

		for (AbstractTextField field : fields) {

			Collection<Validator> validators = field.getValidators();

			if (validators == null || validators.isEmpty()) {

				continue;
			}

			Validator validator = validators.iterator().next();

			field.removeValidator(validator);
		}
	}

	private void installValidators() {

		firstName.addValidator(new BeanValidator(Person.class, "firstName"));
		lastName.addValidator(new BeanValidator(Person.class, "lastName"));
		email.addValidator(new BeanValidator(Person.class, "email"));
	}
}
