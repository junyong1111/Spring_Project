TODO 애플리케이션 제작

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