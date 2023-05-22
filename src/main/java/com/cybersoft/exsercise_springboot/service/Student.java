package com.cybersoft.exsercise_springboot.service;

import com.cybersoft.exsercise_springboot.models.ListStudentModel;
import com.cybersoft.exsercise_springboot.models.StudentModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class Student implements StudentService {
    private final ListStudentModel listStudentModel;

    @Autowired
    public Student(ListStudentModel listStudentModel) {
        this.listStudentModel = listStudentModel;
    }
    @Override
    public ListStudentModel getAllStudents() {
        return listStudentModel;
    }

    @Override
    public void addStudent(String name, int age) {
        StudentModel studentModel = new StudentModel();
        studentModel.setName(name);
        studentModel.setAge(age);

        if (listStudentModel.getStudents() == null) {
            listStudentModel.setStudents(new ArrayList<>());
        }
        listStudentModel.getStudents().add(studentModel);
    }
}
