<%--
  Created by IntelliJ IDEA.
  User: kimminkyoung
  Date: 2022/11/21
  Time: 1:12 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.common.dao.teamDAO"%>
<%@ page import="com.common.bean.teamVO"%>
<%@ page import="com.common.fileupload"%>
<%
    String sid=request.getParameter("id");
    if(sid!=""){
        int id=Integer.parseInt(sid);
        teamDAO TeamDAO= new teamDAO();
        String filename=TeamDAO.getPhotoFilename(id);
        if(filename!=null)
            fileupload.deleteFile(request,filename);
        TeamDAO.deleteTEAM(id);
    }
    response.sendRedirect("index.jsp");
%>
<html>
<head>
    <title>Delete</title>
</head>
<body>

</body>
</html>

