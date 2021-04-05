<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글 목록</title>
</head>
<body>

<h1>게시글 목록</h1>
<table border="1" cellpadding="0" cellspacing="0" width="700">
<tr>
	<th background="orange" width="100">번호</th>
	<th background="orange" width="200">제목</th>
	<th background="orange" width="150">작성자</th>
	<th background="orange" width="150">등록일</th>
	<th background="orange" width="100">조회수</th>
</tr>
<c:forEach var="board" items="${boardList}">
	<tr>
		<td>${board.seq}</td>
		<td><a href="getBoard?seq=${board.seq}">${board.title}</a></td>
		<td>${board.writer }</td>
		<td><fmt:formatDate value="${board.createDate}" pattern="YYYY-MM-dd"/></td>
		<td>${board.cnt}</td>
	</tr>
</c:forEach>
</table>

<br>
<a href="insertBoard">새글 등록</a>


</body>
</html>