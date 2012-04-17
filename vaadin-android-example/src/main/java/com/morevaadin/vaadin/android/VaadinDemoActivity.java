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
package com.morevaadin.vaadin.android;

import static android.content.pm.ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE;
import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.webkit.WebView;

public class VaadinDemoActivity extends Activity {

	@Override
	public void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);

		Log.i("vaadin-android-example", "onCreate");

		setContentView(R.layout.main);

		setRequestedOrientation(SCREEN_ORIENTATION_LANDSCAPE);
	}

	@Override
	protected void onStart() {

		super.onStart();

		WebView vaadinView = (WebView) findViewById(R.id.vaadinview);

		vaadinView.getSettings().setJavaScriptEnabled(true);
		vaadinView.getSettings().setBuiltInZoomControls(true);

		vaadinView.loadUrl("http://demo.vaadin.com/sampler");
	}
}
