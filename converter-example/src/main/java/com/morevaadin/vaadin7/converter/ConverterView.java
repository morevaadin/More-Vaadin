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

import java.math.BigDecimal;

import org.joda.money.CurrencyUnit;
import org.joda.money.Money;

import com.morevaadin.vaadin7.converter.model.Account;
import com.vaadin.data.fieldgroup.FieldGroup;
import com.vaadin.data.util.BeanItem;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.TextField;

@SuppressWarnings("serial")
public class ConverterView extends CustomComponent {

	public ConverterView() {

		FormLayout layout = new FormLayout();

		layout.setMargin(true);

		setCompositionRoot(layout);

		FieldGroup group = new FieldGroup();

		Account account = new Account();

		Money money = Money.of(CurrencyUnit.USD, new BigDecimal(1000));

		account.setBalance(money);

		group.setItemDataSource(new BeanItem<Account>(account));

		TextField field = (TextField) group.buildAndBind("Balance", "balance");

		field.setImmediate(true);
		field.setConverter(Money.class);

		layout.addComponent(field);
	}
}
