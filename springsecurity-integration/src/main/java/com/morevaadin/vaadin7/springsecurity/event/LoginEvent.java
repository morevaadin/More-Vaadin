package com.morevaadin.vaadin7.springsecurity.event;

public class LoginEvent {

	private final String login;

	private final String password;

	public LoginEvent(String login, String password) {

		this.login = login;
		this.password = password;
	}

	public String getLogin() {

		return login;
	}

	public String getPassword() {

		return password;
	}
}
