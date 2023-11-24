package com.jyp.springboot.learnjpahibernate.course.DataRepository;

import com.jyp.springboot.learnjpahibernate.course.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CourseCommandLineRunner implements CommandLineRunner {

//    @Autowired
//    private final SpringJdbcRepository repository;
//    @Autowired
//    private final CourseJPARepository repository;
    @Autowired
    private CourseSpringJpaRepository repository;

    @Override
    public void run(String... args) throws Exception {
        repository.save(new Course(1, "Learn JAVA !!", "PARK"));
        repository.save(new Course(2, "Learn SPRING BOOT!!", "PARK"));
        repository.save(new Course(3, "Learn SPRING BOOT JPA!!", "PARK"));
        repository.deleteById(1l);

        System.out.println(repository.findById(2l));
        System.out.println(repository.findById(3l));
    }

}
