package com.Nilkant.demo;

import java.util.List;

public interface Serviceinterface {
	public String savedata(Student stu);
	public Student logincheck(Student stu);
	public Iterable<Student> viewalldata();
	public String deleteData(Student stu);
	public Student getvaluebyid(String id);
	public Iterable<Student> updatedata(Student stu);

}
