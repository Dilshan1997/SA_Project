package com.SAProject.SAProject.student;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class StudentConfig {

    @Bean
    CommandLineRunner commandLineRunner(StudentRepository repository){
        return args -> {
            Student lal = new Student(
                    "Lal",
                    "maram.jamal@gmail.com",
                    LocalDate.of(2000, Month.JANUARY,10)

            );

            Student al = new Student(
                    "Al",
                    "maram.jamal@gmail.com",
                    LocalDate.of(2002, Month.JANUARY,10)

            );
            repository.saveAll(
                    List.of(lal,al)

            );
        };


    }
}
