package com.poc.school.services;

import com.poc.school.model.FullSchoolResponce;
import com.poc.school.model.School;
import com.poc.school.model.Student;

import java.util.List;

public interface SchoolService {
    List<School> getListSchool();
    School saveSchool(School school);

   FullSchoolResponce getSchoolWithStudent(Integer schoolid);

    List<Student> getListStudent();
}
