package com.nischal.jdbc.dao;

import java.util.List;

import com.nischal.jdbc.entity.Student;
import com.nischal.jdbc.response.Response;

public interface StudentDao {
	
	boolean save(Student s) throws Exception;
	boolean update(Student s) throws Exception;
	boolean delete(long id) throws Exception;
	List<Student> getAll() throws Exception;
	Student getById(long id) throws Exception;
}
