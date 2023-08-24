<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
환영합니다. 첫 페이지입니다.

	<a href="${pageContext.request.contextPath }/board">게시판</a><br>
	<a href="${pageContext.request.contextPath }/board/new">새글쓰기</a><br>
	<a href="${pageContext.request.contextPath }/login">로그인하기</a><br>
</body>
</html>