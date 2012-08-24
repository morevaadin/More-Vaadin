package com.morevaadin.vaadin7.springsecurity.util;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.context.SecurityContextHolder;

import com.vaadin.terminal.gwt.server.ApplicationServlet;

@SuppressWarnings("serial")
public class RequestHolderApplicationServlet extends ApplicationServlet {

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		SecurityContextHolder.setContext(SecurityContextHolder.createEmptyContext());

		RequestHolder.setRequest(request);

		super.service(request, response);

		// We remove the request from the thread local, there's no reason to keep it once the work is done
		RequestHolder.clean();

		SecurityContextHolder.clearContext();
	}
}
