<%--
  Created by IntelliJ IDEA.
  User: kimminkyoung
  Date: 2022/11/08
  Time: 5:14 PM
  To change this template use File | Settings | File Templates.
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@page import="com.example.dao.BoardDAO, com.example.bean.BoardVO"%>
<%
  String sid = request.getParameter("id");
  if (sid != ""){
    int id = Integer.parseInt(sid);
    BoardVO u = new BoardVO();
    u.setSeq(id);
    BoardDAO boardDAO = new BoardDAO();
    boardDAO.deleteBoard(u);
  }
  response.sendRedirect("posts.jsp");
%>
