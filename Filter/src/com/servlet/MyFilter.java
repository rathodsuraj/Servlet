package com.servlet;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
@WebFilter(urlPatterns = "/login")
public class MyFilter implements Filter{

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {

		System.out.println("-----init-----");
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		System.out.println("-----request-----");
		
		HttpServletRequest req=(HttpServletRequest) request;
		int aid=Integer.parseInt(request.getParameter("usename"));
		
		if(aid>1)
		chain.doFilter(request, response);
		System.out.println("---=response-----");
	}

	@Override
	public void destroy() {
		
		System.out.println("destory");
		
	}

}
