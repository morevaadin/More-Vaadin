package com.morevaadin.vaadin.scala

import com.vaadin.event.EventRouter
import com.vaadin.ui.CustomComponent
import vaadin.scala.{ HorizontalLayout, TextField, Button }

@SerialVersionUID(1L)
class CompositeFieldButton() extends CustomComponent {

  val layout = new HorizontalLayout(spacing = true, margin = true) {

    val button = add(new Button(caption = "Hello", action = _ => displayMessage()))

    val field = add(new TextField(value = "world!"))
  }

  setCompositionRoot(layout)

  def displayMessage(): Unit = {

    getWindow().showNotification(layout.button.getCaption() + " " + layout.field.getValue().asInstanceOf[String])
  }
}