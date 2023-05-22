package com.cybersoft.exsercise_springboot.service;

import com.cybersoft.exsercise_springboot.models.ListStudentModel;

public interface StudentService {
    ListStudentModel getAllStudents();
    void addStudent(String name, int age);
}
