package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet(urlPatterns = "/login")
public class Servlet extends HttpServlet{
	
	public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		
		String uname=req.getParameter("username");
		String pass=req.getParameter("password");
		
		Pojo p=SignupServlet.p;
		
		if (uname.equals(p.getUsername()) && pass.equals(p.getPassword())) {
			RequestDispatcher rd=req.getRequestDispatcher("done.html");
			rd.forward(req, res);
			
		} else {
			PrintWriter out=res.getWriter();
			out.write("Incorrect Username or Password..");
			RequestDispatcher rd=req.getRequestDispatcher("index.html");
			rd.include(req, res);
		}
		
	}

}
