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
                        <td>${status.count}</td><%--  status.index 로 하면 0 부터 시작 , count 는 1 부터 시작    --%>
                        <td><a href="/crowdfunding/free/board/detail/?num=${boardVo.num}">${boardVo.title}</a></td>
                        <td>${boardVo.membershipTableUserId}</td>
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

        <div style="text-align: right">
            <form action="" method="get">
                <input type="submit" value="글쓰기">
            </form>
        </div>

        <div class="w3-bar">
            <a href="#" class="w3-button">&laquo;</a>
            <a href="#" class="w3-button">1</a>
            <a href="#" class="w3-button">2</a>
            <a href="#" class="w3-button">3</a>
            <a href="#" class="w3-button">4</a>
            <a href="#" class="w3-button">&raquo;&raquo;</a>
        </div>
    </main>



<%--        <div>--%>
<%--            <h3 class="hidden">현재 페이지</h3>--%>
<%--            <div><span>1</span> / 1 pages</div>--%>
<%--            <c:if test="${pageMaker.prev}">--%>
<%--                <li><a href="/crowdfunding/free/board/listPage?page${pageMaker.startPage - 1}"></a></li>--%>
<%--            </c:if>--%>
<%--        </div>--%>

<%--        <div>--%>
<%--            <c:forEach begin="${pageMaker.startPage}" end="${pageMaker.endPage}" var="index">--%>
<%--                <li>--%>
<%--                    <c:out value="${pageMaker.page == index?'class =active':''}" />--%>
<%--                    <a href="/crowdfunding/free/board/listPage?page${index}">${index}}</a>--%>
<%--                </li>--%>
<%--            </c:forEach>--%>
<%--        </div>--%>

<%--        <c:if test="${pageMaker.next && pageMaker.endPage > 0}">--%>
<%--            <li><a href="/crowdfunding/free/borad/listPage?page=${pageMaker.endPage + 1}">&raquo;</a></li>--%>
<%--        </c:if>--%>

<%--        <div>--%>
<%--            <form action="" method="get">--%>
<%--                <input type="submit" value="글쓰기">--%>
<%--            </form>--%>
<%--        </div>--%>
<%--    </main>--%>
</body>
</html>
