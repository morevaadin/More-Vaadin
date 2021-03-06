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
package com.morevaadin.vaadin7.converter;

import java.util.Locale;

import org.joda.money.Money;

import com.vaadin.data.util.converter.Converter;

@SuppressWarnings("serial")
public class MoneyConverter implements Converter<String, Money> {

	@Override
	public Money convertToModel(String value, Class<? extends Money> targetType, Locale locale) throws ConversionException {

		try {
			return Money.parse(value);
		} catch (IllegalArgumentException e) {

			throw new ConversionException(e);
		}
	}

	@Override
	public String convertToPresentation(Money money, Class<? extends String> targetType, Locale locale) throws ConversionException {
		return money.toString();
	}

	@Override
	public Class<Money> getModelType() {

		return Money.class;
	}

	@Override
	public Class<String> getPresentationType() {

		return String.class;
	}
}
