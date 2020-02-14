package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model.Employee;

import Util.ConnectionUtil;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
        
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		Employee e=new Employee();
		
		int id=Integer.parseInt(request.getParameter("eid"));
		e.setEmpid(id);
		
		e.setEname(request.getParameter("ename"));
		e.setAddress(request.getParameter("add"));
		e.setUsername(request.getParameter("uname"));
		e.setPassword(request.getParameter("pwd"));
		
		try {
		
		Connection con=ConnectionUtil.getConnection();
		
		String sql="insert into employee values(?,?,?,?,?)";
		
		PreparedStatement ps=con.prepareStatement(sql);
		ps.setInt(1, e.getEmpid());
		ps.setString(2,e.getEname());
		ps.setString(3, e.getAddress());
		ps.setString(4, e.getUsername());
		ps.setString(5, e.getPassword());
		ps.execute();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		PrintWriter out=response.getWriter();
		out.print("registration successfully!!");
		RequestDispatcher rd=request.getRequestDispatcher("Login.jsp");
		rd.include(request, response);
		
		
		
		
	
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
