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

		ValidatorUtils.installSingleValidator(field, attribute);
	}
}
