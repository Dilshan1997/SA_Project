package com.SAProject.SAProject.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

//API Layer
@RestController
@RequestMapping(path = "api/student")
public class StudentController {

    private final StudentService studentservice;

    @Autowired
    public StudentController(StudentService studentservice) {
        this.studentservice = studentservice;
    }

    @GetMapping
    public List<Student> getStudents(){
        return studentservice.getStudents();
    }

    @PostMapping
    public void registerNewStudent(@RequestBody  Student student){
        studentservice.addNewStudent(student);
        }

    @DeleteMapping(path="{studentId}")
    public void deleteStudent(@PathVariable("studentId") Long studentId){
        studentservice.deleteStudent(studentId);
    }

    @PutMapping(path="{studentId}")
    public void updateStudent(@PathVariable("studentId") Long studentId,
                              @RequestParam(required = false) String name,
                              @RequestParam(required = false) String email,
                              @RequestParam(required = false) LocalDate bod){
        studentservice.updateStudent(studentId, name, email, bod);
    }

}



