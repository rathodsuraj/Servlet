package com.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet(urlPatterns = "/login")
public class Servlet extends HttpServlet{
	
	public Servlet() {
		
		
		System.out.println(".......servlet.....");
	}
	
	
	  @Override public void init() throws ServletException {
	  System.out.println("init----servlet"); }
	 
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("service method");
		Student stu=new Student();
		stu.setId(23);
		stu.setName("Suraj");
		stu.setAddress("warje");
		
		req.setAttribute("data", stu);
		RequestDispatcher rd=req.getRequestDispatcher("success.jsp");
		rd.forward(req, resp);
		
	}
	
	@Override
	public void destroy() {
		
		System.out.println("destroy----servlet");
	}

}
