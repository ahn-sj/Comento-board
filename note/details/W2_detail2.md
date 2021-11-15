### 9. MyBatis
MyBatis를 설명하기에 앞서 JDBC에 대한 내용을 잠시 짚고 넘어가겠다.

<br>

#### JDBC(**J**ava **D**ata**B**ase **C**onnectivity)
- JDBC는 자바에서 데이터베이스에 연결(접근)하기 위해 제공되는 API로 SQL에 접근한다.<br>
- JDBC를 이용할 경우에 파일 당 SQL 및 DB연결, Java 등이 존재하기 때문에 재사용성이 좋지 않다.

이제 본론으로 들어가서 MyBatis에 대해 알아보겠다. <br><br>

#### **MyBatis**
- MyBatis는 JDBC로 처리하는 상당부분의 코드와 파라미터 설정 및 결과 매핑을 대신해주는 퍼시스턴스 프레임워크(Persistence Framework)중 하나이다.
- MyBatis를 이용하면 RDBMS(Oracle/MySQL 등)에 접근할 때 필요한 자바코드와 SQL문을 분리할 수 있고 이를 통해 코드량이 줄고 생산성을 높여주는 장점을 가진다.

<br>

MyBatis로 DBMS에 접근할 때 두 가지 방법이 존재한다
1. DAO(Data Access Object)를 통한 접근<br>
    ㄴ Controller.java -> Service.java -> DAO.java(interface) -> DAO.java(Implements) -> Mapper.xml<br>
    ㄴ 이 방법은 인터페이스와 인터페이스를 구현한 구현체 클래스가 있어야 한다.
    ㄴ 실질적으로 데이터베이스에 접근하여 데이터를 조회/삽입 등의 기능을 전담하는 객체이다.

2. Mapper인터페이스를 통한 접근<br>
    ㄴ Controller.java -> Service.java -> Mapper.java -> Mapper.xml<br>
    ㄴ MyBatis 3.0부터 지원하기 시작한 것으로 Mapper XML에 기재된 SQL을 호출하기 위한 인터페이스

<br>

[참고자료] https://hyoni-k.tistory.com/70 

<br>

[참고] https://khj93.tistory.com/entry/MyBatis-MyBatis%EB%9E%80-%EA%B0%9C%EB%85%90-%EB%B0%8F-%ED%95%B5%EC%8B%AC-%EC%A0%95%EB%A6%AC (MyBatis 동작 과정)

[참고] https://blog.naver.com/shekwl24/222141830770

<br>

---

<br>

### 10. DAO, DTO, VO
- DAO(Data Access Object)
    - 데이터베이스에 접근하여 데이터를 삽입, 삭제, 조회 등 조작할 수 있는 기능을 수행하는 객체
    - 데이터베이스에 접근하기 위한 로직과 비지니스 로직을 분리하기 위해 사용

<br>

- DTO(Data Transfer Object)
    - DTO는 보통 로직을 가지고 있지않고 데이터(속성)에 접근을 위한 `getter/setter`만을 가진 클래스
    - 데이터베이스에서 데이터를 얻어 계층 간(Service, Controller 등)데이터 전송을 위한 객체(Java Beans)를 의미    
    - 가변의 성격을 가진 클래스로 데이터 전송을 위해 존재한다(getter/setter)
    - 데이터 요청/응답시에 필요한 데이터를 전송하는 것이 DTO의 역할이기 때문에 getter/setter메서드 외에 존재하면 안된다.
    - 아래와 같은 예시를 들 수 있다.
        - 유저가 자신의 브라우저에서 데이터를 입력하여 form에 있는 데이터를 DTO에 넣어서 전송합니다.
        - 해당 DTO를 받은 서버가 DAO를 이용하여 데이터베이스로 데이터를 집어넣습니다.
    - **(확실 X)** 데이터 요청/응답시에 필요한 데이터만을 위해 존재하는 클래스

<br>

- VO(Value Object)
    - DTO와 달리 VO는 값 그 자체의 의미를 가진 불변 클래스(`Read-Only`)의 특징을 가진 클래스
    - 보통 getter의 기능만을 수행한다.
    - **(확실 X)** 테이블의 모든 필드들을 나타낸 클래스(ListAll()일때)

<br>

---

<br>

### DAO와 DTO의 코드
```java
// DAO클래스 예제

// 1. DB와 연결할 Connection을 가져온다.
// 2. 어떤 DB를 사용할 것이며, 어떤 드라이브와 로그인 정보를 사용할 것인가.
// 3. 작업이 끝나면 사용한 리소스를 시스템에 돌려준다.
public class TestDao {

    public void add(TestDto dto) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/test", "root", "root");

        PreparedStatement preparedStatement = connection.prepareStatement("insert into users(id,name,password) value(?,?,?)");


        preparedStatement.setString(1, dto.getName());
        preparedStatement.setInt(2, dto.getValue());
        preparedStatement.setString(3, dto.getData());
        preparedStatement.executeUpdate();
        preparedStatement.close();
        
        connection.close();

    }
}
```

```java
// DTD클래스 예제

// getter/setter만 존재
public class TestDTO {
    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
```

<br>

---

<br>

### 11. Controller, Service, DAO, Mapper의 데이터 흐름 - 1 (이론편)
<br>

[참고자료] https://www.kurien.net/post/view/24

service의 역할을 DAO가 DB에서 받아온 데이터를 전달받아 가공하는 것이다.

<br>

---

<br>

### 12. Controller, Service, DAO, Mapper의 데이터 흐름 - 2 (코드편)

![process_img2](https://user-images.githubusercontent.com/64416833/141796640-52b4a3f3-327e-44c2-a52c-259f883c0ca0.jpg)

![process_img](https://user-images.githubusercontent.com/64416833/141796197-5c474ba5-2897-4e99-94e6-eed6439bffd3.jpg)

** Repository는 DAO를 말함<br>
** Service와 DAO는 인터페이스와 인터페이스를 구현한 클래스를 가짐

1. 접속할 페이지(http://localhost:8080/board)에 이러한 형태로 URL Request를 요청
2. Controller는 웹 브라우저의 요청(board.jsp 호출)을 전담하여 처리 <br>
3. Service는 비지니스 로직을 수행
4. DAO(or Mapper XML)는 데이터베이스에 접속해서 SQL 쿼리를 호출
5. DB에서 SQL쿼리를 실행하고 결과값을 반환

예를들면, 1) 클라이언트가 HTTP로 "컴퓨터 주문"을 요청해왔다고 하자. 2) 이 "컴퓨터 주문"을 처리할 해당 URL이 있을 것이고 해당 URL에 대한 컨트롤러가 작동할 것이다. 3) 그리고 "컴퓨터 주문"도 노트북 혹은 데스크탑, 고수준인지 저수준인지를 체크하는 세부 사항이 있을 것이고 그것을 다루는 계층이 서비스 계층의 서비스 객체다. 4) DAO는 이 요청에 필요한 컴퓨터와 사용자 정보 데이터를 데이터베이스에서 가져오는 역할을 전담한다. 5) 그리고 각 레이어 간에 데이터들은 VO로서 전달된다. <br>

[참고자료] https://engkimbs.tistory.com/692

<br><br>

### CASE - DAO(interface and implements)
### 호출
URL Request -> Controller -> Service(interface) -> ServiceImpl -> DAO(interface) -> DAOImpl -> Mapper.xml -> DB <br>
### 반환
DB -> Mapper.xml -> DAOImpl -> DAO(interface) -> ServiceImpl -> Service(interface) -> Controller -> Response(View)

<br><br>

### CASE - Mapper.java(interface)
### 호출
URL Request -> Controller -> Service(interface) -> ServiceImpl -> Mapper.java(interface) -> Mapper.xml -> DB <br>
### 반환
DB -> Mapper.xml -> Mapper.java(interface) -> ServiceImpl -> Service(interface) -> Controller -> Response(View)
<br>

Mapper를 사용한 경우의 코드는 아래와 같습니다.
```java
// BoardVO.java
@Data
public class BoardDto {
	private int boardIdx;
	private String title;
	private String contents;
    // (...)
}
```
```java
// BoardController.java
@Controller //해당 클래스를 컨트롤러로 동작하게 한다.
public class BoardController {
	@Autowired
	private BoardService boardService;
	
	@RequestMapping("/apple") // 이 주소로 접속하면 이 메소드를 호출한다.(매핑한다.)
	public ModelAndView openBoardList() throws Exception{
		ModelAndView mv = new ModelAndView("/apple/boardList");
		
        // 이 부분에 의해 Service가 호출됨
		List<BoardVO> list = boardService.selectBoardList();
		mv.addObject("list",list);
		
		return mv;
	}
}
```
- 위에서 말한대로 Service는 두 가지를 구현해야 한다.
1. service interface
2. service interface를 구현한 class
```java
// BoardService.java (1.interface)
public interface BoardService {
	List<BoardDto> selectBoardList() throws Exception;
}
```
```java
// BoardServiceImpl.java (2.implements)
@Service
public class BoardServicelmpl implements BoardService {
	@Autowired
	private BoardMapper boardMapper;
	
	@Override
	public List<BoardDto> selectBoardList() throws Exception {
        // 이 부분에 의해 Mapper가 호출됨
		return boardMapper.selectBoardList();
	}
}
```
```java
// BoardMapper.java
@Mapper
public interface BoardMapper {
	List<BoardDto> selectBoardList() throws Exception;
}
```
```xml
<!-- BoardMapper.xml -->
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN" 
   "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
   
<mapper namespace="board.board.mapper.BoardMapper">
  <select id="selectBoardList" resultType="board.board.dto.BoardDto">
     <![CDATA[
     	SELECT
     		board_idx,
     		title,
     		hit_cnt,
     		created_datetime
     	FROM
     		t_board
     	WHERE
     		deleted_yn = 'N'
     	ORDER BY board_idx DESC
     ]]>
  </select>
</mapper>
```
XML파일에서 중요한 것은 3가지가 존재한다.
1. namespace : Mapper(interface)의 전체 경로를 적는다.(패키지 포함)<br>
`<mapper namespace="board.board.mapper.BoardMapper">`
2. id : Mapper(interface)와 XML파일을 매칭하기 위한 id로 Mapper(interface)의 메서드명과 XML파일의 id를 동일하게 작성한다.
    ```xml
    <!-- BoardMapper.xml -->
    <select id="selectBoardList" ...>
    ```

    ```java
    // BoardMapper.java
    List<BoardDto> selectBoardList() throws Exception;
    ```
3. resultType : SQL문을 실행하고 결과값을 어떤 형식으로 반환할지에 대한 반환타입을 말한다.
    `<select ... resultType="board.board.dto.BoardDto">`

<br>

[참고링크] https://dalpaeng00.tistory.com/83