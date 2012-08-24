package com.morevaadin.vaadin7.springsecurity.util;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import com.morevaadin.vaadin7.springsecurity.ui.LoginView;
import com.vaadin.navigator.ViewChangeListener;

@SuppressWarnings("serial")
public class ViewChangeSecurityChecker implements ViewChangeListener {

	@Override
	public boolean isViewChangeAllowed(ViewChangeEvent event) {

		if (event.getNewView() instanceof LoginView) {

			return true;
		}

		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

		return authentication == null ? false : authentication.isAuthenticated();
	}

	@Override
	public void navigatorViewChanged(ViewChangeEvent event) {}
}
