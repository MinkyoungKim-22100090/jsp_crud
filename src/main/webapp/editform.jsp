<%--
  Created by IntelliJ IDEA.
  User: kimminkyoung
  Date: 2022/11/21
  Time: 1:12 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@page import="com.common.dao.teamDAO, com.common.bean.teamVO"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Edit Form</title>
</head>
<body>

<%
    teamDAO TeamDAO = new teamDAO();
    String id=request.getParameter("id");
    teamVO u=TeamDAO.getTEAM(Integer.parseInt(id));
%>

<h1>Edit Form</h1>
<form action="edit_ok.jsp" method="post">
    <input type="hidden" name="seq" value="<%=u.getSid() %>"/>
    <table>
        <tr><td>Name:</td><td><input type="text" name="name" value="<%= u.getName()%>"/></td></tr>
        <tr><td>Grade:</td><td><input type="text" name="grade" value="<%= u.getGrade()%>"/></td></tr>
        <tr><td>Major:</td><td><input type="text" name="major" value="<%= u.getMajor()%>"/></td></tr>
        <tr><td>Email:</td><td><input type="text" name="email" value="<%= u.getEmail()%>"/></td></tr>
        <tr><td>Photo:</td><td><input type="text" name="photo" value="<%= u.getPhoto()%>"/></td></tr>
        <tr><td>Detail:</td><td><textarea cols="50" rows="5" name="content" value="<%= u.getDetail()%>"></textarea></td></tr>
        <tr><td colspan="2"><input type="submit" value="Edit Post"/>
            <input type="button" value="Cancel" onclick="history.back()"/></td></tr>
    </table>
</form>

</body>
</html>
