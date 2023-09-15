package com.SAProject.SAProject.student;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }
    public List<Student> getStudents(){
        return studentRepository.findAll();
    }


    public void addNewStudent(Student student) {

        Optional<Student> studentEmail= studentRepository
                .findStudentByEmail(student.getEmail());

        if(studentEmail.isPresent()){
            throw new IllegalStateException("email taken");
        }
        studentRepository.save(student);
    }

    public void deleteStudent(Long studentId) {
        studentRepository.findById(studentId);
        boolean exists=studentRepository.existsById(studentId);

        if(!exists){
            throw new IllegalStateException(
                    "studnet id "+ studentId + "does not exists"
            );
        }

        studentRepository.deleteById(studentId);
    }

    @Transactional
    public void updateStudent(Long studentId,
                              String name,
                              String email,
                              LocalDate bod) {


        Student student=studentRepository.findById(studentId)
                .orElseThrow(()->new IllegalStateException(
                        "studnet with id " + studentId + " does not exist"
                ));

        if(name != null &&
        !Objects.equals(student.getName(), name)){
            student.setName(name);
        }

        if(email!=null &&
                email.length()>0 &&
                !Objects.equals(student.getEmail(),email)){
                Optional<Student> studentEmail = studentRepository.findStudentByEmail(email);
                if(studentEmail.isPresent()){
                    throw new IllegalStateException("email taken");
                }
                }
                student.setEmail(email);



    }
}
