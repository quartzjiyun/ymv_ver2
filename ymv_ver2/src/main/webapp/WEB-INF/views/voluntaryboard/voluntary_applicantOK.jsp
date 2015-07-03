<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<h3 align="center">
<c:forEach items="${requestScope.list }" var="appOK">
${appOK.name }님을 뽑았습니다. <br>
</c:forEach>
메일이 보내졌습니다.
<a href="home.jsp">메인화면으로 가기</a>
</h3>
