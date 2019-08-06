<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registration Page</title>
<script type="text/javascript">
 
 function regis()
 {
	 alert("In function");
	 var req=new XMLHttpRequest();
	 req.open("POST","registerr",true);
	 req.send();
 }
 </script>
</head>

<body>
<form action="register">
 Username:- <input type="text" name="username">
 <br>
 Password:- <input type="password" name="pwd">
 <br>
 Mobile:- <input type="text" name="mobile">
 <br>
 Address:- <input type="text" name="address">
 <br>
 <input type="submit"  value="Register">
 
 </form>
 
 <input type="button" onclick="regis()"  value="Register2">
</body>
</html>