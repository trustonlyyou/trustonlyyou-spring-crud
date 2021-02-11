<%--
  Created by IntelliJ IDEA.
  User: h
  Date: 2021-02-12
  Time: 오전 1:33
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <c:if test="${result eq 'fail'}">
        <h2>죄송합니다. 입력하신 회원의 정보가 없습니다.</h2>
    </c:if>
    <a href="/membership/join">회원 가입</a>
    <a href="/membership/findPassword">패스워드 찾기</a>
</body>
</html>
