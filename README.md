https://jypark1111.tistory.com/185

# JPA VS JDBC
## JPA 
- Spring Data JPA
- JPA

## JDBC
- Spring JDBC
- JDBC

## 비교 순서
1. H2를 인메모리 데이터베이스로 사용해서 Spring Boot 프로젝트 생성

2. Spring JDBC를 이용하여 H2 Database에서 데이터 가져오기

3. JPA와 Hibernate를 이용하여 H2 Database에서 데이터 가져오기

4. Spring Data JPA를 이용하여 H2 Database에서 데이터 가져오기

### 1. H2를 인메모리 데이터베이스로 사용해서 Spring Boot 프로젝트 생성

Dependencies

- Spring Web

- Spring Data JDBC

- Spring Data JPA

- H2 Database

H2 데이터베이스 연동

- application.properties에 spring.h2.console.enabled=True 입력

- application.properties에 spring.datasource.url = jdbc:h2:mem:"원하는이름"

- 서버 재시동 후 localhost:8080/h2-console 접속

- JDBC URL 입력칸에 jdbc:h2:mem:"원하는이름"을 입력

H2 데이터베이스 테이블 생성

- src/main/resources 경로에 schema.sql 이름의 SQL파일 생성

create table course
(
  id bigint not null,
  name varchar(255) not null,
  author varchar(255) not null,
  primary key (id)
); 
- 서버 재시작 이후 h2 콘솔에서 해당 테이블 확인

### 2. Spring JDBC를 이용하여 H2 Database에서 데이터 가져오기

- JDBC와 Spring JDBC를 이용한 코드 비교

JDBC
```java
public void deleteTodo(int id){
    PrepareStatement st = null;
    try{
        st = db.conn.prepareStatement("delete from todo where id=?");
        st.setInt(1, id);
        st.execute();
    } catch (SQLException e){
        logger.fatal("Query Failed :, e");
    } finaaly {
        if (st != null){
            try{st.close();}
            catch (SQLException e){}
        }
    }
}
```


Spring JDBC

```java
public void deleteTodo(int id){
    jdbcTemplete.update("delete from todo where id=?", id);
}
```

동일하게 쿼리문은 작성하지만 jdbc템플릿을 이용한 Spring JDBC의 코드가 훨씬 간결하다.

### #-- 애플리케이션 시작 단계에서 해당 쿼리를 실행하는 방법

CommandLineLunner를 이용

- CoursejdbcCommanLineRunner.java 파일을 생성 후 CommandLineRunner 인터페이스 상속

- run() 메서드 오버라이드
```java
package com.jyp.springboot.learnjpahibernate.DataRepository;
 
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
 
@Component
public class CourseJdbcCommanLineRunner implements CommandLineRunner {
 
    private SpringJdbcRepository repository;
    @Override
    public void run(String... args) throws Exception {
        repository.insert();
    }
}
```

### 3. JPA와 Hibernate를 이용하여 H2 Database에서 데이터 가져오기

- @Entity 어노테이션을 이용하여 테이블 매핑

- EntityManager를 이용하여 Entity 관리

- @PersistenceContext 어노테이션을 이용하여 의존성 주입(Autowired)

```java
public void insert(Course course){
    entityManager.merge(course);
}
 
public Course findById(long id){
    return entityManager.find(Course.class, id);
}
public void deleteById(long id){
    Course course = entityManager.find(Course.class, id);
    entityManager.remove(course);
}
```

JPA로 쿼리를 실행하려고 할 때마다 트랜잭션을 허용해야 함

- @Transactional 이용

### 4. Spring Data JPA를 이용하여 H2 Database에서 데이터 가져오기

- Spring Data JPA를 이용할 때는 인터페이스를 활용

```java
public interface CourseSpringJpaRepository extends JpaRepository<Course, Long> {
 
}
```

JpaRepository를 상속받는다 이 때 <엔티티, 해당엔티티ID 필드>를 넣어줘야 한다.

