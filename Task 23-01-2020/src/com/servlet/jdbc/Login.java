package com.servlet.jdbc;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.ResultSet;
import com.mysql.jdbc.Statement;
import com.servlet.jdbc.util.JdbcUtil;
@WebServlet(urlPatterns = "/login")
public class Login extends HttpServlet {
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String uname=req.getParameter("username");
		String pass=req.getParameter("password");
		
		try {
			Connection con=JdbcUtil.getConnection();
			
			String sql="select * from register";
			
			Statement stmt=JdbcUtil.getStatement();
			ResultSet rs=(ResultSet) stmt.executeQuery(sql);
			while(rs.next()) {
				
				if(uname.equals(rs.getInt(5)) && pass.equals(rs.getString(6)))
				{
					System.out.println("FirstName:-"+rs.getInt(1));
					System.out.println("LastName:-"+rs.getString(2));
					System.out.println("Adress:-"+rs.getString(3));
					System.out.println("Age:-"+rs.getInt(4));

				}
				
			}
			
			req.getRequestDispatcher("success.html").forward(req, resp);
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
	
		
	}

}
