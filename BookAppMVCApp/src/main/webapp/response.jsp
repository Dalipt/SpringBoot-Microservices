<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>BookInfo</title>
</head>
<body>
	<center>Display data from collection</center>
	<c:forEach var="booksName" items="${book}">${booksName}</c:forEach>
</body>
</html>