<%--
  Created by IntelliJ IDEA.
  User: kimminkyoung
  Date: 2022/11/08
  Time: 5:12 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@page import="com.example.dao.BoardDAO"%>

<% request.setCharacterEncoding("utf-8"); %>

<jsp:useBean id="u" class="com.example.bean.BoardVO" />
<jsp:setProperty property="*" name="u"/>

<%
  BoardDAO boardDAO = new BoardDAO();
  int i=boardDAO.updateBoard(u);
  response.sendRedirect("posts.jsp");
%>
