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
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");

		String uname = request.getParameter("t1");
		String pwd = request.getParameter("t2");

		List<Employee> elist = new ArrayList<>();
		try {
			Connection con = ConnectionUtil.getConnection();

			String sql = "select * from employee";

			Statement smt = con.createStatement();

			if (uname.equals("admin")) {

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

			} else {

				ResultSet rs2 = smt
						.executeQuery("select * from employee where username='" + uname + "'and password='" + pwd + "'");
				
				
				
				while (rs2.next()) {
					Employee e1 = new Employee();

					e1.setEmpid(rs2.getInt(1));
					e1.setEname(rs2.getString(2));
					e1.setAddress(rs2.getString(3));
					e1.setUsername(rs2.getString(4));
					e1.setPassword(rs2.getString(5));
					elist.add(e1);
				}

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		request.setAttribute("list", elist);
		if(elist.isEmpty()) {
			PrintWriter out=response.getWriter();
			out.print("invalid username and password");
			RequestDispatcher rd = request.getRequestDispatcher("Login.jsp");
			rd.include(request, response);
			
		}else {

		RequestDispatcher rd = request.getRequestDispatcher("success.jsp");
		rd.forward(request, response);
		}
	}

}
