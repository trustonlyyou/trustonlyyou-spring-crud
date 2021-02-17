<%--
  Created by IntelliJ IDEA.
  User: h
  Date: 2021-02-17
  Time: 오후 10:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>게시글 작성</title>
</head>
<body>
    <%--  title, content, userId  --%>
    <%--  userId는 session 에서 받아서 고정 시켜주자.  --%>

    <form action="/crowdfunding/free/board/writePost" method="post">
        <div>
            <table border="2" width="200">
                <tr>
                    <td>글쓴이 : </td>
                    <td><input type="text" name="userId" value="${userId}" readonly></td>
                </tr>
                <tr>
                    <td>제목 : </td>
                    <td><input type="text" name="title"></td>
                </tr>
                <tr>
                    <td colspan="2"><textarea cols="50" rows="20" name="content"></textarea></td>
                </tr>
                <tr>
                    <!-- <td>첨부 : </td>
                    <td><input type="file" name="fileName"></td> -->
                </tr>
                <tr>
                    <td><input type="reset" value="글쓰기취소"></td>
                    <td align="right"><input type="submit" value="글쓰기"></td>
                </tr>
            </table>
        </div>
    </form>

    <nav>
        <a href="/">메인 화면</a>
    </nav>

</body>
</html>
