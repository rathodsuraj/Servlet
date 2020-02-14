package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@WebServlet("/second.do")
public class SecondServlet extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		System.out.println("Second servlet");
		String sdata=req.getParameter("t2");
		HttpSession session=req.getSession(false);
		
		if (session ==null) {
			req.getRequestDispatcher("index.jsp").forward(req, resp);
		}
		else {
			
		session.setAttribute("sd", sdata);
		
		PrintWriter out=resp.getWriter();
		out.write("Old session");
		req.getRequestDispatcher("third.jsp").forward(req, resp);
	}
	}
}
