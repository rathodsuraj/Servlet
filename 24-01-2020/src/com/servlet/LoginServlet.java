package com.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;

@WebServlet(urlPatterns ="/login")
public class LoginServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Student stu=new Student();
		stu.setRollno(23);
		stu.setName("Ankit");
		stu.setAddress("Nagpur");
		
		Student stu1=new Student();
		
		stu1.setRollno(24);
		stu1.setName("Suraj");
		stu1.setAddress("Andheri");
		
		List<Student> list=new ArrayList<Student>();
		list.add(stu);
		list.add(stu1);
		req.setAttribute("data", list);
		
		req.getRequestDispatcher("success.jsp").forward(req, resp);
	}
	
}
