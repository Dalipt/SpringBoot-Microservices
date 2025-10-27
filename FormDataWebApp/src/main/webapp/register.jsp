<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
</head>
<body>
	<h1>Home Page </h1>
	<form  method="post">
  <label for="id">ID:</label>
  <input type="number" id="id" name="id"><br><br>

  <label for="name">Name:</label>
  <input type="text" id="name" name="name"><br><br>

  <label for="departType">Depart Type:</label>
  <input type="text" id="bookType" name="bookType"><br><br>

  <label for="publisher">Publisher:</label>
  <input type="number" step="0.01" id="publisher" name="publisher"><br><br>

  <label for="version">Version:</label>
  <input type="number" id="version" name="version"><br><br>

  <input type="submit" value="register">
</form>
</body>
</html>