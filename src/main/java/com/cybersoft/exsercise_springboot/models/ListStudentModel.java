package com.cybersoft.exsercise_springboot.models;

import java.util.List;

public class ListStudentModel {
    private List<StudentModel> students;

    public List<StudentModel> getStudents() {
        return students;
    }

    public void setStudents(List<StudentModel> students) {
        this.students = students;
    }
}
