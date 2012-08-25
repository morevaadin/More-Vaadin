package com.morevaadin.vaadin7.springsecurity.service;

/*
 * #%L
 * Vaadin 7 Spring Security Integration
 * %%
 * Copyright (C) 2012 Nicolas Fränkel
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.security.web.authentication.logout.LogoutHandler;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

public class AuthenticationService {

	public void handleAuthentication(String login, String password, HttpServletRequest httpRequest) {
		
		UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(login, password);

		token.setDetails(new WebAuthenticationDetails(httpRequest));

		ServletContext servletContext = httpRequest.getSession().getServletContext();

		WebApplicationContext wac = WebApplicationContextUtils.getRequiredWebApplicationContext(servletContext);

		AuthenticationManager authManager = wac.getBean(AuthenticationManager.class);

		Authentication authentication = authManager.authenticate(token);

		SecurityContextHolder.getContext().setAuthentication(authentication);
	}
	
	public void handleLogout(HttpServletRequest httpRequest) {

		ServletContext servletContext = httpRequest.getSession().getServletContext();

		WebApplicationContext wac = WebApplicationContextUtils.getRequiredWebApplicationContext(servletContext);

		LogoutHandler logoutHandler = wac.getBean(LogoutHandler.class);

		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		
		// Response should not be used?
		logoutHandler.logout(httpRequest, null, authentication);
	}
}
