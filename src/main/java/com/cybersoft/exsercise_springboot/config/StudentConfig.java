package com.cybersoft.exsercise_springboot.config;

import com.cybersoft.exsercise_springboot.models.ListStudentModel;
import com.cybersoft.exsercise_springboot.service.Student;
import com.cybersoft.exsercise_springboot.service.StudentService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class StudentConfig {
    @Bean
    public ListStudentModel listStudentModel() {
        return new ListStudentModel();
    }

    @Bean
    public StudentService studentService(ListStudentModel listStudentModel) {
        return new Student(listStudentModel);
    }
}
