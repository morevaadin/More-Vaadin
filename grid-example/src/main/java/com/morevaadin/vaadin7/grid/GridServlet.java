package com.morevaadin.vaadin7.grid;

import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.VaadinServlet;

import javax.servlet.annotation.WebServlet;

@WebServlet(urlPatterns = "/*")
@VaadinServletConfiguration(productionMode = true, ui = GridUi.class)
public class GridServlet extends VaadinServlet {}