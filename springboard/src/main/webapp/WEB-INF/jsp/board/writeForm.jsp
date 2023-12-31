<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<style>
	.error{
		color:red
	}
</style>
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
   

   <h1>새글입니다.</h1>
   <div>
<form:form action="${pageContext.request.contextPath}/board/new"
			method="post" modelAttribute="boardVO">
			<table>
				<tr>
					<th>제목</th>
					<td><form:input path="title" /></td>
					<td><form:errors path="title" class="error"/></td>
				</tr>
				<tr>
					<th>글쓴이</th>
					<td><form:input path="writer" /></td>
					<td><form:errors path="writer" class="error" /></td>
				</tr>
				<tr>
					<th>내용</th>
					<td><form:input path="content" /></td>
					<td><form:errors path="content" class="error" /></td>
				</tr>
			</table>
			<input type="submit" value="새글쓰기">
		</form:form>
   </div>
</body>
</html>