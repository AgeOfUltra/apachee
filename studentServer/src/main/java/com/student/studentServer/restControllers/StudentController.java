package com.student.studentServer.restControllers;

import com.student.studentServer.dao.StudentRepo;
import com.student.studentServer.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {
    @Autowired
    StudentRepo repo;

    @GetMapping(value = "/student",produces = {"application/JSON"})
    public List<Student> getStudents(){
        return repo.findAll();
    }
    @GetMapping(value = "/student/{id}")
    public ResponseEntity<Student> getStudent(@PathVariable int id){
        Student student = repo.findById(id).orElse(new Student());
        return new ResponseEntity<>(student, HttpStatus.OK);
    }
    @PostMapping("/saveStudent")
    public ResponseEntity<Student> createStudent(@RequestBody Student student){
        Student newStudent = repo.save(student);
        return new ResponseEntity<>(newStudent, HttpStatus.CREATED);
    }

}
