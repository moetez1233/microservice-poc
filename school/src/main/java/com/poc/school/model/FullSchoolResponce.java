package com.poc.school.model;

import lombok.Data;

import java.util.List;

@Data
public class FullSchoolResponce {
    private String name;
    private String email;
    List<Student> studentList;
}
