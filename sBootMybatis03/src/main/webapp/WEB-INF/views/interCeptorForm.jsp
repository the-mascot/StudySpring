<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>    
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>interCepter</title>
</head>
<body>
	<h2>직원정보 조회</h2>
	<c:if test="${msg!=null}">${msg}</c:if>
	<form action="interCeptor" name="frm">
	<table>
		<tr><th>사번</th><td><input type="text" name="id" required="required"></td></tr>
		<tr><td><input type="submit" value="확인"></td></tr>
	</table>
	</form>
</body>
</html>