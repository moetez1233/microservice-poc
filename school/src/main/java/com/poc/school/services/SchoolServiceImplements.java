package com.poc.school.services;

import com.poc.school.client.StudentClient;
import com.poc.school.model.FullSchoolResponce;
import com.poc.school.model.School;
import com.poc.school.model.Student;
import com.poc.school.repositories.SchoolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SchoolServiceImplements implements SchoolService {
    @Autowired
    private SchoolRepository schoolRepository;
    @Autowired
    private StudentClient studentClient;

    @Override
    public List<School> getListSchool() {
        return schoolRepository.findAll();
    }

    @Override
    public School saveSchool(School School) {
        School schoolSaved=schoolRepository.save(School);
        return schoolSaved;
    }

    @Override
    public FullSchoolResponce getSchoolWithStudent(Integer schoolid) {
        FullSchoolResponce fullSchoolResponce=new FullSchoolResponce();
        var school = schoolRepository.findById(schoolid);
        var students = studentClient.findAllStudentBySchoolId(schoolid);
        if(school.isPresent()){
            fullSchoolResponce.setName(school.get().getName());
            fullSchoolResponce.setEmail(school.get().getEmail());
            fullSchoolResponce.setStudentList(students);
        }
        return fullSchoolResponce;
    }

    @Override
    public List<Student> getListStudent() {
        return studentClient.getAllStudent();
    }
}
