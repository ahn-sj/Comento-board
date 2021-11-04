# Comento - 직무부트캠프
## 나만의 포트폴리오 작성으로 웹개발 백엔드 직무 체험하기
### 기간 2021. 10. 31 ~ 2021. 11. 28

## 1차 과제<br>
### 주제 
Spring Framework 프로젝트 생성 후 Github Repository에 Commit 하기<br><br>

---

<br>

### 1. gitignore 추가<br>
- 프로젝트 작업시 로컬 환경의 정보나 빌드 정보등 원격 저장소에 관리하지 말아야되는 파일들에 대해서 지정하여 원격 저장소에 실수로 올라가지 않도록 관리하는 파일<br>
- .gitignore 파일은 프로젝트 최상위 위치에 존재해야한다.<br><br>
- 패턴<br>
  작성 패턴은 아래의 규칙을 따른다.<br>
  - '#'로 시작하는 라인은 무시한다.
  - 표준 Glob 패턴을 사용한다.
  - 슬래시(/)로 시작하면 하위 디렉터리에 적용되지(recursivity) 않는다.
  - 디렉터리는 슬래시(/)를 끝에 사용하는 것으로 표현한다.
  - 느낌표(!)로 시작하는 패턴의 파일은 무시하지 않는다.<br>
- .gitignore 파일 적용<br>
  - 작성한 .gitignore을 commit하여 원격 저장소에 push한다.<br>
  - push후 gitignore적용이 되지 않을경우 아래의 명령어를 통해 원격 저장소 파일을 제거후 다시 push한다.

```
git rm -r --cached .
git add. 
git commit -m "커밋메세지"
git push origin {브랜치명}
```

[참고자료] https://velog.io/@psk84/.gitignore-%EC%A0%81%EC%9A%A9%ED%95%98%EA%B8%B0

<br>

---
<br>

### 2. JDBC와 MyBatis 차이
- JDBC(Java Database Connectivity)는 자바에서 데이터베이스에 접속할 수 있도록 하는, 즉 자바에서 DB에 연결하기 위해 제공되는 API로서 SQL(Structured Query Language)에 접근한다.
JDBC 한 파일에서는 SQL 및 DB연결, Java언어가 모두 존재하기때문에 재사용성이 좋지 않다.
- MyBatis는 SQL문이 어플리케이션 소스 코드로부터 분리된다. 또한 JDBC를 통해 수동으로 세팅한 파라미터와 결과 매핑을 대신해주어 JDBC로 처리하는 작업 보다 더 간편하게 작업할 수 있으며, 코드량이 줄어 생산성을 높여준다. 
<br>

MyBatis는 개발자가 지정한 SQL, 저장프로시저 그리고 몇가지 고급 매핑을 지원하는 퍼시스턴스 프레임워크(Persistence Framework) 중 하나이다. 마이바티스는 JDBC로 처리하는 상당부분의 코드와 파라미터 설정및 결과 매핑을 대신해준다. 마이바티스는 데이터베이스 레코드에 원시타입과 Map 인터페이스 그리고 자바 POJO(Plain Old Java Objects)를 설정해서 매핑하기 위해 XML이나 Annotation을 사용할 수 있다.

**JDBC와 MyBatis의 코드 차이**는 아래 참고자료 링크를 참고

[참고자료] https://hyoni-k.tistory.com/70 <br><br>

---

