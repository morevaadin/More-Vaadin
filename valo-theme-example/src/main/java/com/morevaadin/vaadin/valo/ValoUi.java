package com.morevaadin.vaadin.valo;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.Title;
import com.vaadin.server.ExternalResource;
import com.vaadin.server.VaadinRequest;
import com.vaadin.shared.ui.label.ContentMode;
import com.vaadin.ui.*;

import static com.vaadin.server.Sizeable.Unit.PERCENTAGE;
import static com.vaadin.server.Sizeable.Unit.PIXELS;
import static com.vaadin.shared.ui.label.ContentMode.HTML;

@Title("Valo example")
@Theme("custom")
public class ValoUi extends UI {

    @Override
    protected void init(VaadinRequest vaadinRequest) {
        MenuBar bar = new MenuBar();
        bar.setWidth(100, PERCENTAGE);
        bar.setHeight(50, PIXELS);
        bar.addItem("Valo Example", null);
        Label label = new Label("This is an example of the Valo theming example");
        Button enabledButton = new Button("A simple button");
        Button disabledButton = new Button("A disabled button");
        Link link = new Link("A link", new ExternalResource("http://blog.frankel.ch/"));
        disabledButton.setEnabled(false);
        VerticalLayout mainLayout = new VerticalLayout(label, link, enabledButton, disabledButton);
        mainLayout.setSizeFull();
        mainLayout.setMargin(true);
        mainLayout.setSpacing(true);
        VerticalLayout layout = new VerticalLayout(bar, mainLayout);
        layout.setExpandRatio(mainLayout, 1.0f);
        setContent(layout);
    }
}
