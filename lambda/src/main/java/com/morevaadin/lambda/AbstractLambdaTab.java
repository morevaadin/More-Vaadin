package com.morevaadin.lambda;

import com.vaadin.ui.*;

import static com.vaadin.shared.ui.label.ContentMode.HTML;

public abstract class AbstractLambdaTab extends HorizontalLayout {

    public AbstractLambdaTab() {

        setMargin(true);
        setSpacing(true);

        VerticalLayout left = new VerticalLayout();

        Button button = new Button("Click me");

        setButtonBehavior(button, left);

        left.addComponent(button);

        StringBuilder builder = new StringBuilder("<pre>");
        setCorrespondingCode(builder);
        builder.append("</pre>");

        Label right = new Label(builder.toString(), HTML);

        right.setSizeFull();

        addComponent(left);
        addComponent(right);

        setSizeFull();
    }

    protected abstract void setButtonBehavior(Button button, ComponentContainer container);

    protected abstract void setCorrespondingCode(StringBuilder builder );
}
