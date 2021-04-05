<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글 상세</title>
</head>
<body>
<h1>게시글 상세</h1>
<hr>
<form action="updateBoard" method="post">
	<input name="seq" type="hidden" value="${board.seq}"/>
	<table border="1">
		<tr>
			<td background="orange">제목</td>
			<td><input type="text" name="title" value="${board.title}"></td>
		</tr>
		
		<tr>
			<td background="orange">작성자</td>
			<td>${board.writer }</td>
		</tr>
		
		<tr>
			<td background="orange">내용</td>
			<td><textarea name="content" cols="40" rows="10">${board.content}</textarea></td>
		</tr>
		
		<tr>
			<td background="orange">등록일</td>
			<td><fmt:formatDate value="${board.createDate}" pattern="YYYY-MM-dd"/></td>
		</tr>
		<tr>
			<td background="orange">조회수</td>
			<td>${board.cnt}</td>
		</tr>
		
		<tr>
			<td colspan="2" align="center">
				<input type="submit" value="글 수정"/>
			</td>
		</tr>
	</table>
</form>

<hr>
<a href="insertBoardView">글 등록</a> <br>
<a href="deleteBoard?seq=${board.seq}">글 삭제</a> <br>
<a href="getBoardList">글 목록</a> <br>

</body>
</html>