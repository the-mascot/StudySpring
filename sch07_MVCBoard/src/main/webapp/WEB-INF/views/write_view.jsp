<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
		<form action="write" method="post">
		<input type="hidden" name="bId" value="${mvc_board.bId }">
		<table border="1">
			<tr>
				<td>이름</td>
				<td><input type="text" name="bName" size="50"></td>
			</tr>
			<tr>
				<td>제목</td>
				<td><input type="text" name="bTitle" size="50"></td>
			</tr>
			<tr>
				<td>내용</td>
				<td><textarea rows="10" name="bContent"></textarea></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="입력"> &nbsp;
				<a href="list">목록보기</a>
				</td>
			</tr>
		</table>	
	</form>
	
</body>
</html>