package com.morevaadin.lambda;

import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.VaadinServlet;

import javax.servlet.annotation.WebServlet;

@VaadinServletConfiguration(ui = LambdaUi.class, productionMode = false)
@WebServlet(urlPatterns = "/*", asyncSupported = true)
public class LambdaServlet extends VaadinServlet {
}
