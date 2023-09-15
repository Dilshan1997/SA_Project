package com.SAProject.SAProject.student;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.Period;

@Entity
@Table
public class Student {

    @Id
    @SequenceGenerator(
            name="student_sequence",
            sequenceName="student_sequence",
            allocationSize = 1
    )

    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "student_sequence"
    )
    private Long id;
    private String name;
    private String email;
    private LocalDate bod;

    @Transient
    private Integer age;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public LocalDate getBod() {
        return bod;
    }

    public void setBod(LocalDate bod) {
        this.bod = bod;
    }

    public Integer getAge() {
        return Period.between(this.bod, LocalDate.now()).getYears();
    }

    public void setAge(Integer age) {
        this.age = age;
    }


    public Student(Long id,
                   String name,
                   String email,
                   LocalDate bod) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.bod = bod;
    }

    public Student(String name,
                   String email,
                   LocalDate bod) {
        this.name = name;
        this.email = email;
        this.bod = bod;
    }

    public Student() {

    }


}
