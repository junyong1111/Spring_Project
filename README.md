<img width="1332" alt="스크린샷 2023-12-11 오후 4 25 56" src="https://github.com/junyong1111/Spring_Project/assets/79856225/5d44379f-ca4b-492c-9c05-cf20663a2e54">


# 필요 API 리스트 

## USER REST API

GET /users : 모든 유저 검색

POST / users : 유저 생성

GET /users/{id} : 특정 유정 검색

DELETE /users{id} : 특정 유저 삭제



## POST REST API

GET /users/{id}/posts : 특정 유저의 모든 게시물

POST / users/{id}/posts : 게시물 생성

GET /users/{id}/posts/{pots_id} : 특정 유정의 특정 게시물 검색

DELETE /users/{id}/posts/{pots_id}: 특정 게시물 삭제



### Spring Boot로  SNS 프로젝트  REST API 빌드하기

@Controller => View를 반환(jsp)

@RestController 어노테이션을 이용하면 REST API 가능!

- 사용자

    - id, name, birtdata

- 게시물

    - id, description

GET  : 상세 정보를 검색할 때

POST : 새 리소스를 생성할 때

PUT : 리소스를 업데이트 할 때

PATCH : 리소스의 일부부만 업데이트 할 때

DELETE : 리소스를 삭제할 때

### 1. 의존성 추가
implementation 'org.springframework.boot:spring-boot-starter-validation'
2. 검증 설정
post 요청으로 들어온 데이터에 검증 설정

public ResponseEntity<User> createUser(@Valid @RequestBody User user){
user 클래스에서 검증 조건 설정

public class User {
    private Integer Id;
    @Size(min=2, message = "Name Should have least 2 characters")
    private String name;
    @Past(message = "Birth Date Should be in the past")
    private LocalDate birthDate;
}
3. 예외처리
@Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(
            MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
            ErrorDetails errorDetails = new ErrorDetails(
                    LocalDateTime.now(),
                    ex.getFieldError().getDefaultMessage(),
                    request.getDescription(false)
            );
        return new ResponseEntity<>(errorDetails, HttpStatus.BAD_REQUEST);
    }