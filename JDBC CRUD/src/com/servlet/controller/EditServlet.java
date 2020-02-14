package com.servlet.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;

import com.servlet.model.Employee;
import com.servlet.utility.HibernateUtil;
@WebServlet(urlPatterns = "/edit")
public class EditServlet extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int id= Integer.parseInt(req.getParameter("eid"));
		Session session=HibernateUtil.getSessionFactory().openSession();
		
		Employee emp=session.get(Employee.class, id);
		emp.getEid();
		emp.getAddress();
		emp.getName();
		emp.getPassword();
		emp.getUsername();
		
		req.setAttribute("details", emp);
		req.getRequestDispatcher("edit.jsp").forward(req, resp);
		
	}

}
