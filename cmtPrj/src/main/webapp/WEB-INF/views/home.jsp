<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
	
	<h1>home Pages</h1>
	<h2>Comento Prj</h2>
	
	<form action="/listAll" method="get">
		<button type="submit">CRUD 게시판 가기</button>		
	</form>
	
</body>
</html>
