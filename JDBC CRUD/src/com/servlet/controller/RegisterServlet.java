package com.servlet.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;

import com.servlet.model.Employee;
import com.servlet.utility.HibernateUtil;
@WebServlet(urlPatterns = "/signup")
public class RegisterServlet extends HttpServlet {
	Employee emp=new Employee();
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		Session session=HibernateUtil.getSessionFactory().openSession();
	
	
	int eid=Integer.parseInt(req.getParameter("eid"));
	emp.setEid(eid);
	emp.setName(req.getParameter("ename"));
	emp.setAddress(req.getParameter("eaddress"));
	emp.setUsername(req.getParameter("username"));
	emp.setPassword(req.getParameter("password"));
	
	session.save(emp);
	session.beginTransaction().commit();
	PrintWriter out=resp.getWriter();
	out.write("User signup successfully");
	req.getRequestDispatcher("login.jsp").forward(req, resp);
	
	}	
}
