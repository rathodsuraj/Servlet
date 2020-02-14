package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model.Employee;

import Util.ConnectionUtil;

/**
 * Servlet implementation class UpdatedbServlet
 */
@WebServlet("/updatedb")
public class UpdatedbServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		int id = Integer.parseInt(request.getParameter("emid"));
		String name = request.getParameter("name");
		String add = request.getParameter("add");
		String uname = request.getParameter("uname");
		String pass = request.getParameter("pass");

		List<Employee> elist = new ArrayList<>();

		try {
			Connection con = ConnectionUtil.getConnection();

			Statement smt = con.createStatement();
			smt.execute("update employee set ename='" + name + "',address='" + add + "',username='" + uname
					+ "',password='" + pass + "'where empid='" + id + "'");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		try {
			Connection con = ConnectionUtil.getConnection();
			String sql = "select * from employee";

			Statement smt = con.createStatement();
			ResultSet rs1 = smt.executeQuery(sql);
			while (rs1.next()) {
				Employee e1 = new Employee();

				e1.setEmpid(rs1.getInt(1));
				e1.setEname(rs1.getString(2));
				e1.setAddress(rs1.getString(3));
				e1.setUsername(rs1.getString(4));
				e1.setPassword(rs1.getString(5));
				elist.add(e1);

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		request.setAttribute("list", elist);
		PrintWriter out = response.getWriter();
		out.print("update successfully");
		RequestDispatcher rd = request.getRequestDispatcher("success.jsp");
		rd.include(request, response);

	}

}
