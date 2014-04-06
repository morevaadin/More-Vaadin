package com.morevaadin.lambda.prejava8;

import com.morevaadin.lambda.AbstractLambdaTab;
import com.vaadin.ui.Button;
import com.vaadin.ui.ComponentContainer;
import com.vaadin.ui.Label;

public class PreJava8Tab extends AbstractLambdaTab {

    @Override
    protected void setButtonBehavior(Button button, ComponentContainer container) {

        button.addClickListener(new Button.ClickListener() {

            @Override
            public void buttonClick(Button.ClickEvent event) {

                container.addComponent(new Label("Button clicked"));
            }
        });
    }

    @Override
    protected void setCorrespondingCode(StringBuilder builder) {

        builder.append("button.addClickListener(new Button.ClickListener() {\n" +
                "\n" +
                "    @Override\n" +
                "    public void buttonClick(Button.ClickEvent event) {\n" +
                "\n" +
                "        container.addComponent(new Label(\"Button clicked\"));\n" +
                "    }\n" +
                "});");
    }
}
