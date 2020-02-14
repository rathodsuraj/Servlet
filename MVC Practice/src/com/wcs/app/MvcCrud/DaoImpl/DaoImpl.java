package com.wcs.app.MvcCrud.DaoImpl;

import java.util.List;

import org.hibernate.Session;

import com.wcs.app.MvcCrud.DaoI.DaoI;
import com.wcs.app.MvcCrud.Model.Student;
import com.wcs.app.MvcCrud.Utility.HibernateUtil;

public class DaoImpl implements DaoI {

	@Override
	public void saveStudent(Student stu) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.save(stu);
		session.beginTransaction().commit();
		System.out.println("data inserted");
	}

	@Override
	public List<Student> loginStudent(String un, String pw) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		List<Student> list = session.createQuery("from Student").getResultList();
		session.beginTransaction().commit();
		return list;
	}

	@Override
	public List<Student> getAllData() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		List<Student> list = session.createQuery("from Student").getResultList();
		return list;
	}

	@Override
	public void deleteStudent(int id) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Student stu = session.get(Student.class, id);
		session.delete(stu);
		session.beginTransaction().commit();
	}

	@Override
	public Student editStudent(int id) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Student stu = session.get(Student.class, id);
		return stu;
	}

	@Override
	public void updateStudent(Student stu) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.update(stu);
		session.beginTransaction().commit();
	}

	@Override
	public List<Student> loginAdmin(String un, String pw) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		List<Student> list = (List) session
				.createQuery("from Student where username='" + un + "' and password='" + pw + "'").getResultList();
		session.beginTransaction().commit();
		return list;
	}

}
