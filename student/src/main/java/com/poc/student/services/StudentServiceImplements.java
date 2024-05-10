package com.poc.student.services;

import com.poc.student.model.Student;
import com.poc.student.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImplements implements StudentService{
    @Autowired
    private StudentRepository studentRepository;
    @Override
    public List<Student> getListStudent() {
        return studentRepository.findAll();
    }

    @Override
    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public List<Student> getStudentBySchoolId(Integer schoolId) {
        return studentRepository.findAllBySchoolId(schoolId);
    }
}
