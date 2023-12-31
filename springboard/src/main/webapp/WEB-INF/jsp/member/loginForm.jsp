<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	if('${msg}')
		alert('${msg}')
</script>
</head>
<body>
   <a href="${pageContext.request.contextPath}/"><img alt="" src="https://www.kopo.ac.kr/ckimage/2021/11/RdpM96PX1HZJpTwWZ4gX.png">
   </a>
   <a href="${pageContext.request.contextPath}/board">게시판</a>
   
   <a href="${pageContext.request.contextPath}/board/new">새글쓰기</a>
   
<!--    만약 currentuser가 있으면 ~님 안녕하세요 보여주고 로그아웃링크를 생성하고 없으면 로그인 링크를 생성한다 -->
   <c:if test="${empty currentUser }">
        <a href="${pageContext.request.contextPath}/login">로그인</a>
        <a href="${pageContext.request.contextPath}/join">회원가입</a>
    </c:if>
    <c:if test="${not empty currentUser }">
        ${currentUser.name }님 안녕하세요.
        <a href="${pageContext.request.contextPath}/logout">로그아웃</a>
    </c:if>
   

   <br>

	<h1>로그인 페이지 입니다.</h1>
	<h1><spring:message code="label.title"></spring:message></h1>
	<div align="left">
		<form:form action="${pageContext.request.contextPath }/login" 
			method="post" modelAttribute="loginVO">
			id: <form:input path="id"/>
				<form:errors path="id"/><br>
			password: <input type="text" name="password">
					  <form:errors path="password"/><br> 
			<input type="submit" value="로그인">
		</form:form>
	</div>
</body>
</html>