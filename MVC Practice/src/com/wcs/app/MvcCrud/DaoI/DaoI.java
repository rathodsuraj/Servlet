package com.wcs.app.MvcCrud.DaoI;

import java.util.List;

import com.wcs.app.MvcCrud.Model.Student;

public interface DaoI {

	public void saveStudent(Student stu);
	List<Student> loginStudent(String un,String pw);
	List<Student> getAllData();
	void deleteStudent(int id);
	Student editStudent(int id);
	void updateStudent(Student stu);
	List<Student> loginAdmin(String un,String pw);
}
