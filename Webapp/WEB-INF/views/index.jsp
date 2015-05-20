<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="com.sds.icto.guestbook3.dao.GuestbookDao"%>
<%@page import="java.util.List"%>
<%@page import="com.sds.icto.guestbook3.vo.GuestbookVo"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%
	pageContext.setAttribute("newLineChar", "\n");
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>방명록</title>
</head>
<body>
	<form action="insert" method="post">
		<table border=1 width=500>
			<tr>
				<td>이름</td>
				<td><input type="text" name="name"></td>
				<td>비밀번호</td>
				<td><input type="password" name="password"></td>
			</tr>
			<tr>
				<td colspan=4><textarea name="message" cols=60 rows=5></textarea></td>
			</tr>
			<tr>
				<td colspan=4 align=right><input type="submit" VALUE=" 확인 "></td>
			</tr>
		</table>
	</form>
	<br>
	<table width=510 border=1>
		<c:forEach var="g" items="${list }" varStatus="status">

			<tr>
				<td>${g.no }</td>
				<td>${g.name }</td>
				<td>${g.regDate}</td>
				<td><a href="/guestbook3/delete/${g.no }">삭제</a></td>
			</tr>
			<tr>
				<td colspan=4>${fn:replace(g.message, newLineChar, "<br>") }</td>
			</tr>

		</c:forEach>
	</table>
	<br>


</body>
</html>