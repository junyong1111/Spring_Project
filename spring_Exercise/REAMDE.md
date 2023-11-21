### 의존성 주입을 이용하여 해당 서비스 구현
<img width="1568" alt="스크린샷 2023-11-21 오후 10 52 03" src="https://github.com/junyong1111/Spring_Project/assets/79856225/491942e1-d29e-49eb-aa84-340d6d2f2d2a">

### DataLayer Interface
- MongoDB 와 MySQL 데이터를 가져오는 공통 메서드를 가진 DataService 인터페이스 구현
- Primary 어노테이션을 이용하여 우선권 부여

### DataLayer Class
- MongoDbDataService 클래스
    - Interface를 상속받아 특정 데이터 반환

- MySQLDbDataService 클래스
    - Interface를 상속받아 특정 데이터 반환

### BusinessLayer Class
- BusinessCalculationService 클래스
    - DataService 인터페이스를 의존하여 해당 데이터 중 가장 Max값을 반환하는 메서드 실행


### Component, Autowired, Primary 등을 이용하여 해당 로직이 돌아갈 수 있게 의존성을 주입하는 코드를 작성

### 파일 구조
```bash
WEB  
Business
 - BusinessCalculationService.java
Data
- MongoDbDataService.java
- MySQLDataService.java

RealWorldService.java
```
