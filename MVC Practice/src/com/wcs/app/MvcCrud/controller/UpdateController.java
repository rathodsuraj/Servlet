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

@WebServlet(urlPatterns = "/update")
public class UpdateController extends HttpServlet {
	
	ServiceI ser=new ServiceImpl();
	
	@Override
	public void init() throws ServletException {
		
		System.out.println("update controller");
	}
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		Student stu=new Student();
		int id=Integer.parseInt(req.getParameter("oid"));
		stu.setId(id);
		stu.setAddress(req.getParameter("address"));
		stu.setAge(req.getParameter("age"));
		stu.setName(req.getParameter("name"));
		stu.setPassword(req.getParameter("password"));
		stu.setUsername(req.getParameter("username"));
		ser.updateStudent(stu);
		List<Student> list=ser.getAllData();
		req.setAttribute("data",list);
		req.getRequestDispatcher("success.jsp").forward(req, resp);
		
		
	}
}
