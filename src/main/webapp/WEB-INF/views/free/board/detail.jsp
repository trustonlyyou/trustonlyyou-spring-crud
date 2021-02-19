<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 렁환이
  Date: 2021-02-17
  Time: 오전 2:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<main>
    <div>
        <fieldset>
            <legend>FreeBoard</legend>

            <table class="table">
                <tbody>
                <tr>
                    <th>제목</th>
                    <td colspan="3">${data.title}</td>
                </tr>
                <tr>
                    <th>작성일</th>
                    <td colspan="3">${data.regdate}</td>
                </tr>
                <tr>
                    <th>작성자</th>
                    <td>${data.userId}</td>
                    <th>조회수</th>
                    <td>${data.viewCnt}</td>
                </tr>
                <tr>
                    <td colspan="4">
                        <div>
                            <br>
                            ${data.content}
                        </div>
                        <br>
                        <div>
                            <br>
                        </div>
                        <div>
                            <br>
                        </div>
                    </td>
                </tr>
                </tbody>
            </table>
        </fieldset>
    </div>

    <div style="text-align: right;">
        <h2>
            <a class="btn btn-list" href="/crowdfunding/free/board/listPage?page=${page}">목록</a>
<%--            http://localhost:8080/crowdfunding/free/board/listPage?page=2--%>
<%--            http://localhost:8080/crowdfunding/free/board/detail/?num=117--%>
        </h2>
    </div>

    <div>
    <%--   table의 num 값으로 다음, 이전 페이지를 구성 했지만 데이터 손실 되었을 때 중간에 값이 뜨기 때문에 이슈가 발생한다.     --%>
<%--        <table>--%>
<%--            <tbody>--%>
<%--            <tr>--%>
<%--                <c:if test="${maxNum == num}">--%>
<%--                    <th>다음 글이 없습니다.</th>--%>
<%--                </c:if>--%>
<%--                <c:if test="${maxNum != num}">--%>
<%--                    <th><a href="/crowdfunding/free/board/detail/?page=${page}&num=${num + 1}">다음글</a></th>--%>
<%--               </c:if>--%>
<%--            </tr>--%>

<%--            <tr>--%>
<%--                <c:if test="${num == 1}">--%>
<%--                    <th>이전 글이 없습니다.</th>--%>
<%--                </c:if>--%>
<%--                <c:if test="${num != 1}">--%>
<%--                    <th><a href="/crowdfunding/free/board/detail?page=${page}&num=${num - 1}">이전글</a></th>--%>
<%--                </c:if>--%>
<%--            </tr>--%>
<%--            </tbody>--%>
<%--        </table>--%>
    </div>
</main>
</body>
</html>
