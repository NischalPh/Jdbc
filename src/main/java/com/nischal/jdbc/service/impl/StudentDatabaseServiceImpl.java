package com.nischal.jdbc.service.impl;

import com.nischal.jdbc.builder.ResponseBuilder;
import com.nischal.jdbc.dao.StudentDao;
import com.nischal.jdbc.dao.impl.StudentDatabaseDaoImpl;
import com.nischal.jdbc.entity.Student;
import com.nischal.jdbc.response.Response;
import com.nischal.jdbc.service.StudentService;

import java.util.List;

public class StudentDatabaseServiceImpl implements StudentService {

    private StudentDao studentDao = new StudentDatabaseDaoImpl();

    Response response = null;

    @Override
    public Response add(Student student) {

        try {
            studentDao.save(student);
            response = ResponseBuilder.success("saveing successfull");
            return response;
        } catch (Exception e) {
            response = ResponseBuilder.failure(e.getMessage());
            return response;
        }

    }

    @Override
    public Response update(Student student) {
        try {
            studentDao.update(student);
            response = ResponseBuilder.success("updating successfull");
            return response;
        } catch (Exception e) {
            response = ResponseBuilder.failure(e.getMessage());
            return response;
        }
    }

    @Override
    public Response delete(Long id) {

        try {
            studentDao.delete(id);
            return ResponseBuilder.success("deleting successfull");
        } catch (Exception e) {
            return ResponseBuilder.failure("deleting student failed" + e.getMessage());
        }
    }

    @Override
    public Response getAll() {
        Response reponse = null;
        try {
            List<Student> studentList = studentDao.getAll();
            return ResponseBuilder.success(studentList);
        } catch (Exception e) {

            return ResponseBuilder.failure(e.getMessage());
        }


    }

    @Override
    public Response getById(Long id) {
        try {
            response = ResponseBuilder.success(studentDao.getById(id));
            return response;
        } catch (Exception e) {
            response = ResponseBuilder.failure(e.getMessage());
            return response;
        }
    }
}
