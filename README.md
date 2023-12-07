TODO 애플리케이션 제작

<img width="1204" alt="스크린샷 2023-12-07 오후 4 28 38" src="https://github.com/junyong1111/Bigdata/assets/79856225/d7cb243f-a074-40bc-9f60-d68599abd5bf">


## JSP를 위해서는 다음 의존성을 추가
implementation "org.apache.tomcat.embed:tomcat-embed-jasper"

## JSP
JSP (Java Server Pages)

Java에서 View를 다룰 수 있도록 도와줌

1. src/main/resources 경로에  META-INF/resources/WEB-INF/jsp/hello.jsp 파일 생성

2. application.properties에 다음 코드 입력

spring.mvc.view.prefix=/WEB-INF/jsp/

spring.mvc.view.suffix=.jsp

logging.level.org.springframework=debug



Client(파라미터) -> 컨트롤러 -> JSP로 전달 하는 방법  = MODEL

ModelMap

ModelMap model을 파라미터로 사용

model.put("jsp에 대체될 값", 파라메터로 받은값)

JSP : ${name}로 표시된 값에 파라메터로 받은 값을 대체한다.


## 로깅(디버그 하는 방법) -> Starte-web에 포함되어 있는 기능(SLF4j)
```java
- private Logger logger = LoggerFactory.getLogger(this.getClass());

logget.debug("디버그 단계에서 프린트");

logget.info("인포 단계에서 프린트");

logget.warn("경고 단계에서 프린트");



application.properties에

logging.level.자신이 디버그하고 싶은 패키지 = 디버그수준

ex)1. 전체를 디버그 하고 싶은경우

logging.level.org.springframework=debug

ex)2. 특정 패키지만 디버그 하고 싶은경우

logging.level.com.myProject.myPackage = debug
```


## jstl 의존성

```java
implementation 'jakarta.servlet:jakarta.servlet-api' //스프링부트 3.0 이상 
implementation 'jakarta.servlet.jsp.jstl:jakarta.servlet.jsp.jstl-api' //스프링부트 3.0 이상
implementation 'org.glassfish.web:jakarta.servlet.jsp.jstl' //스프링부트 3.0 이상
```


## 요청에 있는 모든 값들은 오직 그 요청에 대해서만 유효하다(그 다음에는 전혀 사용 X)

ex) Username을 요청받고 그 값을 넣었을 경우 다른 페이지 요청을 하면 Username에 대한 정보는 사라진다.

이를 방지하기 위해서 이 정보를 세션에 넣어야 한다.

@SeesionAtrributes를 이용

ex)  @SeesionAtrributes("Username")

#-- 해당 세션값을 사용하려는 모든 컨트롤러에 넣어줘야 함!

## JSTL

https://docs.oracle.com/javaee/5/jstl/1.1/docs/tlddocs/c/tld-summary.html

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:forEach items="${todos}" var ="todo> </c:forEach>

## CSS캐스케이딩(부트스트랩)

webjars를 이용하여 자동으로 부트스트랩 연동

#-- https://mvnrepository.com/artifact/org.webjars/bootstrap

implementation group: 'org.webjars', name: 'bootstrap', version: '5.1.3'

implementation group: 'org.webjars.bower', name: 'jquery', version: '3.6.0'

- bootstrap.min.css (webjars/bootstrap/5.1.3/css/bootstrap.min.css)

- bootstrap.min.js (webjars/bootstrap/5.1.3/js/bootstrap.min.js)

- jquery.min.js (webjars/jquery/3.6.0/dist/jquery.min.js)



CSS 링크는 헤드 밑

<head>

    <link href ="" rel="stylesheet"> #-- css 파일 경로



자바스크립트와 JQuery 링크는 바디 종료태그 바로 위

    <script src=""><script> #-- Js

    <script src=""><script> 3-- Jqeury

</body>

## 부트스트랩

- class = "container" : 가운데 정렬(페이지 본문 전체)

ex)

<body>

    <div class="containe">

        페이지 본문 전체

    </div>

</body>

- class = "table" : 표를 더 깔끔하게

- class = "btn btn-success : 버튼 클릭 생성

### Spring Security

로그인과 로그아웃에 관련된 기능을 쉽게 구현할 수 있음



로그인 구현

Spring Security 의존성 추가

implementation 'org.springframework.boot:spring-boot-starter-security'

의존성을 추가하는것만으로 자동으로 로그인 페이지로 넘어가진다.

개발자 전용 id : user pw : 디버깅 창에서 나오는 패스워드

### JPA를 이용하여 Todo 엔티티 연걸하기(H2 -> MySQL)



runtimeOnly 'com.h2database:h2'
implementation 'org.springframework.boot:spring-boot-starter-data-jpa'
spring.datasource.url=jdbc:h2:mem:myDb


Spring Security에 H2 데이터베이스 설정

- 모든 URL은 Security에 의해 보호되며 승인되지 않은 요청에 대해서는 로그인 양식이 표신된다.

SecurityFilterChain을 이용하여 허용범위를 설정해줘야 한다.

@Bean
public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
    http.authorizeHttpRequests( // 모든 요청 승인
            auth -> auth.anyRequest().authenticated()
    );
    http.formLogin(withDefaults()); // 승인되지 않은 요청은 로그인
    http.csrf().disable(); // crsf 비활성화
    http.headers().frameOptions().disable(); // 애플리케이션 프레임 비활성화
    return http.build();

### TODO 클래스를 JPA로 제어

- @Entity 어노테이션을 이용 Spring Boot는 엔티티 어노테이션을 발견하면 바로 테이블을 생성한다.!!!

- src/main/resources에서 data.sql 파일 생성

insert into todo(ID, USERNAME, DESCRIPTION, TARGET_DATE, DONE)
values(1001, 'Park',  'Learn AWS Certified', CURRENT_DATE(), false);
 
insert into todo(ID, USERNAME, DESCRIPTION, TARGET_DATE, DONE)
values(1002, 'Park',  'Learn Azure Certified', CURRENT_DATE(), false);
 
insert into todo(ID, USERNAME, DESCRIPTION, TARGET_DATE, DONE)
values(1003, 'Park',  'Learn GCP Certified', CURRENT_DATE(), false);
 
insert into todo(ID, USERNAME, DESCRIPTION, TARGET_DATE, DONE)
values(1004, 'Park',  'Learn DevOps', CURRENT_DATE(), false);
data.sql -> 엔티티 생성  순서이므로 순서를 바꿔줘야 함

spring.jpa.defer-datasource-initialization=true

### TODO 추가, 삭제, 검색 등 모든 종류의 작업을 하기 위한 Spring Data JPA Repository 사용



public interface TodoRepository extends JpaRepository<Todo, Integer> {
}
READ

public List<Todo> findByUsername(String username); // Todo Bean에 정의된 username으로 이름 찾기(컬렉션 형태로 반환)
Create

todoRepository.save(todo); // 해당 객체를 바로 저장
DELETE

todoRepository.deleteById(id); // id를 이용하여 삭제
UPDATE

Todo todo = todoRepository.findById(id).get();

### 인메모리 데이터베이스는 서버 재시작시 정보가 휘발되므로 MySQL로 데이터베이스 변경

Docker를 사용해 MySQL 실행하기
docker run --detach --env MYSQL_ROOT_PASSWORD=dummypassword --env MYSQL_USER=todos-user --env MYSQL_PASSWORD=dummytodos --env MYSQL_DATABASE=todos --name mysql --publish 3306:3306 mysql:8-oracle
application.properties
spring.datasource.url=jdbc:mysql://localhost:3306/todos
spring.datasource.username=todos-user
spring.datasource.password=dummytodos
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL8Dialect
spring.jpa.hibernate.ddl-auto=update