<%--
  Created by IntelliJ IDEA.
  User: 렁환이
  Date: 2021-01-10
  Time: 오후 9:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>Login Success</h1>
    User Name :: ${sessionScope.loginId }
    <form action="/membership/logout">
        <input type="submit" value="로그아웃">
    </form>
</body>
</html>
