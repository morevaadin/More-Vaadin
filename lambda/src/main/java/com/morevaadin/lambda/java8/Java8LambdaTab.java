package com.morevaadin.lambda.java8;

import com.morevaadin.lambda.AbstractLambdaTab;
import com.vaadin.ui.*;

public class Java8LambdaTab extends AbstractLambdaTab {

    @Override
    protected void setButtonBehavior(Button button, ComponentContainer container) {

        button.addClickListener(e -> container.addComponent(new Label("Button clicked")));
    }

    @Override
    protected void setCorrespondingCode(StringBuilder builder) {

        builder.append("button.addClickListener(e -> container.addComponent(new Label(\"Button clicked\")));");
    }
}
