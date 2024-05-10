package com.poc.school.controller;

import com.poc.school.model.FullSchoolResponce;
import com.poc.school.model.School;
import com.poc.school.model.Student;
import com.poc.school.services.SchoolService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/school")
public class SchoolController {
    @Autowired
    private SchoolService schoolService;

    @GetMapping
    public ResponseEntity<List<School>> getAllschool(){
        return new ResponseEntity<List<School>>(schoolService.getListSchool(), HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<School> saveschool(@RequestBody School school){
        return new ResponseEntity<>(schoolService.saveSchool(school),HttpStatus.CREATED);
    }
    @GetMapping("/with-student/{schoolid}")
    public ResponseEntity<FullSchoolResponce> getAllschool(@PathVariable(name = "schoolid") Integer schoolid){
        return new ResponseEntity<FullSchoolResponce>(schoolService.getSchoolWithStudent(schoolid), HttpStatus.OK);
    }
    @GetMapping("/allStudentFromSchool")
    public ResponseEntity<List<Student>> listStudent(){
        return new ResponseEntity<>(schoolService.getListStudent(),HttpStatus.OK);
    }
}
