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

@WebServlet(urlPatterns = "/del")
public class DeleteController extends HttpServlet{
	
	ServiceI ser=new ServiceImpl();
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id=Integer.parseInt(req.getParameter("eid"));
		ser.deleteStudent(id);
		List<Student> list=ser.getAllData();
		req.setAttribute("data",list);
		req.getRequestDispatcher("success.jsp").forward(req, resp);
	}

}
