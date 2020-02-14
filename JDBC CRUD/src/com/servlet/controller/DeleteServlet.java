package com.servlet.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.servlet.model.Employee;
import com.servlet.utility.HibernateUtil;
@WebServlet(urlPatterns = "/delete")
public class DeleteServlet extends HttpServlet {
	RegisterServlet rr=new RegisterServlet();
	

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		System.out.println(rr.emp.getEid());
		Session session=HibernateUtil.getSessionFactory().openSession();
		/*
		 * session.getTransaction();
		 * 
		 * String DeleteHQL="delete from Employee where id=:eid";
		 * 
		 * Query query=session.createQuery(DeleteHQL);
		 * query.setParameter("eid",rr.emp.getEid()); query.executeUpdate();
		 * session.getTransaction().commit();
		 */
	int id=Integer.parseInt(req.getParameter("eid"));
		
		Employee emp=session.get(Employee.class,id);
		session.delete(emp);
		session.beginTransaction().commit();
		List<Employee> list = session.createQuery("from Employee").getResultList();
		// System.out.println(list);
		req.setAttribute("data", list);
		req.getRequestDispatcher("delete.jsp").forward(req, resp);
		
	
	}
}
