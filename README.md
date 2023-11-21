# 강한결합과 느슨한 결합
컴퓨터 : 공간에 대해 강한 결합  
노트북 : 공간에 대해 느슨한 결합

강한결합을 이용하여 GamingApp을 만들 경우
- Mario Game 이동 로직
- SuperContra Game 이동 로직
- PacMan Game 이동 로직
위 3개의 게임을 총괄하는 GameRunner가 필요하며 이 GameRunner는 각각의 게임에 맞는 실행을 해야한다.
var game = new MarioGame();
if game == MarioGame => 마리오 게임 생성 후 게임 시작
else if game == SuperContra => Super Contra 게임 생성 후 게임 시작
else => Pacman 게임 생성 후 게임 시작

Java 인터페이스를 이용한 느슨한 결합
- Mario Game 이동 로직
- SuperContra Game 이동 로직
- PacMan Game 이동 로직
- GameConsole 인터페이스를 이용하여 공통적인 기능들을 추상화 메서드로
강한결합과 다르게 Gamerunner의 생성자를 GameConsole 하나만 만들면
var game 변수에 어떠한 게임이 들어와도 하나의 로직으로 처리가 가능하다.

# Spring Bean
Spring Bean이란, Spring 프레임워크에서 관리하는 객체이며 여기서 말하는 관리란 객체의 생성, 생명주기, 그리고 그 객체에 대한 요청들을 처리한다는 의미이다.

1. Launch a Spring Context
var context = new AnnotationConfigApplicationConext(2번에서 미리설정한configuration.class);

2. 원하는이름Configuration.java 파일 생성 후 @Configuration 어노테이션을 이용하여 Bean 생성
@Bean
public String name(){
  return "HONG";
}
3. context.getBean("name") 을 통해 전역변수로 설정된 Bean을 확인 할 수 있다!

# 인터페이스와 Bean을 이용하여 GamingApp 생성
- 3개의 게임 클래스 
- 3개의 게임의 느슨한결합을 위한 인터페이스
- 게임 시작을 위한 Gamerunner 클래스

Console과 Gamerunner 클래스를 Bean을 이용하여 관리