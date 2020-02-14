package com.wcs.app.MvcCrud.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wcs.app.MvcCrud.Model.Student;
import com.wcs.app.MvcCrud.ServiceI.ServiceI;
import com.wcs.app.MvcCrud.serviceImpl.ServiceImpl;

@WebServlet(urlPatterns = "/login")
public class LoginController extends HttpServlet {
	ServiceI ser = new ServiceImpl();

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String username = req.getParameter("username");
		String password = req.getParameter("password");

		if (username.equals("admin") && password.equals("admin")) {
			List<Student> list = ser.loginStudent(username, password);
			req.setAttribute("data", list);
			req.getRequestDispatcher("success.jsp").forward(req, resp);
		} else if (username.equals(username) && password.equals(password)) {
			List<Student> list = ser.loginAdmin(username, password);
			req.setAttribute("user", list);
			req.getRequestDispatcher("userpage.jsp").forward(req, resp);

		} else if (username.equals("") && password.equals("")) {
			req.getRequestDispatcher("index.jsp").forward(req, resp);
		}
	}
}
