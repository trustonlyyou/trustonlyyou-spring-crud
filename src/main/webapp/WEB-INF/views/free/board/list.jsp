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
                <c:forEach items="${boardVoList}" var="boardVo">
                    <tr>
                        <td>${boardVo.num}</td>
                        <td><a href="">${boardVo.title}</a></td>
                        <td>${boardVo.membershipTableUserId}}</td>
                        <td>${boardVo.regdate}</td>
                        <td>${boardVo.viewCnt}</td>
                    </tr>

                </c:forEach>
<%--                <tr>--%>
<%--                    <td>8</td>--%>
<%--                    <td><a href="detail.html">스프링 8강까지의 예제 코드</a></td>--%>
<%--                    <td>newlec</td>--%>
<%--                    <td>--%>
<%--                        2019-08-18--%>
<%--                    </td>--%>
<%--                    <td>146</td>--%>
<%--                </tr>--%>

<%--                <tr>--%>
<%--                    <td>7</td>--%>
<%--                    <td><a href="detail.html">스프링 DI 예제 코드</a></td>--%>
<%--                    <td>newlec</td>--%>
<%--                    <td>--%>
<%--                        2019-08-15--%>
<%--                    </td>--%>
<%--                    <td>131</td>--%>
<%--                </tr>--%>

<%--                <tr>--%>
<%--                    <td>6</td>--%>
<%--                    <td><a href="detail.html">뉴렉쌤 9월 초 국기과정 모집 안내</a></td>--%>
<%--                    <td>newlec</td>--%>
<%--                    <td>--%>
<%--                        2019-06-11--%>
<%--                    </td>--%>
<%--                    <td>517</td>--%>
<%--                </tr>--%>

<%--                <tr>--%>
<%--                    <td>5</td>--%>
<%--                    <td><a href="detail.html">뉴렉처 강의 수강 방식 안내</a></td>--%>
<%--                    <td>newlec</td>--%>
<%--                    <td>--%>
<%--                        2019-05-24--%>
<%--                    </td>--%>
<%--                    <td>448</td>--%>
<%--                </tr>--%>

<%--                <tr>--%>
<%--                    <td>4</td>--%>
<%--                    <td><a href="detail.html">자바 구조적인 프로그래밍 강의 예제 파일</a></td>--%>
<%--                    <td>newlec</td>--%>
<%--                    <td>--%>
<%--                        2019-04-24--%>
<%--                    </td>--%>
<%--                    <td>520</td>--%>
<%--                </tr>--%>
                </tbody>
            </table>
        </div>
        <div>
            <form action="" method="get">
                <input type="submit" value="글쓰기">
            </form>
        </div>
    </main>
</body>
</html>
