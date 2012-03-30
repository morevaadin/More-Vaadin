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
package com.morevaadin.vaadin.embed;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.bsb.common.vaadin.embed.support.EmbedVaadin;

public class EmbedServerTest {

	@BeforeTest
	protected void setUp() throws InterruptedException {

		Runnable runnable = new Runnable() {

			@Override
			public void run() {

				EmbedVaadin.forApplication(EmbedApplication.class).withHttpPort(8888).wait(true)
						.openBrowser(true).start();
			}
		};

		new Thread(runnable).start();

		// Wait for the server to start
		Thread.sleep(5000);
	}

	@Test
	public void test() {

		// Here, we can test the launched Vaadin application
		// A good component for this is TestBench (commercial)
		// https://vaadin.com/directory#addon/vaadin-testbench
	}
}
