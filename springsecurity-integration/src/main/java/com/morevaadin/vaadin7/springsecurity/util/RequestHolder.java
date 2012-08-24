package com.morevaadin.vaadin7.springsecurity.util;

import javax.servlet.http.HttpServletRequest;

public class RequestHolder {

	private static final ThreadLocal<HttpServletRequest> THREAD_LOCAL = new ThreadLocal<HttpServletRequest>();

	public static HttpServletRequest getRequest() {
		
		return THREAD_LOCAL.get();
	}
	
	static void setRequest(HttpServletRequest request) {
		
		THREAD_LOCAL.set(request);
	}
	
	static void clean() {
		
		THREAD_LOCAL.remove();
	}
}
