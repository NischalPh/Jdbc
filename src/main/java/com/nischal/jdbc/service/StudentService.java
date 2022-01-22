package com.nischal.jdbc.service;

import com.nischal.jdbc.entity.Student;
import com.nischal.jdbc.response.Response;

public interface StudentService {

    Response add(Student student); // CREATE

    Response update(Student student); // UPDATE

    Response delete(Long id); // DELETE

    Response getAll(); // READ

    Response getById(Long id); // READ

}
