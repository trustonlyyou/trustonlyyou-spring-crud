<%--
  Created by IntelliJ IDEA.
  User: h
  Date: 2021-02-18
  Time: 오전 5:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%--  title, content, userId  --%>
    <%--  userId는 session 에서 받아서 고정 시켜주자.  --%>

    <form action="/crowdfunding/free/userBoard/myBoardModify" method="post">
        <div>
            <input type="hidden" name="num" value="${num}">
        </div>
        <div>
            <table border="2" width="200">
                <tr>
                    <td>글쓴이 : </td>
                    <td><input type="text" name="userId" value="${userId}" readonly></td>
                </tr>
                <tr>
                    <td>제목 : </td>
                    <td><input type="text" name="title" value="${data.title}"></td>
                </tr>
                <tr>
                    <td colspan="2"><textarea cols="50" rows="20" name="content">${data.content}</textarea></td>
                </tr>
                <tr>
                    <td><a href="/crowdfunding/free/board/listPage">수정 취소</a></td>
                    <td align="right"><input type="submit" value="수정"></td>
                </tr>
            </table>
        </div>
    </form>

    <nav>
        <a href="/">메인 화면</a>
    </nav>
</body>
</html>
