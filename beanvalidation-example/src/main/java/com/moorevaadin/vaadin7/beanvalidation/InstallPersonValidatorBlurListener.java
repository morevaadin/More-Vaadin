package com.moorevaadin.vaadin7.beanvalidation;

import java.util.Collection;

import com.vaadin.data.Validator;
import com.vaadin.data.validator.BeanValidator;
import com.vaadin.event.FieldEvents.BlurEvent;
import com.vaadin.event.FieldEvents.BlurListener;
import com.vaadin.ui.Field;

@SuppressWarnings("serial")
public class InstallPersonValidatorBlurListener implements BlurListener {

	private Field<?> field;
	
	private String attribute;
	
	public InstallPersonValidatorBlurListener(Field<?> field, String attribute) {

		this.field = field;
		this.attribute = attribute;
	}

	@Override
	public void blur(BlurEvent event) {

		clearValidator(field);
		
		field.addValidator(new BeanValidator(Person.class, attribute));
	}

	private void clearValidator(Field<?> field) {

		Collection<Validator> validators = field.getValidators();

		if (validators != null && !validators.isEmpty()) {

			Validator validator = validators.iterator().next();

			field.removeValidator(validator);
		}
	}
}
