<%--
  Created by IntelliJ IDEA.
  User: 렁환이
  Date: 2021-01-23
  Time: 오후 5:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
    <c:if test="${result eq 'fail'}">
        <h1>입력하신 회원의 정보가 없습니다.</h1>
        <input type="button" onclick="location.href='/membership/findId'" value="아이디 비밀번호 찾기">
    </c:if>

    <c:if test="${result ne 'fail'}">
        <h1>Find ID Success</h1>
        User ID :: ${result}
        <input type="button" onclick="location.href='/membership/findPassword'" value="비밀버호 찾기">
        <input type="button" onclick="location.href='/'" value="Main Page">
    </c:if>
</body>
</html>
