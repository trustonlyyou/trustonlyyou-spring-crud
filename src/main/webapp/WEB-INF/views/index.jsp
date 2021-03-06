<%--
  Created by IntelliJ IDEA.
  User: 렁환이
  Date: 2021-01-09
  Time: 오후 6:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
  <head>
    <title>CrowdFunding</title>
  </head>
  <body>
      <!-- header -->
      <header>
          <nav>
              <ul>
                  <c:if test="${sessionScope.userInfo == null}">
                      <li>로그인 해주세요.</li>
                      <li><a href="/membership/login">로그인</a></li>
                      <li><a href="/membership/join">회원가입</a></li>
                  </c:if>

                  <c:if test="${sessionScope.userInfo != null}">
                      <li>환영합니다. ${sessionScope.userInfo.userId} 님</li>
                      <li><a href="/membership/mypage">MyPage</a></li>
                      <li><input type="button" value="LogOut" onclick="location.href='/membership/logout'"></li>
                  </c:if>
              </ul>
          </nav>
      </header>

      <hr>

      <!-- Main -->
      <main>
          <nav>
              <ul>
                  <li><a href="/crowdfunding/free/board/listPage">자유게시판</a></li>
                  <li><a href="/after">감상평...</a> </li>
              </ul>
          </nav>
      </main>

      <!-- footer -->
      <footer>
          <section>
              <h1>저작권</h1>
              <div>
                  Copyright ⓒ crowdfunding.com 2021 All Right Reserved.
              </div>
          </section>
      </footer>
  </body>
</html>
