<img width="1365" alt="스크린샷 2023-12-21 오후 5 02 38" src="https://github.com/junyong1111/Spring_Project/assets/79856225/70ad2402-1af3-4b10-9d21-e5144fcf1159">


### React 프론트엔드와 REST API 통합



React에서 REST API를 호출하는 방법 : Axios를 이용

- 의존성 추가

npm install axios

- Axios 호출 후 3가지

1. then

성공적인 응답을 받으면 then()안에 메소드를 실행

.then(
    (response) => successfulResponse(response)
)
2. finally

응답 여부에 상관없이 호출

.finally(() => console.log("celanup"))
3. catch

예외적인 응답을 받으면 cath()안에 메소드를 실행

.catch((error) => errorResponse(error))

### 서로다른 웹사이트를 호출하는 방법

localhost:3000(React) 에서 localhost:8080(Spring)으로 호출을 하면 오류가 생긴다. 이는 Cross Origin Requests라 하며 기본값으로는 다른 요청을 거부하게 되어 있다. 따라서 Spring Boot에서 해당 설정을 바꿔서 요청을 허용하도록 해야한다.

Spring Boot CORS 설정 변경

- 메인 웹 애플리케이션 코드에 다음과 같은 코드 추가

public WebMvcConfigurer corsConfigurer(){
    return new WebMvcConfigurer(){
       public void addCorsMappings(CorsRegistry registry) {
          registry.addMapping("/**")
                .allowedMethods("*")
                .allowedOrigins("http://localhost:3000");
       }
    };
 
}
addMapping : 오리진 요청 허용
allowedMethods : 메서드 요청 허용

### formik 라이브러리

npm install formik

npm install moment



원하는 양식 생성

<Formik initialValues={ {description, targetDate} }
                enableReinitialize = {true}
                >
                {
                    (props) => (
                        <Form>
                            <fieldset className="form-group">
                                <label>description</label>
                                <Field type="text" className="form-control" name="description"/>
                            </fieldset>
                            <fieldset className="form-group">
                                <label>TargetDate</label>
                                <Field type="date" className="form-control" name="targetDate"/>
                            </fieldset>
                        </Form>
                    )
                }
                </Formik>

### JOT, JWT, Spring Security를 이용하여 REST API 인증 적용



Spring Security 필터체인 커스터마이징

1. 모든 요청에 인증을 요구하는 기본값으로 변경

http.authorizeHttpRequests(
        auth -> auth.anyRequest().authenticated()
);
2.  http 기본 인증 활성화

http.httpBasic(Customizer.withDefaults());인증을 위한 새로운 인증 팝업 창 생성(로그인 인증 창 생성)

3. 상태가 없는 REST API 생성 후 CSRF 비활성화

CSRF를 비활성화한다면 세션에 상태가 없어야 한다?!

 http.sessionManagement(
                session -> session.sessionCreationPolicy
                        (SessionCreationPolicy.STATELESS));
http.csrf(AbstractHttpConfigurer::disable);

### Spring Scurity로 보호된 백엔드를 프론트엔드와 연결

프론트엔드와 백엔드를 연결해주기 위해서 백엔드 부분을 호출하는 부분에서 기본 인증 헤더를 함께 넘겨줘야 한다.

### 로그인 응답 여부를 기다리고 다음 명령어를 실행하기



async function login(username, password)
async 키워드를 통해 응답 여부를 기다릴 수 있음 이 때 어떤 값을 기다리는지 awit키워드를 통해 알려줘야 함

const response = await executeBasicAuthenticationsService(baToken)
async와 await 키워드는 하나의 세트라고 생각하자.

### REST API에 사용할때 마다 인증을 위한 토큰을 설정하면 불필요한 중복작업이 많아지므로 하나의 API 클라이언트를 만들어 모든 API를 관리!  즉, 공통된 정보를 가진 API를 관리하는 ApiClinet.js파일에서 모든 API토큰을 관리



로그인이 성공하면 apiClinet를 이용하여 인증을 인터셉트하여 모든 api에 인증토큰 사용

apiClinet.interceptors.request.use(
                (config) => {
                    console.log('intercepting and adding a token')
                    config.headers.Authorization=baToken
                    return config
                }
            )

### JOT 또는 JWT 사용하기



- 기본 인증은 토큰에 만료  기한이 없고 사용자 세부정보가 토큰에 저장되지 않는다.

- 또한 Base64를 사용했기 때문에 아주 쉽게 디코딩을 할 수 있다.



위와 같은 문제를 해결하기 위해서 사용자 지정 토큰을 만들고 싶지만 표준이 없다면 모두가 구조를 이해하는데 힘들 수 있다 이러한 문제점들을 해결하기 위해서 나온것이 JWT이다.



JWT(Json Web Token)

토큰을 만드는 표준 토큰 시스템이다.

Header

- type : JWT
- 해싱알고리즘 사용
Payload : JWT의 일부로서 갖고 있길 원하는 속성으로 기본적으로 데이터를 말한다.

기본적으로 정의되어 있는 표준 속성은 아래와 같고 사용자가 추가도 가능하다.

- iss : JWT 토큰을 발행한 이슈어
- sub : 주제
- aud : 목표로 하는 대상
- exp : 만료기간
- iat : 토큰이 언제 생성되었는지
Signature

your-256-bit-secret을 추가하고 토큰이 유효한지 아닌지 확인 가능  등등..

### Spring Security에 JWT를 적용하기

https://github.com/in28minutes/master-spring-and-spring-boot/blob/main/13-full-stack/99-reuse/02-spring-security-jwt.md



의존성 추가

<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-oauth2-resource-server</artifactId>
</dependency>

