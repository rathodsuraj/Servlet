package com.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@WebServlet("/first")
public class FirstServlet extends HttpServlet {
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		System.out.println("First Servlet");
		String fdata=req.getParameter("t1");
		HttpSession session=req.getSession();
		if (!session.isNew()) {
			System.out.println("inside if");
			session.invalidate();
			session=req.getSession();
		}
		System.out.println("outside if");
		session.setAttribute("fn", fdata);
		/* req.getRequestDispatcher("second.jsp").forward(req, resp); */
		resp.sendRedirect("second.jsp");
	}

}
