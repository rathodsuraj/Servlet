package com.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model.Employee;

import Util.ConnectionUtil;

/**
 * Servlet implementation class UpdateServlet
 */
@WebServlet("/update")
public class UpdateServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int id = Integer.parseInt(request.getParameter("eid"));
		Employee e = new Employee();
		try {
			Connection con = ConnectionUtil.getConnection();

			Statement smt = con.createStatement();
			ResultSet rs = smt.executeQuery("select * from employee where empid='" + id + "'");
			while (rs.next()) {
				
				e.setEmpid(rs.getInt(1));
				e.setEname(rs.getString(2));
				e.setAddress(rs.getString(3));
				e.setUsername(rs.getString(4));
				e.setPassword(rs.getString(5));
				
			}

		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		request.setAttribute("emp", e);
		
		RequestDispatcher rd=request.getRequestDispatcher("update.jsp");
		rd.forward(request, response);
		
		
		
		

	}

}
