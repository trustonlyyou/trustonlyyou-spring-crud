<%--
  Created by IntelliJ IDEA.
  User: 렁환이
  Date: 2021-01-23
  Time: 오후 6:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form action="/membership/postFindPassword" method="post">
        <table border="2">
            <tr>
                <td>이름 </td><td><label><input type="text" name="userName" size="15"></label></td>
            </tr>
            <tr>
                <td>아아디 </td><td><label><input type="text" name="userId" size="15"></label></td>
            </tr>
            <tr>
                <td>핸드폰 번호 </td><td><label><input type="text" name="userPhone" size="20"></label></td>
            </tr>
        </table>
        <input type="submit" value="확인">
    </form>
</body>
</html>
