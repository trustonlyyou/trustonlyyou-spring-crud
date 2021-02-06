<%--
  Created by IntelliJ IDEA.
  User: 렁환이
  Date: 2021-01-23
  Time: 오후 5:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>Find ID Success</h1>
    User ID :: ${result}
    <input type="button" onclick="location.href='/membership/findPassword'" value="비밀버호 찾기">
    <input type="button" onclick="location.href='/index" value="Main Page">
</body>
</html>
