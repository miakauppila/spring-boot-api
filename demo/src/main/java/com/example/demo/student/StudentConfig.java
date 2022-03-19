package com.example.demo.student;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class StudentConfig {

    @Bean
    CommandLineRunner commandLineRunner(StudentRepository repository) {
        return args -> {
            Student marian = new Student(
                    "Marian",
                    "marian.kaivo@gmail.com",
                    LocalDate.of(2000, Month.MARCH, 5),
                    22);

            Student alex = new Student(
                    "Alex",
                    "alex.loppi@gmail.com",
                    LocalDate.of(2004, Month.APRIL, 15),
                    22);
            
                    repository.saveAll(List.of(marian, alex));

        };
    }

}
