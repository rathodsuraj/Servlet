package com.wcs.app.MvcCrud.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wcs.app.MvcCrud.Model.Student;
import com.wcs.app.MvcCrud.ServiceI.ServiceI;
import com.wcs.app.MvcCrud.serviceImpl.ServiceImpl;

@WebServlet(urlPatterns = "/signup")
public class SignUpController extends HttpServlet {

	ServiceI ser = new ServiceImpl();

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		Student stu=new Student();
		int id=Integer.parseInt(req.getParameter("id"));
		String name=req.getParameter("name");
		String age=req.getParameter("age");
		String address=req.getParameter("address");
		String username=req.getParameter("uname");
		String password=req.getParameter("passwd");
		stu.setId(id);
		stu.setName(name);
		stu.setAge(age);
		stu.setAddress(address);
		stu.setUsername(username);
		stu.setPassword(password);
		ser.saveStudent(stu);
		
		req.getRequestDispatcher("index.jsp").forward(req, resp);
		
	}

}
