package com.servlet.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.hibernate.Session;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.ResultSet;
import com.mysql.jdbc.Statement;
import com.servlet.model.Employee;
import com.servlet.utility.HibernateUtil;
import com.servlet.utility.JdbcUtil;

import java.util.*;

@WebServlet(urlPatterns = "/login")
public class LoginServlet extends HttpServlet {
	private static final boolean CriteriaBuilder = false;
	RegisterServlet rr = new RegisterServlet();

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Session session = HibernateUtil.getSessionFactory().openSession();
		String uname = req.getParameter("uname");
		String upass = req.getParameter("password");

		if (uname.equals("admin") && upass.equals("admin")) {
			List<Employee> list = session.createQuery("from Employee").getResultList();
			// System.out.println(list);
			req.setAttribute("data", list);
			req.getRequestDispatcher("success.jsp").forward(req, resp);

		}

		try {
			Connection con = JdbcUtil.getConnection();
			Statement stmt=JdbcUtil.getStatement();
			ResultSet rs=(ResultSet) stmt.executeQuery("select * from employee");
			while(rs.next()) {
				if (uname.equals(rs.getString(5)) && upass.equals(rs.getString(4))) {
					List<Employee> list=session.createQuery("from Employee").getResultList();
					req.setAttribute("data",list);
					req.getRequestDispatcher("success.jsp").forward(req, resp);
				}
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}