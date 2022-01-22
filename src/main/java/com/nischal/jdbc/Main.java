package com.nischal.jdbc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.nischal.jdbc.dao.StudentDao;
import com.nischal.jdbc.dao.impl.StudentDatabaseDaoImpl;
import com.nischal.jdbc.entity.Student;
import com.nischal.jdbc.exception.ExceptionHandler;
import com.nischal.jdbc.util.DateUtil;
import com.nischal.jdbc.util.JaksonUtil;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Main {

    public static void main(String[] args) {

		StudentDao studentDao = new StudentDatabaseDaoImpl();

/*		try {
			studentDao.save(Student.builder().id(1).name("nischal").address("thulagaun").dob(new Date()).contactNo("98565656").build());
		}
		catch (Exception e){
			System.out.println("saving failed");
		}

		try {
			studentDao.update(Student.builder().id(1).name("godfather").build());
			//System.out.println(objectMapper.writeValueAsString(studentDao.getAll()));

			System.out.println(JaksonUtil.toJson(studentDao.getAll()));
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}*/

        ExceptionHandler.handle(()-> /*System.out.println(studentDao.update(Student.builder().id(1).name("sudeep").dob(DateUtil.
                        formatDate("2020-02-06", "yyyy-mm-dd")).phoneNo("488484")
                .address("ktm").build()))*/
                System.out.println(studentDao.getById(2 ).toString()));

    }

}
