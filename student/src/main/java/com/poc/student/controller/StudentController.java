package com.poc.student.controller;

import com.poc.student.model.Student;
import com.poc.student.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/student")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @GetMapping
    public ResponseEntity<List<Student>> getAllStudent(){
        return new ResponseEntity<List<Student>>(studentService.getListStudent(), HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<Student> saveStudent(@RequestBody Student student){
        return new ResponseEntity<>(studentService.saveStudent(student),HttpStatus.CREATED);
    }
    @GetMapping("/school/{schoolId}")
    public ResponseEntity<List<Student>> getAllStudentBySchoolId(@PathVariable("schoolId") Integer schoolId){
        return new ResponseEntity<List<Student>>(studentService.getStudentBySchoolId(schoolId), HttpStatus.OK);
    }
}
