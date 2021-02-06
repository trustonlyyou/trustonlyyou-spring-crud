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
</head>
<body>
<form action="/membership/postModifyPassword" method="post">
    <table border="2">
        <tr>
            <td>비밀번호 </td><td><label><input type="password" name="newUserPassword" size="15"></label></td>
        </tr>
        <tr>
            <td>비밀번호 확인 </td><td><label><input type="password" size="15"></label></td>
            <%--      Ajax 아직 모름... 시벌 것      --%>
        </tr>
    </table>
    <input type="submit" value="확인">
</form>
</body>
</html>
