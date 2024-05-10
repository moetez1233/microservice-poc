package com.poc.student.repositories;

import com.poc.student.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student,Integer> {
    List<Student> findAllBySchoolId(Integer schoolId);
}
