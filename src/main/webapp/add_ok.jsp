<%--
  Created by IntelliJ IDEA.
  User: kimminkyoung
  Date: 2022/11/21
  Time: 1:12 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@page import="com.common.dao.teamDAO"%>

<% request.setCharacterEncoding("utf-8"); %>

<jsp:useBean id="u" class="com.common.bean.teamVO" />
<jsp:setProperty property="*" name="u"/>

<%
  teamDAO teamDAO = new teamDAO();
  int i = teamDAO.insertTEAM(u);
  String msg = "데이터 추가 성공 !";
  if(i == 0) msg = "[에러] 데이터 추가 ";
%>

<script>
  alert('<%=msg%>');
  location.href='view.jsp';
</script>