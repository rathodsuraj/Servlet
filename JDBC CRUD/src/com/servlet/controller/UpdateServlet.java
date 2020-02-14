package com.servlet.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;

import org.hibernate.Session;

import com.servlet.model.Employee;
import com.servlet.utility.HibernateUtil;
@WebServlet(urlPatterns = "/updatedb")
public class UpdateServlet extends HttpServlet {
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		Session session=HibernateUtil.getSessionFactory().openSession();
		int id=Integer.parseInt(req.getParameter("emid"));
		Employee emp=session.get(Employee.class, id);
		
		emp.setAddress(req.getParameter("address"));
		emp.setName(req.getParameter("ename"));
		emp.setPassword(req.getParameter("uname"));
		emp.setUsername(req.getParameter("passwd"));
		/*
		 * PrintWriter out=resp.getWriter(); out.write("Update successfully");
		 */
		
		
		  List<Employee> list=session.createQuery("from Employee").getResultList();
		  req.setAttribute("data", list);
		  req.getRequestDispatcher("success.jsp").forward(req, resp);
		 
	}

}
