package com.poc.student.services;

import com.poc.student.model.Student;

import java.util.List;

public interface StudentService {
    List<Student> getListStudent();
    Student saveStudent(Student student);

    List<Student> getStudentBySchoolId(Integer schoolId);
}
