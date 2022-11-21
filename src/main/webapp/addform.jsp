<%--
  Created by IntelliJ IDEA.
  User: kimminkyoung
  Date: 2022/11/21
  Time: 1:11 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Insert name here</title>
</head>
<body>

<h1>Add New Post</h1>
<form action="add_ok.jsp" method="post">
    <table>
        <tr><td>Name:</td><td><input type="text" name="name"/></td></tr>
        <tr><td>Grade:</td><td><input type="text" name="grade"/></td></tr>
        <tr><td>Major:</td><td><input type="text" name="major"/></td></tr>
        <tr><td>Email:</td><td><input type="text" name="email"/></td></tr>
        <tr><td>Photo:</td><td><input type="text" name="photo"/></td></tr>
        <tr><td>Detail:</td><td><textarea cols="50" rows="5" name="content"></textarea></td></tr>
        <tr><td><a href="view.jsp">View All Records</a></td><td align="right"><input type="submit" value="Add Post"/></td></tr>
    </table>
</form>

</body>
</html>
