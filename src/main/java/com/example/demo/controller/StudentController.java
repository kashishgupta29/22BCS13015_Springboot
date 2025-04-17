package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Student;
import com.example.demo.repository.StudentRepository;

@RestController
@RequestMapping("/student")
public class StudentController {
    @Autowired
    StudentRepository repos;

    @PostMapping("/add")
    public ResponseEntity<Student> createStudent(@RequestBody Student student){
        Student newStudent = repos.save(student);

        return ResponseEntity.status(HttpStatus.CREATED).body(newStudent);
    }

    @GetMapping("/fetch")
    public ResponseEntity<List<Student>> getStudents(){
        List<Student> students = repos.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(students);
    }

    @DeleteMapping("/deleteById/{id}")
    public ResponseEntity<Student> deleteStudentById(@PathVariable Integer id) {
        repos.deleteById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Student> updateStudent(@RequestBody Student student, @PathVariable Integer id){
        Student oldStudent = repos.findById(id).get();
        oldStudent.setName(student.getName());
        oldStudent.setCoursefee(student.getCoursefee());
        oldStudent.setSemester(student.getSemester());
        repos.save(oldStudent);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(oldStudent);
    }

}
