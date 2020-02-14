package com.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(urlPatterns = "/third.do")
public class ThirdServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("Third--servlet");
		String tdata = req.getParameter("t3");
		HttpSession session = req.getSession(false);
		/*
		 * HttpSession session=request.getSession(false);
		 * 
		 * if(session==null) { RequestDispatcher
		 * rd=request.getRequestDispatcher("index.jsp"); rd.forward(request, response);
		 * } else{
		 */
//		HttpSession session=req.getSession();
		session.setAttribute("t3", tdata);
		req.getRequestDispatcher("display.jsp").forward(req, resp);
		// }
	}
}
