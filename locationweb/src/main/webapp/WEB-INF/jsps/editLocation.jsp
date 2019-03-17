<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit Location</title>
</head>
<body>
<form action = "updateloc" method = "post">
<pre>
Id:<input type = "text" name="id" value=${location.id} readonly>
Code:<input type = "text" name="code" value=${location.code}>
Name:<input type = "text" name="name" value=${location.name}>>
Type: Urban <input type = "radio" name="type" value = "urban" ${location.type == 'urban'?'checked':''}>
      Rural<input type = "radio" name="type" value = "rural"${location.type == 'rural'?'checked':''}>
 <input type = "submit" value="update">
 </pre>
 </form>
   ${msg}
</body>
</html>