<%--
  Created by IntelliJ IDEA.
  User: 렁환이
  Date: 2021-01-31
  Time: 오전 2:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Title</title>
    <script type="text/javascript" src="/resources/js/test.js"></script>
</head>
<body>
<table>
    <tr>
        <td width="5%" align="center">*</td>
        <td width="20%">아이디</td>
        <td><input type="text" name ="userId" id="id"></td>
    </tr>
    <tr >
        <td width="5%" align="center">*</td>
        <td width="20%">비밀번호</td>
        <td><input type="password" name="userPW" id="pw" onchange="check_pw()"></td>
    </tr>
    <tr>
        <td width="5%" align="center">*</td>
        <td width="20%">비밀번호 확인</td>
        <td><input type="password" name="userPW2" id="pw2" onchange="check_pw()">&nbsp;<span id="check"></span></td>
    </tr>
</table>
</body>
</html>
