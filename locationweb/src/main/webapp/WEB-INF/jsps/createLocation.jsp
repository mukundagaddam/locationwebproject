<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Create Location</title>
</head>
<body>
<form action = "saveloc" method = "post">
<pre>
Id:<input type = "text" name="id">
Code:<input type = "text" name="code">
Name:<input type = "text" name="name">
Type: Urban <input type = "radio" name="type" value = "urban">
      Rural<input type = "radio" name="type" value = "rural">
 <input type = "submit" value="save">
 </pre>
 </form>
   ${msg}
   <a href="displayLocations"> View All</a>
</body>
</html>