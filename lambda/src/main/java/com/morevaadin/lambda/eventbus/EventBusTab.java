package com.morevaadin.lambda.eventbus;

import com.google.gwt.thirdparty.guava.common.eventbus.EventBus;
import com.morevaadin.lambda.AbstractLambdaTab;
import com.vaadin.ui.Button;
import com.vaadin.ui.ComponentContainer;

public class EventBusTab extends AbstractLambdaTab {

    private EventBus bus;

    private EventBus getEventBus() {

        if (bus == null) {

            bus = new EventBus();
        }

        return bus;
    }

    @Override
    protected void setButtonBehavior(Button button, ComponentContainer container) {

        button.addClickListener(e -> getEventBus().post(new ButtonClickedEvent(container)));

        getEventBus().register(new ShowClickMeListener());
    }

    @Override
    protected void setCorrespondingCode(StringBuilder builder) {

        builder.append("public class ShowClickMeListener {\n" +
                "\n" +
                "    @Subscribe\n" +
                "    public void onClick(ButtonClickedEvent event) {\n" +
                "\n" +
                "        event.getContainer().addComponent(new Label(\"Button clicked\"));\n" +
                "    }\n" +
                "}\n\n\n\n" +
                "public class ButtonClickedEvent {\n" +
                "\n" +
                "    private ComponentContainer container;\n" +
                "\n" +
                "    public ButtonClickedEvent(ComponentContainer container) {\n" +
                "\n" +
                "        this.container = container;\n" +
                "    }\n" +
                "\n" +
                "    public ComponentContainer getContainer() {\n" +
                "\n" +
                "        return container;\n" +
                "    }\n" +
                "}\n\n\n\n" +
                "button.addClickListener(e -> getEventBus().post(new ButtonClickedEvent(container)));\n" +
                "\n" +
                "getEventBus().register(new ShowClickMeListener());");
    }
}
