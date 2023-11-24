package com.jyp.springboot.learnjpahibernate.course.DataRepository;

import com.jyp.springboot.learnjpahibernate.course.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;


@Repository
public class SpringJdbcRepository {
    @Autowired
    private JdbcTemplate springJdbcTemplate;
    // 쿼리 실행
    private static String INSERT_QUERY =
            """
                insert into course (id, name, author)
                values (?, ?, ?);        
            """;
    public void insert(Course course){
        springJdbcTemplate.update(INSERT_QUERY,
                course.getId(), course.getName(), course.getAuthor());
    }
}
