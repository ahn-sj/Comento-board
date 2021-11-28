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

## list - [이동](https://github.com/ahn-sj/Comento-board/blob/main/note/W1.md)
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

## list - [이동](https://github.com/ahn-sj/Comento-board/blob/main/note/W2.md)
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

`src/main/java/com/cmento/sample`에 생성한 `'...Tests'`테스트 클래스들을 `/src/test/java/...`의 위치로 이동 **(완료)**

![feedback1](https://user-images.githubusercontent.com/64416833/141832590-3b12b977-e912-4c44-bbfd-bec4dd8f6d4b.jpg)

<br>

![feedback2](https://user-images.githubusercontent.com/64416833/141832596-c1e5ef18-597c-4cbf-bafe-fa1e5423fa1a.jpg)

<br>

---

<br>

## 3차 과제
### 주제
### Spring Framework 프로젝트에 게시판 구현하기 (CRUD)<br><br>

## list - [이동](https://github.com/ahn-sj/Comento-board/blob/main/note/W3.md)
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

## 수정 및 보완사항
~~viewcnt Null 처리~~  **[해결완료]**

**오라클은 모든 자료형의 DEFAULT값이 0이다.**

<br>

- `cmt_board`테이블을 처음 생성할 때(used Oracle) `viewcnt`에 `default`값을 주지 않아서 값이 주어지지 않을 경우 값이 `null`이 되었다. 그래서 insert문을 실행할 때 `HTTP 상태 코드 500 : 부적합한 열 유형:1111`의 오류가 발생했고 임시방편으로 `Mapper XML`을 작성할 때 `<insert>`쿼리에 `viewcnt`값도 입력받도록 쿼리를 짰고, `regist.jsp`에 조회수 입력 항목을 만들어서 `viewcnt`의 값을 입력받도록 했었다.
![error500](https://user-images.githubusercontent.com/64416833/142442581-995c5267-f7d9-4869-85fe-58e21b8612d0.jpg)

<br>

우선 테이블을 생성할 때 `default`를 사용하는 걸 생각하지 못했고 `viewcnt`값이 `null`이라 실행되지 않는 걸 알고도 `ALTER TABLE ...`을 할 생각도 못했다.<br>

이 문제를 계기로 주 DBMS를 골라서 기본서부터 다시 봐야겠다는 생각이 들었다

<br>

---

<br>

## 4차 과제
### 주제
### Spring Framework 프로젝트의 DBMS를 다른 것으로 바꿔보기<br>

<br>

```
cmtPrj --> Oracle, Mapper
cmtPrj2 -> MySQL, DAO
```

<br>

### 중점적으로 다룰 내용
### 1. ~~Mapper -> DAO~~ **완료**
### 2. ~~Oracle -> MySQL~~ **완료**

<br>

## list - [이동](https://github.com/ahn-sj/Comento-board/blob/main/note/W4.md)
1. hikariCP (DBCP)
2. MyBatis - DAO(mybatis-config.xml, *Mapper.xml) 흐름도
3. sqlSessionFactory - property - value - classpath 경로
4. sqlSessionFactory - property - configLocation, mapperLocation
5. sqlSessionTemplate과 메서드
6. SEQUENCE(MySQL - AUTO_INCREMENT, Oracle - seq.nextval)

<br>

### MySQL/Oracle CREATE TABLE 및 INSERT QUERY
- **MySQL**
	```sql
	CREATE TABLE CMT_BOARD (
		BNO INT AUTO_INCREMENT PRIMARY KEY,
		TITLE VARCHAR(200) NOT NULL,
		CONTENT VARCHAR(2000) NOT NULL,
		WRITER VARCHAR(50) NOT NULL,
		REGDATE DATETIME DEFAULT NOW(),
		VIEWCNT INT DEFAULT 0
	);

	-- 데이터 삽입
	INSERT INTO CMT_BOARD(TITLE, CONTENT, WRITER)
	VALUES ("TITLE1", "CONTENT1", "WRITER1");

	-- SELECT
	ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ
	| BNO | TITLE | CONTENT | WRITER | REGDATE | VIEWCNT |
	ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ
	|  1  | TITLE1 | CONTENT1 | WRITER1 | 2021. ... | 0  |
	ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ
	```

<br>

- **Oracle**
	```sql
	CREATE SEQUENCE seq_board START WITH 1 INCREMENT BY 1 NOCACHE;

	CREATE TABLE CMT_BOARD (
		BNO NUMBER(10, 0),
		TITLE VARCHAR2(200) NOT NULL,
		CONTENT VARCHAR2(2000) NOT NULL,
		WRITER VARCHAR2(50) NOT NULL,
		REGDATE DATE DEFAULT SYSDATE,
		VIEWCNT NUMBER DEFAULT 0
	);

	ALTER TABLE CMT_BOARD ADD CONSTRAINT PK_BOARD PRIMARY KEY(BNO);

	-- 데이터 삽입
	INSERT INTO CMT_BOARD (BNO, TITLE, CONTENT, WRITER)
	VALUES (SEQ_BOARD.NEXTVAL, 'TITLE2', 'CONTENT2', 'WRITER2');

	--SELECT
	ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ
	| BNO | TITLE | CONTENT | WRITER | REGDATE | VIEWCNT |
	ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ
	|  1  | TITLE2 | CONTENT2 | WRITER2 | 2021. ... | 0  |
	ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ
	```	

<br>

---

<br>

## 과제 중 발생 오류 

### 1. **MyBatis PersistenceException Error** <br>
-  `Mapper`에서 `DAO`로 변경하고 **DAO를 구현한 클래스**를 `junit`으로 테스트하다 발생한 에러

![nestedexception_img](https://user-images.githubusercontent.com/64416833/142636465-04b018db-1002-4343-8869-44704186b2f8.jpg)

```
org.mybatis.spring.MyBatisSystemException: nested exception is org.apache.ibatis.exceptions.PersistenceException: 
### Error querying database.  Cause: java.lang.IllegalArgumentException: Mapped Statements collection does not contain value for com.cmento.mapper.BoardMapper.listAll
### Cause: java.lang.IllegalArgumentException: Mapped Statements collection does not contain value for com.cmento.mapper.BoardMapper.listAll
```

<br>

`listAll`을 찾을 수 없다고 되어있어서 `Mapper.xml`을 등록하는 `root-context.xml`에서 `mapperLocations`을 확인하고 구글링해서 아래와 같은 코드로 변경해서 해결

```xml
<!-- 기존 property -->
<property name="mapperLocations" value="classpath:com/**/*Mapper.xml"/>

<!-- **************************** -->

<!-- 변경 property --> 
<property name="mapperLocations" value="classpath*:com/**/*Mapper.xml"/>
```

<br>

해당 프로젝트의 디렉터리 구조는 아래 이미지와 같다

![dir_arch](https://user-images.githubusercontent.com/64416833/142638590-d4668ed6-7ec8-4403-8264-35825c9ea807.jpg)

<br>

위 `<property>`코드에서 `classpath`에 \*가 붙고 안붙고의 차이는 1) `classpath`는 현재 프로젝트의 `resource`만 선택 한다는 것이고 2) `classpath*`는 현재 프로젝트에 관련(참조)된 모든 jar를 다 검색하여 `resource`를 선택 한다는 차이가 있다.

[참고자료] http://mybatis.org/spring/ko/factorybean.html

[참고자료] https://munhwasudo.tistory.com/entry/spring-classpath-vs-classpath-%EC%B0%A8%EC%9D%B4%EC%A0%90

<br><br>

### 2. **한글 깨짐 현상 (Oracle)** <br>
![utferror](https://user-images.githubusercontent.com/64416833/143670901-96cfc597-1f04-477d-958b-1f87bb734aaa.jpg)

별다른 처리를 해주지 않고 입력(제목, 내용, 작성자)을 받게 되면 한글이 깨지게 된다.

<br>

아래 인코딩 필터 코드를 `web.xml`에 추가
```xml
<filter>
	<filter-name>encoding</filter-name>
	<filter-class>org.springframework.web.filter.CharacterEncodingFilter</filter-class>
	<init-param>
		<param-name>encoding</param-name>
		<param-value>UTF-8</param-value>
	</init-param>
</filter>
	
<filter-mapping>
	<filter-name>encoding</filter-name>
	<servlet-name>appServlet</servlet-name>
</filter-mapping>
```

<br>

서버를 재시작해주면 정상적으로 한글을 인식하게 된다.

![utferror2](https://user-images.githubusercontent.com/64416833/143671039-2de7e3c0-94ef-4589-81ba-47852185e409.jpg)

<br>

---

<br>

## 4차 피드백

<br>

1. DBMS별 branch 분리
- branch의 기본 사용법과 원리를 익히고 DBMS별 main branch와 분리시켜 push

**main branch(Oracle)**

![branch2](https://user-images.githubusercontent.com/64416833/143671099-8114b366-b17e-47f9-8d38-c1ec49c67db8.jpg)

**main-mysql branch(MySQL)**

![branch1](https://user-images.githubusercontent.com/64416833/143671100-7856d8ac-d14e-431b-bcaa-463de7ee0822.jpg)

[참고자료] https://goddaehee.tistory.com/274?category=381481 <br>
[참고자료] https://info-lab.tistory.com/60
