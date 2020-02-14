package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Servlet extends HttpServlet {

	protected void service(HttpServletRequest req, HttpServletResponse res) throws IOException {
		
		String uname=req.getParameter("t1");
		String upass=req.getParameter("password");
		
		
		PrintWriter out=res.getWriter();
		
		out.write("<html>");
		out.write("<head> </head>");
		out.write("<body> This is response "+uname+"+"+upass+"</body>");
		out.write("</html>");	
	}
	
}
