<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Viewdata Page</title>
<script type="text/javascript">
 function edit()
 {
	 document.my.action="update";
	 document.my.submit();
 }

 function deleteRecord()
 {
	 document.my.action="delete";
	 document.my.submit();
 }
 
 function add()
 {
	 document.my.action="addbtn";
	 document.my.submit();
 }
</script>
</head>
<body>
<center>
<form name="my">
<table border="2">
 <tr>
 <th>Username</th><th>Password</th><th>Mobile</th><th>Address</th></tr>
<c:forEach var="ulist" items="${slist}">
      <tr>
        <td>${ulist.username}</td>
        <td>${ulist.pwd}</td>
        <td>${ulist.mobile}</td>
        <td>${ulist.address}</td>
        <td><input type="radio" name="radioName" value="${ulist.id}"/>select</td>
      </tr>   
  </c:forEach>
 </table>
 <input type="button" onclick="add()" value="Add">
 <input type="button" onclick="edit()" value="Update">
 <input type="button" onclick="deleteRecord()" value="Delete">
 
 </form>
 </center>
</body>
</html>