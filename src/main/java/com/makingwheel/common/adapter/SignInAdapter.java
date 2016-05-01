package com.makingwheel.common.adapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class SignInAdapter extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		if (null == request.getSession().getAttribute("user")) {
			response.sendRedirect(request.getContextPath() + "/sign/on.op");
			return false;
		} 
		return true;
	}

	
}
