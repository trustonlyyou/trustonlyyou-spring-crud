<%--
  Created by IntelliJ IDEA.
  User: 렁환이
  Date: 2021-01-23
  Time: 오후 7:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript" src="/resources/js/passwordCheck.js"></script>
</head>
<body>
    <form action="/membership/postModifyPassword" method="post">
        <div>
            비밀번호 <input type="password" name="userPassword" id="pw" onchange="isSamePasswordCheck()">
        </div>
        <div>
            비밀번호 확인 <input type="password" name="checkUserPassword" id="pw2" onchange="isSamePasswordCheck()">&nbsp;<span id="same"></span>
        </div>
        <input type="submit" value="확인">
    </form>
</body>
</html>
