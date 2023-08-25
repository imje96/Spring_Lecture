<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<script type="text/javascript">
if('${msg}')
    alert('${msg}')
</script>
</head>
<body>

	<h1>회원가입 페이지입니다.</h1>
	<div align=left>
		<form:form action="${pageContext.request.contextPath }/join" method="post" modelAttribute="memberVO">
            id: <form:input path="id"/>
            <form:errors path="id"/><br> 
            password: <form:input path="password"/>
            <form:errors path="password"/><br>
            name: <form:input path="name"/>
            <form:errors path="name"/><br>
            addr: <form:input path="addr"/>
            <form:errors path="addr"/><br>                     
            <input type="submit" value="회원가입 요청">
        </form:form>
	</div>
</body>
</html>