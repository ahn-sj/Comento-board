# Comento - 직무부트캠프
## 나만의 포트폴리오 작성으로 웹개발 백엔드 직무 체험하기
### 기간 2021. 10. 31 ~ 2021. 11. 28

## 개발환경
```
java version : 1.8
IDE : STS 3.9.14 (Spring Tool Suite)
Apache Tomcat 9.0.53
Spring version : 5.0.7
```

<br>

---

<br>

## 1차 과제<br>
### 주제 
### Spring Framework 프로젝트 생성 후 Github Repository에 Commit 하기<br><br>
[링크](https://github.com/ahn-sj/Comento-board/blob/main/note/W1.md)

## list
1. ~~.gitignore 추가~~
2. ~~JDBC와 MyBatis 차이~~
3. ~~필터(Filter)와 인터셉터(Interceptor)~~
4. ~~WAS와 Web Server의 차이~~
5. Spring @Controller의 리턴타입
6. @Component와 @Service, @Controller, @Repository
7. Dispacher-Servlet
<br><br>

---

<br>

## 2차 과제<br>
### 주제 
### Spring Framework 프로젝트에 데이터베이스 (DBMS) 연동하기<br><br>
[링크](https://github.com/ahn-sj/Comento-board/blob/main/note/W2.md)
## list
1. ~~스프링 프로젝트 빌드 과정~~
2. ApplicationContext
3. ~~비지니스 로직 (코드와 사용예시)~~
4. `<dependencies>`
5. ~~System.out.print보다 log가 권장되는 이유~~
6. 인터페이스의 장점과 쓰는 이유
7. jUnit(@Test)의 역할
8. spring<->mysql과 spring<->oracle접속
9. ~~DAO, DTO, VO의 정의와 코드로 보는 DAO와 DTO의 차이~~
10. ~~MyBatis - DAO(interface and class implements interface)와 Mapper(interface)~~
11. ~~Controller, Service, DAO, Mapper의 데이터 흐름 - 1 (이론편)~~
12. ~~Controller, Service, DAO, Mapper의 데이터 흐름 - 2 (코드편)~~
13. sqlSessionFactory
14. ns(namespaces)란
15. 커넥션 풀(Connection Pool) 

<br>

---

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

## 2차 피드백
<br>

`src/main/java/com/cmento/sample`에 생성한 `'...Tests'`테스트 클래스들을 `/src/test/java/...`의 위치로 이동 - **(완료)**

![feedback1](https://user-images.githubusercontent.com/64416833/141832590-3b12b977-e912-4c44-bbfd-bec4dd8f6d4b.jpg)

<br>

![feedback2](https://user-images.githubusercontent.com/64416833/141832596-c1e5ef18-597c-4cbf-bafe-fa1e5423fa1a.jpg)

<br>

---

<br>

## 3차 과제
### 주제 
### Spring Framework 프로젝트에 게시판 구현하기 (CRUD)<br><br>
[링크]()
## list
1. `Mapper.xml`속성 - `ParameterType`, `resultType`, `#{}`
2. 의존성 주입 어노테이션 - `@Inject`, `@Autowired`, ...
3. DAO <-> Mapper(`mapper.java`(interface)를 안쓰는 경우 처리 방법)
4. GET방식과 POST방식
5. JSTL(`c:forEach`, `c:if`, ...)
6. Model(Para. -> `Method(Model model)`, `${list}`)작동 원리
7. span/div차이
8. `@RequestMapping` - 주소패턴, 속성
9. Redirect(+사용방법)/Forward의 차이
10. `<input>`태그 - 속성 : `readonly`
11. `<button>`태그 - 속성 : `formaction`, `formmethod`
12. `@RequestParam`



<br>

---

<br>

## 4차 과제
### 주제 
### Spring Framework 프로젝트의 DBMS를 다른 것으로 바꿔보기<br>

<br>

---
