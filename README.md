# Comento - 직무부트캠프
## 나만의 포트폴리오 작성으로 웹개발 백엔드 직무 체험하기
### 기간 2021. 10. 31 ~ 2021. 11. 28

## 1차 과제<br>
### 주제 
Spring Framework 프로젝트 생성 후 Github Repository에 Commit 하기<br><br>
[링크](https://github.com/ahn-sj/Comento-board/blob/main/note/W1.md)

## list
1. .gitignore 추가
2. JDBC와 MyBatis 차이
3. 필터(Filter)와 인터셉터(Interceptor)
4. WAS와 Web Server의 차이
5. Spring @Controller의 리턴타입
6. @Component와 @Service, @Controller, @Repository
7. Dispacher-Servlet
<br><br>

---

<br>

## 2차 과제<br>
### 주제 
Spring Framework 프로젝트에 데이터베이스 (DBMS) 연동하기<br><br>
[링크](https://github.com/ahn-sj/Comento-board/blob/main/note/W2.md)
## list
1. 스프링 프로젝트 빌드 과정
2. ApplicationContext
3. 비지니스 로직 (코드와 사용예시)
4. `<dependencies>`
5. System.out.print보다 log가 권장되는 이유
6. 인터페이스의 장점과 쓰는 이유
7. jUnit(@Test)의 역할
8. spring<->mysql과 spring<->oracle접속
9. mapper 사용 이유
10. VO, DTO, DAO, Mapper
11. sqlSessionFactory
12. ns(namespaces)란
13. 커넥션 풀(Connection Pool) 

<br>

## 과제 중 발생 오류 

### 1. MySQL Syntax ERROR
![syntax_error_img](https://user-images.githubusercontent.com/64416833/141064468-92aab3bc-093e-45eb-b4fb-f6a3314cfa31.jpg)

그동안 DBMS를 Oracle로만 사용하다보니 MySQL과 Oracle의 문법 차이로 발생한 구분 오류

기존 쿼리<br>
`select sysdate from dual`
<br><br>
변경 쿼리<br>
`select sysdate()`


<br>

### 2. reflection 경고 메시지

![reflector_error_img](https://user-images.githubusercontent.com/64416833/141064863-ee690be2-8705-4780-8d6b-90a4be9ddab0.jpg)

Mapper Test 중 위와 같은 경고가 발생했는데 발생 이유는 MyBatis 버전 문제로 MyBatis 3.4.6 -> MyBatis 3.5.2로 버전으로 업그레이드 한 후 `maven update...` 후 해결<br><br>
![solved_reflector_img](https://user-images.githubusercontent.com/64416833/141065316-4a70c7ce-263a-4b14-98be-3de68739aad7.jpg)

[참고자료] https://sillutt.tistory.com/m/entry/Mybatis-WARNING-An-illegal-reflective-access-operation-has-occurred

<br>

---

<br>