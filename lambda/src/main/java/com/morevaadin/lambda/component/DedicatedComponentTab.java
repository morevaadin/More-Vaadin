package com.morevaadin.lambda.component;

import com.morevaadin.lambda.AbstractLambdaTab;
import com.vaadin.ui.Button;
import com.vaadin.ui.ComponentContainer;

public class DedicatedComponentTab extends AbstractLambdaTab {

    @Override
    protected void setButtonBehavior(Button button, ComponentContainer container) {

        button.addClickListener(new ShowClickMeListener(container));
    }

    @Override
    protected void setCorrespondingCode(StringBuilder builder) {

        builder.append("public class ShowClickMeListener implements Button.ClickListener {\n" +
                "\n" +
                "    private ComponentContainer container;\n" +
                "\n" +
                "    public ShowClickMeListener(ComponentContainer container) {\n" +
                "\n" +
                "        this.container = container;\n" +
                "    }\n" +
                "\n" +
                "    @Override\n" +
                "    public void buttonClick(Button.ClickEvent event) {\n" +
                "\n" +
                "        container.addComponent(new Label(\"Button clicked\"));\n" +
                "    }\n" +
                "}\n\n\n\n" +
                "button.addClickListener(new ShowClickMeListener(container));");
    }
}
