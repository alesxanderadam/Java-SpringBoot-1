package com.cybersoft.exsercise_springboot.controllers;

import com.cybersoft.exsercise_springboot.models.ListStudentModel;
import com.cybersoft.exsercise_springboot.models.StudentModel;
import com.cybersoft.exsercise_springboot.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/student")
public class StudentController {
    private final StudentService studentService;
    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }
    @GetMapping("")
    public ResponseEntity<?> getAllStudents(){
       ListStudentModel listStudentModel = studentService.getAllStudents();
       return new ResponseEntity<>(listStudentModel,HttpStatus.OK);
    }
//    1. Write a method to add a student using query @RequestParam
//    @PostMapping("/add")
//    public ResponseEntity<ListStudentModel> addStudent(@RequestParam String name, @RequestParam int age){
//        studentService.addStudent(name, age);
//        ListStudentModel listStudentModel = studentService.getAllStudents();
//        return new ResponseEntity<>(listStudentModel, HttpStatus.OK);
//    }


//    2. Write a method to add a student using query @RequestParam
//    @PostMapping("/add/{name}/{age}")
//    public ResponseEntity<ListStudentModel> addStudent(@PathVariable String name, @PathVariable int age){
//        studentService.addStudent(name, age);
//        ListStudentModel listStudentModel = studentService.getAllStudents();
//        return new ResponseEntity<>(listStudentModel, HttpStatus.OK);
//    }

//  3. Write a method to add a student using query @RequestBody
    @PostMapping("/add")
    public ResponseEntity<?> addStudent(@RequestBody StudentModel studentModel){
        try{
            if(validateStudentData(studentModel.getName(), studentModel.getAge())){
                studentService.addStudent(studentModel.getName(), studentModel.getAge());
                ListStudentModel listStudentModel = studentService.getAllStudents();
                return new ResponseEntity<>(listStudentModel, HttpStatus.OK);
            }else{
                return new ResponseEntity<>("Dữ liệu học sinh không hợp lệ!", HttpStatus.BAD_REQUEST);
            }
        }catch (Exception error){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }


    }
    private boolean validateStudentData(String name, int age) {
        if (name == null || name.isEmpty()) {
            return false;
        }

        if (age <= 0) {
            return false;
        }

        return true;
    }
}
