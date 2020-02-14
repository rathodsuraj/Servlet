package com.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet(urlPatterns = "/signup")
public class SignupServlet extends HttpServlet{
	
	static Pojo p;
	
	public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		p=new Pojo();
		
		String fname=req.getParameter("fname");
		String lname=req.getParameter("lname");
		String address=req.getParameter("address");
		String email=req.getParameter("email");
		String username=req.getParameter("username");
		String password=req.getParameter("password");
		
		String u=p.setUsername(username);
		String pass=p.setPassword(password);
	
		RequestDispatcher rd=req.getRequestDispatcher("index.html");
		rd.forward(req, res);
			
		}
	}

