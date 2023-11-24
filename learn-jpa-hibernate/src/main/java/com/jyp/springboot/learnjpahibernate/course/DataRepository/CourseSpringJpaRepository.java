package com.jyp.springboot.learnjpahibernate.course.DataRepository;

import com.jyp.springboot.learnjpahibernate.course.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseSpringJpaRepository extends JpaRepository<Course, Long> {

}
