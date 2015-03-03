package com.morevaadin.vaadin7.grid;

import com.vaadin.annotations.Title;
import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Panel;
import com.vaadin.ui.UI;

@Title("Vaadin Workshop")
public class GridUi extends UI {

    @Override
    protected void init(VaadinRequest request) {
        SampleGrid grid = new SampleGrid();
        grid.setWidth(100, Unit.PERCENTAGE);
        Panel panel = new Panel(grid);
        panel.setWidth(600, Unit.PIXELS);
        HorizontalLayout layout = new HorizontalLayout(panel);
        layout.setMargin(true);
        layout.setSizeFull();
        layout.setComponentAlignment(panel, Alignment.MIDDLE_CENTER);
        layout.setExpandRatio(panel, 1.0f);
        setContent(layout);
    }
}
