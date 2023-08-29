<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.7.0.js"></script>
<script type="text/javascript">

	function showReplyList(){
		//1. ajax ㄱ reply list select 
		//2. 화면에 보여주는 작업		
		$.ajax({
			url		:	'${pageContext.request.contextPath}/reply/${boardVO.no}',
			method	:	'get',
			success	:	function(data){  //ReplyVO list
				console.log(data)
				console.log(typeof data)
				$('#replyList').empty();		
			
				$(data).each(function(){
					str ='<hr>';
					str +=  '<strong>'+this.content +'</strong>' ;
					str += '&nbsp;' + this.writer + '&nbsp;';
					str += '&nbsp;' + this.regDate + '&nbsp;';
					str += '<button class="delBtn" id=' + this.no +'>삭제</button>';		
					
					$('#replyList').append(str)
				})				
			},
			error	:	function(){
				alert('showReplyList 실패')
			}
		})
		
	}


	$(document).ready(function(){
		showReplyList();
		
		$(document).on('click', '.delBtn', function(){			 
			///reply/{replyNo}, delete
			let replyNo = $(this).attr('id');
			$.ajax({
				///reply/{bno}/{replyNo}
				url		:	'${pageContext.request.contextPath}/reply/${boardVO.no }/'+replyNo,
				method	:	'delete',
				success	:	function(){
					// alert('delete 성공')
					//replylist 를 한번 더 불러줘.
					showReplyList();
				},
				error	:	function(){
					alert('delete 실패')
				}				
			})	
			
		}) 
		
 		 
		
		
		$('#replyAddBtn').click(function(){	//alert('클릭성공')			
			let replyContent = document.replyForm.content.value;
			let replyWriter = document.replyForm.writer.value;			
			$.ajax({
				url		:	'${pageContext.request.contextPath}/reply',
				method	:	'post',
				data	:	{
					boardNo:	${boardVO.no },
					content:	replyContent,
					writer:		replyWriter	
				},
				success	: 	function(){
					//alert('insert성공');
					document.replyForm.content.value ="";
					document.replyForm.writer.value="";
					showReplyList();
				},
				error	:	function(){
					alert('insert실패')
				}
			})
			
			
			
		})		
	})

</script>
</head>
<body>
	<a href="${pageContext.request.contextPath }/">
		<img  src="https://www.google.com/images/branding/googlelogo/2x/googlelogo_color_92x30dp.png">
	</a>
	<a href="${pageContext.request.contextPath }/board">게시판</a> 
	<a href="${pageContext.request.contextPath }/board/new">새글쓰기</a> 
	<c:if test="${empty currentUser}">
		<a href="${pageContext.request.contextPath }/login">로그인</a> 
	</c:if>
	<c:if test="${not empty currentUser}">
		
		<a href="${pageContext.request.contextPath }/logout">로그아웃</a> 
		${currentUser.name }님 안녕하세요. 
	</c:if>
	<br>

상세게시글입니다.

	<div align="center">
		<table border="1" width="60%">
			<tr>
				<th>번호</th>
				<td>${boardVO.no }</td>
			</tr> 
			<tr>
				<th>제목</th>
				<td>${boardVO.title }</td>
			</tr>
			<tr>
				<th>글쓴이</th>
				<td>${boardVO.writer }</td>
			</tr>
			<tr>
				<th>등록일</th>
				<td>${boardVO.regDate }</td>
			</tr>
			<tr>
				<th>내용</th>
				<td>${boardVO.content }</td>
			</tr>			
			<tr>
				<th>댓글수</th>
				<td>${boardVO.count }</td>
			</tr> 
			</tr>
		</table>
		
		<input type="button" value="Home" 
			onclick="location.href='${pageContext.request.contextPath}/'"> 
		<input type="button" value="목록으로" 
			onclick="location.href='${pageContext.request.contextPath}/board'"> 
		<input type="button" value="삭제" 
			onclick="location.href='${pageContext.request.contextPath}/'"> 
	</div>
	<div>
		<form name="replyForm">
			댓글: <input type="text" size="50" name="content">
			작성자: <input type="text" size="20" name="writer">			
				<input type="button" value="댓글쓰기" id="replyAddBtn">
		</form>
	</div>
	<div id="replyList">
	</div>

</body>
</html>














