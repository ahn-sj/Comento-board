## 1. 스프링 프로젝트 기본 구조 및 실행 과정

<br>

### **스프링 프로젝트 기본 구조**

![image](https://user-images.githubusercontent.com/64416833/141065916-fa6fca38-ccee-4b60-aec7-b7c35d6b6836.png)

1. web.xml
2. root-context.xml / servlet-conext.xml load
3. servlet-context에 명시된 controller address mapping
4. Controller 내부 메서드 실행<br><br>

* web.xml (서블릿 배포 기술자, DD(Deployment Descriptor))
    - WAS(Tomcat)가 최초로 구동될 때 WEB-INF/ 디렉터리에 존재하는 web.xml을 읽고 그에 해당하는 웹 애플리케이션 설정을 구성한다. 
    <br>다시 말해, **각종 설정을 위한 설정파일**이다.<br>
    - 여러 xml파일(기본 : root-context.xml / servlet-context.xml)을 인식하도록 각 파일을 가리켜준다

```xml
<?xml version="1.0" encoding="UTF-8"?>
<web-app version="2.5" xmlns="http://java.sun.com/xml/ns/javaee"
    xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
    xsi:schemaLocation="http://java.sun.com/xml/ns/javaee https://java.sun.com/xml/ns/javaee/web-app_2_5.xsd">
 
    <!-- The definition of the Root Spring Container shared by all Servlets and Filters -->
    <context-param>
        <param-name>contextConfigLocation</param-name>
        <param-value>/WEB-INF/spring/root-context.xml</param-value>
 </context-param>
 
    <!-- Creates the Spring Container shared by all Servlets and Filters -->
    <listener>
        <listener-class>org.springframework.web.context.ContextLoaderListener</listener-class>
    </listener>
 
    <!-- Processes application requests -->
    <servlet>
        <servlet-name>appServlet</servlet-name>
        <servlet-class>org.springframework.web.servlet.DispatcherServlet</servlet-class>
        <init-param>
            <param-name>contextConfigLocation</param-name>
            <param-value>/WEB-INF/spring/appServlet/servlet-context.xml</param-value>
        </init-param>
        <load-on-startup>1</load-on-startup>
    </servlet>
 
    <servlet-mapping>
        <servlet-name>appServlet</servlet-name>
        <url-pattern>/</url-pattern>
    </servlet-mapping>
</web-app>
```

각 태그의 세부내용은 다음과 같다.

`<servlet>` : DispatcherServlet을 구현하기 위해 어떤 클래스를 이용해야 할지와 초기 파라미터 정보를 포함하고 있다. <br>
`<servlet-name>` : 해당 서블렛의 이름을 지정하면 이 지정된 이름을 가지고 다른 설정 파일에서 해당 서블릿 정보를 참조한다. <br>
`<servlet-class>` : 어떤 클래스를 가지고 DispatcherServlet을 구현할 것인지를 명시하고 있다. <br>
`<init-param>`  : 초기화 파라미터에 대한 정보. servlet에 대한 설정 정보가 여기에 들어간다. 만약 초기화 파라미터에 대한 정보를 기술하지 않을 경우 스프링이 자동적으로 appServlet-context.xml을 이용하여 스프링 컨테이너를 생성한다. <br>
`<load-on-startup>` :  서블릿이 로딩될 때 로딩 순서를 결정하는 값. 톰캣이 구동되고 서블릿이 로딩되기 전 해당 서블릿에 요청이 들어오면 서블릿이 구동되기 전까지 기다려야 한다. 이 중 우선순위가 높은 서블릿부터 구동할 때 쓰이는 값이다. <br>
`<servlet-mapping>` : 서블렛이 <url-pattern>에서 지정한 패턴으로 클라이언트 요청이 들어오면 해당 <servlet-name>을 가진 servlet에게 이 요청을 토스하는 정보를 기술한다. <br>


* root-context.xml
    - VIEW와 관련되지 않은 객체를 정의하게 되는데 Service, Repository(DAO), DB 등 비지니스 로직과 관련된 설정을 한다  
    - `hikariConfig (property :: driverClassName, jdbcUrl, username, passward)`, `dataSource`, `sqlSessionFactory`, `<mybatis-spring:scan base-package="" />`, `<context:component-scan/>(Mapper, Service)`, ...

    
```xml
<?xml version="1.0" encoding="UTF-8"?>
    <beans xmlns="http://www.springframework.org/schema/beans"
    xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
    xsi:schemaLocation="http://www.springframework.org/schema/beans https://www.springframework.org/schema/beans/spring-beans.xsd">
    
    <!-- Root Context: defines shared resources visible to all other web components -->
</beans>
```


* servlet-context.xml
    - 서블릿 관련 설정 파일로 URL과 관련된 설정 파일이다
    - `InternalResourceViewResolver`, `<context:component-scan/>(Controller)`, `<annotation-driven/>`, `<resources>`, `<beans:bean class="...">`, ...

```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans:beans xmlns="http://www.springframework.org/schema/mvc"
    xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
    xmlns:beans="http://www.springframework.org/schema/beans"
    xmlns:context="http://www.springframework.org/schema/context"
    xsi:schemaLocation="http://www.springframework.org/schema/mvc 
        https://www.springframework.org/schema/mvc/spring-mvc.xsd
        http://www.springframework.org/schema/beans 
        https://www.springframework.org/schema/beans/spring-beans.xsd
        http://www.springframework.org/schema/context 
        https://www.springframework.org/schema/context/spring-context.xsd">
    
    <!-- DispatcherServlet Context: defines this servlet's request-processing infrastructure -->
    
    <!-- Enables the Spring MVC @Controller programming model -->
    <annotation-driven />
    
    <!-- Handles HTTP GET requests for /resources/** by efficiently serving up static resources in the ${webappRoot}/resources directory -->
    <resources mapping="/resources/**" location="/resources/" />
    
    <!-- Resolves views selected for rendering by @Controllers to .jsp resources in the /WEB-INF/views directory -->
    <beans:bean class="org.springframework.web.servlet.view.InternalResourceViewResolver">
        <beans:property name="prefix" value="/WEB-INF/views/" />
        <beans:property name="suffix" value=".jsp" />
    </beans:bean>
    
    <context:component-scan base-package="com.company.devpad" />
    </beans:beans>
```

각 태그의 세부내용은 다음과 같다.

`InternalResourceViewResolver` : 서블릿 설정으로 prefix(접두사)와 suffix(접미사)를 붙여주는 역할을 한다. <br>
**즉, 우리가 일일이 전체경로와 .jsp를 붙이지 않도록 도와준다** <br>
`<context:component-scan/>` : 스프링에서 사용하는 bean을 일일이 xml에 선언하지 않고도 필요한 것을 어노테이션(@, Annotaion)을 자동으로 인식하게 하는 역할을 한다. 
**즉, Java 파일의 @Component로 등록된 Bean 객체를 찾도록 해주는 태그** <br>
`<annotation-driven>` : @Controller 어노테이션을 감지하여 해당 클래스를 Controller로 등록할 수 있도록 해주는 태그 <br>
`<resources>` : 정적인 html문서 같은 웹 리소스들의 정보를 기술하는 태그 <br>
`<beans:bean class="org.springframework.web.servlet.view.InternalResourceBiewResolver">` : Controller가 Model를 리턴하고 DispatcherServlet이 jsp 파일을 찾을 때 쓰이는 정보를 기술하는 태그. "home"이라는 문자열을 반환하면 /WEB-INF/views/ 경로에서 접미사가 .jsp인 해당 파일을 찾는다. <br>
**ㄴ /WEB-INF/views/** home **.jsp** 

<br>

---

<br>

### **스프링 프로젝트 실행 과정**
![image](https://user-images.githubusercontent.com/64416833/141066707-f2fdc78f-538d-4a3e-9bba-86f5b38a709b.png) <br>
3. 순수한 데이터 처리 로직은 root-context.xml의 영역이고 처리되어 받는 데이터결과를 Model이라고 한다<br>

1) 사용자가 URL에 페이지를 요청 (Request)
2) Controller가 실제 DB에 있는 데이터를 가지고온다(순수한 데이터 처리 로직)<br>
ㄴ Model(DB에서 가져온 데이터들)
3) jsp화면에 Model(데이터들)을 전달(처리된 데이터를 View로 전달)
4) 전달된 화면을 가지고 브라우저에 맞는 메시지를 만든다(Tomcat의 역할)
5) Tomcat을 통해 브라우저에 화면을 뿌려준다(Response)

<br>

--- 

<br>

**자세한 스프링 실행 순서**

![image](https://user-images.githubusercontent.com/64416833/141066170-be32a7d9-f84f-4eee-b856-a0f97b1d1605.png)

1. 클라이언트가 Request 요청을 하면, DispatcherServlet이 요청을 가로챈다. 이 때 DispatcherServlet이 모든 요청을 가로채는 건 아니고 web.xml에 등록된 내용만 가로챈다. 최초의 web.xml 에서는 <url-pattern>이 '/'와 같이 해당 애플리케이션의 모든 URL로 등록돼있기 때문에, 만약 *. do와 같이 특정 URL만 적용하고 싶다면 <url-pattern>의 내용을 바꿔주어 범위를 변경하면 된다.

2. DispatcherServlet이 가로챈 요청을 HandlerMapping에게 보내 해당 요청을 처리할 수 있는 Controller를 찾는다.

3. 실제 로직 처리 (Controller -> Service -> DAO -> DB -> DAO -> Service -> Controller)

4. 로직 처리 후 ViewResolver를 통해 view 화면을 찾는다.

5. 찾은 view 화면을 View에 보내면 이 결과를 다시 DispatcherServlet에 보내고, DispatcherServlet는 최종 클라이언트에게 전송한다.

[참고자료] https://devpad.tistory.com/24