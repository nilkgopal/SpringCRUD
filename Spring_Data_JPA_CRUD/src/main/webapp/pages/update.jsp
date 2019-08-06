<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update Page</title>
</head>
<body>
<form action="updatedata">
 <input type="hidden" name="id" value="${id}">
 Username:- <input type="text" name="username" value="${uname}">
 <br>
 Password:- <input type="password" name="pwd" value="${pass}">
 <br>
 Mobile:- <input type="text" name="mobile" value="${mobil}">
 <br>
 Address:- <input type="text" name="address" value="${address}">
 <br>
 <input type="submit" value="SUBMIT">

</form>

<!-- <script type="text/javascript">
 function update()
 {
	 var req=new XMLHttpRequest();
	 req.open("POST","updatedata",true);
	 req.send();
 }
</script> -->
</body>
</html>