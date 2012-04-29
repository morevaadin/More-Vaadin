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
package com.morevaadin.vaadin.scala

import com.vaadin.ui.CustomComponent
import vaadin.scala.{ HorizontalLayout, TextField, Button }

@SerialVersionUID(1L)
class CompositeFieldButton extends CustomComponent {

  val layout = new HorizontalLayout(spacing = true, margin = true) {

    val button = add(new Button("Hello", _ => displayMessage))

    val field = add(new TextField(value = "world!"))
  }

  setCompositionRoot(layout)

  def displayMessage() {

    getWindow.showNotification(layout.button.getCaption + " " + layout.field.getValue)
  }
}