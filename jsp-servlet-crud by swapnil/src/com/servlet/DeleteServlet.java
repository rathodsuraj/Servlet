package com.servlet;

import java.io.IOException;
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
 * Servlet implementation class DeleteServlet
 */
@WebServlet("/del")
public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String emid = request.getParameter("eid");
		int id = Integer.parseInt(emid);
		try {
			Connection con = ConnectionUtil.getConnection();

			// String sql="delete from employee where empid="+id;
			Statement smt = con.createStatement();
			smt.execute("delete from employee where empid='" + id + "'");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		List<Employee> elist = new ArrayList<>();

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

		request.setAttribute("list1", elist);

		RequestDispatcher rd = request.getRequestDispatcher("AllRecords.jsp");
		rd.forward(request, response);

	}

}
