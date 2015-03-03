package com.morevaadin.vaadin7.grid;

import com.vaadin.data.Container;
import com.vaadin.data.Item;
import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.data.util.GeneratedPropertyContainer;
import com.vaadin.data.util.PropertyValueGenerator;
import com.vaadin.ui.Grid;
import com.vaadin.ui.renderers.ButtonRenderer;
import com.vaadin.ui.renderers.DateRenderer;

import java.util.Arrays;
import java.util.Collection;
import java.util.Date;

public class SampleGrid extends Grid {

    private static final String FORMAT = "%1$td/%1$tm/%1$tY %1$tH:%1$tM:%1$tS";

    public SampleGrid() {
        Collection<Message> messages = Arrays.asList(
            new Message("vaadin", "This is a message", new Date()),
            new Message("vaadin", "Another message", new Date()),
            new Message("Nicolas", "Hello world!", new Date()),
            new Message("Nicolas", "This is a really funny message I might say", new Date()),
            new Message("vaadin", "For sure it is", new Date()));
        Container.Indexed indexed = new BeanItemContainer<>(Message.class, messages);
        GeneratedPropertyContainer wrapperContainer = new GeneratedPropertyContainer(indexed);
        wrapperContainer.removeContainerProperty("id");
        setContainerDataSource(wrapperContainer);
        wrapperContainer.addGeneratedProperty("delete", new PropertyValueGenerator<String>() {
            @Override
            public String getValue(Item item, Object itemId, Object propertyId) {
                return "Delete";
            }

            @Override
            public Class<String> getType() {
                return String.class;
            }
        });
        getColumn("delete").setRenderer(new ButtonRenderer(event -> {
            Object itemId = event.getItemId();
            indexed.removeItem(itemId);
        }));
        getColumn("timeStamp").setRenderer(new DateRenderer(FORMAT));
        getColumns().stream().forEach(c -> c.setSortable(false));
        setHeaderVisible(false);
    }
}
