package com.Nilkant.demo;


import org.springframework.data.repository.CrudRepository;

public interface Studentrepository extends CrudRepository<Student, Integer> {

	public Student findAllByUsernameAndPwd(String uname, String pass);
	public Student findAllById(int id);
}
