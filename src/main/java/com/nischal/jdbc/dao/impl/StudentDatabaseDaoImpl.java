package com.nischal.jdbc.dao.impl;

import com.nischal.jdbc.dao.StudentDao;
import com.nischal.jdbc.entity.Student;
import com.nischal.jdbc.util.DateUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StudentDatabaseDaoImpl implements StudentDao {
    @Override
    public boolean save(Student s) throws Exception {

        Connection conn = null;
        PreparedStatement statement = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/JDBC_DEMO", "root", "java");
            statement = conn.prepareStatement("INSERT into students(NAME, ADDRESS, DOB, CONTACT_NO) values(?,?,?,?) ");
            statement.setString(1, s.getName());
            statement.setString(2, s.getAddress());
            statement.setDate(3, DateUtil.convertToSqlDate(s.getDob()));
            statement.setString(4, s.getContactNo());

            int rowsAffected = statement.executeUpdate();
            if (rowsAffected < 1) {
                throw new RuntimeException("could not save student");
            } else {
                return true;
            }
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        } finally {
            conn.close();
            statement.close();
        }
    }


    @Override
    public boolean update(Student s) throws Exception {

        Connection conn = null;
        PreparedStatement statement = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/JDBC_DEMO", "root", "java");

            String sql = "update students set {{params}} where id=?";

            StringBuilder parameter = new StringBuilder();
            String template = "%s=?";

            Map<String, Object> params = new HashMap<>();
            int index = 1;

            if (s.getName() != null) {
                params.put("NAME", s.getName());
            }

            if (s.getDob() != null) {
                params.put("DOB", s.getDob());
            }

            if (s.getAddress() != null) {
                params.put("ADDRESS", s.getAddress());
            }

            if (s.getContactNo() != null) {
                params.put("CONTACT_NO", s.getContactNo());
            }

            int size = params.size();
            int tracker = 0;

            for (Map.Entry<String, Object> entry : params.entrySet()) {

                parameter.append(String.format(template, entry.getKey()));

                if (size > 1 && tracker + 1 != size) {
                    parameter.append(",");
                }
                tracker++;
            }

            if (parameter.toString().isEmpty()) {

                throw new RuntimeException("please give the parameters to update");
            }

            sql = sql.replace("{{params}}", parameter);
            statement = conn.prepareStatement(sql);

            for (Map.Entry<String, Object> entry : params.entrySet()) {
                statement.setObject(index++, entry.getValue());
            }

            statement.setLong(index++, s.getId());

            int rowsAffected = statement.executeUpdate();
            if (rowsAffected < 1) {
                throw new RuntimeException("could not save student");
            } else {
                return true;
            }
        } finally {
            conn.close();
            statement.close();
        }
    }

    @Override
    public boolean delete(long id) throws Exception {

        Connection conn = null;
        PreparedStatement statement = null;

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/JDBC_DEMO", "root", "java");
            statement = conn.prepareStatement("delete from students where ID = ?");
            statement.setLong(1, id);
            int rowAffected = statement.executeUpdate();

            if (rowAffected > 0) {
                return true;
            } else {
                throw new RuntimeException("deleting failed");
            }
        } finally {
            conn.close();
            statement.close();
        }
    }

    @Override
    public List<Student> getAll() throws Exception {

        Connection conn = null;
        Statement statement = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/JDBC_DEMO", "root", "java");
            statement = conn.createStatement();
            ResultSet rs = statement.executeQuery("select * from students");

            List<Student> students = new ArrayList<>();
            while (rs.next()) {
                students.add(Student.builder().id(rs.getLong("ID")).name(rs.getString("NAME")).
                        address(rs.getString("ADDRESS")).dob(rs.getDate("DOB")).contactNo(rs
                                .getString("CONTACT_NO")).createdDate(rs.getDate("CREATED_DATE"))
                        .status(rs.getBoolean("STATUS")).build());
            }

            if (!students.isEmpty()) {

                return students;
            } else {
                throw new RuntimeException("there are no students");
            }
        } finally {
            conn.close();
            statement.close();
        }


    }

    @Override
    public Student getById(long id) throws Exception {

        Connection conn = null;
        PreparedStatement statement = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/JDBC_DEMO", "root", "java");
            statement = conn.prepareStatement("select * from students where ID = ?");
            statement.setLong(1, id);

            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                return Student.builder().id(rs.getLong("ID")).name(rs.getString("NAME")).
                        address(rs.getString("ADDRESS")).dob(rs.getDate("DOB")).contactNo(rs
                                .getString("CONTACT_NO")).createdDate(rs.getDate("CREATED_DATE"))
                        .status(rs.getBoolean("STATUS")).build();
            }
            throw new RuntimeException("there is no student with id" + id);
        } finally {
            conn.close();
            statement.close();
        }
    }
}
