package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;
import com.Student;

@WebServlet(urlPatterns = "/form")
public class LoginServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String uname = req.getParameter("t1");
		int rollno = Integer.parseInt(req.getParameter("t2"));

		Student s1 = new Student();
		s1.setName("suraj");
		s1.setRollno(56);

		Student s2 = new Student();
		s2.setName("vikas");
		s2.setRollno(67);

		List li = new ArrayList();
		li.add(s1);
		li.add(s2);
		req.setAttribute("data", li);

		req.getRequestDispatcher("success.jsp").forward(req, resp);
	}

}
