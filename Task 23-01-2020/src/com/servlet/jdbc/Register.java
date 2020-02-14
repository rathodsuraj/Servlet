package com.servlet.jdbc;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.servlet.jdbc.util.JdbcUtil;

@WebServlet(urlPatterns = "/register")
public class Register extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		int Age = Integer.parseInt(req.getParameter("age"));
		int Uid = Integer.parseInt(req.getParameter("id"));

		try {
			Connection con = JdbcUtil.getConnection();
			String sql = "insert into register values(?,?,?,?,?,?)";
			PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);
			ps.setString(1, req.getParameter("fname"));
			ps.setString(2, req.getParameter("lname"));
			ps.setString(3, req.getParameter("address"));
			ps.setInt(4, Age);
			ps.setInt(5, Uid);
			ps.setString(6, req.getParameter("upass"));
			ps.execute();
			
			PrintWriter out=resp.getWriter();
			out.write("User Registered Successfully..");
			req.getRequestDispatcher("SignUp.html").include(req, resp);

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

	}

}
