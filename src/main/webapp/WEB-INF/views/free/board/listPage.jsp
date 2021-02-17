<%--
  Created by IntelliJ IDEA.
  User: 렁환이
  Date: 2021-02-14
  Time: 오후 4:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>공지사항</title>
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
</head>
<body>
    <header>
        <div style="text-align: center;">
            <h1>자유 게시판</h1>
        </div>
    </header>

    <main>
        <div>
            <h3>검색폼</h3>
            <form>
                <fieldset>
                    <legend class="hidden">검색 필드</legend>
                    <label class="hidden">검색분류</label>
                    <select name="f">
                        <option value="title">제목</option>
                        <option value="writerId">작성자</option>
                    </select>
                    <label>검색어</label>
                    <input type="text" name="search" value=""/>
                    <input type="submit" value="검색" />
                </fieldset>
            </form>
        </div>

        <div>
            <h3>자유게시판 목록</h3>
            <table class="table">
                <thead>
                <tr>
                    <th>번호</th>
                    <th>제목</th>
                    <th>작성자</th>
                    <th>작성일</th>
                    <th>조회수</th>
                </tr>
                </thead>
                <tbody>

                <%--  전체 레코드 수 - ( (현재 페이지 번호 - 1) * 한 페이지당 보여지는 레코드 수 + 현재 게시물 출력 순서 )--%>
                <c:forEach items="${list}" var="boardVo" varStatus="status">
                    <tr>
                        <td>${pageMaker.totalCount - (status.index + 1) + 1}</td>
<%--                        <td>${status.index + 1}</td>&lt;%&ndash;  status.index 로 하면 0 부터 시작 , count 는 1 부터 시작    &ndash;%&gt;--%>
                        <td><a href="/crowdfunding/free/board/detail/?num=${pageMaker.totalCount - (status.index + 1) + 1}">${boardVo.title}</a></td>
                        <td>${boardVo.membershipTableUserId}</td>
                        <td>${boardVo.regdate}</td>
                        <td>${boardVo.viewCnt}</td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>

        <div style="text-align: right">
            <form action="" method="get">
                <input type="submit" value="글쓰기">
            </form>
        </div>

        <div class="w3-bar">
            <%--     prev       --%>
            <c:if test="${pageMaker.prev}">
                <a href="listPage?page=${pageMaker.startPage - 1}" class="w3-button">&laquo;</a>
            </c:if>
            <c:forEach begin="${pageMaker.startPage}" end="${pageMaker.endPage}" var="idx">
                <c:choose>
                    <c:when test="${pageMaker.criteria.page == idx}">
                        <b>${idx}</b>
                    </c:when>
                    <c:when test="${pageMaker.criteria.page != idx}">
                        <a href="listPage?page=${idx}" class="w3-button">${idx}</a>
                    </c:when>
                </c:choose>
            </c:forEach>

            <c:if test="${pageMaker.next && pageMaker.endPage > 0}">
                <a href="listPage?page=${pageMaker.endPage +1}">&raquo;</a>
            </c:if>
        </div>

    </main>
</body>
</html>