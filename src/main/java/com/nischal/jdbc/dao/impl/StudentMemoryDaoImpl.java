/*
package com.nischal.jdbc.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.nischal.jdbc.dao.StudentDao;
import com.nischal.jdbc.entity.Student;
import com.nischal.jdbc.response.Response;
import com.nischal.jdbc.builder.ResponseBuilder;

public class StudentMemoryDaoImpl implements StudentDao {

	private List<Student> studentList = new ArrayList<>();

	@Override
	public Response save(Student s){
		try {
			studentList.add(s);
		return 	ResponseBuilder.success("student added successfully");
		}
		catch(Exception e){

			return ResponseBuilder.failure(e.getMessage());
		}
	}

	@Override
	public Response update(Student student){

		Optional<Student> std = studentList.stream().filter((s) -> s.getId() == student.getId())
				.map((s) -> {
			s.setName(student.getName());
			s.setAddress(student.getAddress());
			s.setDob(student.getDob());
			s.setPhoneNo(student.getPhoneNo());
			return s;
		}).findFirst();
		
		if(std.isPresent()){
			return ResponseBuilder.success("student updating successful");
		}
		else {
			return  ResponseBuilder.failure("student updating failure");
		}
	}

	@Override
	public Response delete(long id){

		try {
			studentList.stream().filter(s -> s.getId() == id).map(s -> studentList.remove(s)).findFirst().get();
		return ResponseBuilder.success("deleting success");
		}catch (Exception e){

			return ResponseBuilder.failure(e.getMessage());
		}

		}

	@Override
	public Response getAll(){

		try {
			return ResponseBuilder.success(studentList, "getiiing successfull");
		}
		catch(Exception e){
			return ResponseBuilder.failure(e.getMessage());
		}
	}

	@Override
	public Response getById(long id){
		
		Optional<Student> std = studentList.stream().filter((s) -> s.getId() == id).findFirst();
		
		if(std.get()!=null){
			return ResponseBuilder.success(std.get(), "the student with given id is");
		}
		else{
			return ResponseBuilder.failure("student with id"+id+"not found");
		}
	}
}
*/
