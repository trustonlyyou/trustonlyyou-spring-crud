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
                  <c:if test="${sessionScope.userId == null}">
                      <li>로그인 해주세요.</li>
                      <li><a href="/membership/login">로그인</a></li>
                      <li><a href="/membership/joinPage">회원가입</a></li>
                      <li><a href="/membership/joinTest">javascript test Page</a></li>
                  </c:if>

                  <c:if test="${sessionScope.userId} != null">
                      <li><a href="">MyPage</a></li>
                      <li><input type="button" onclick="location.href='/membership/logout'">LogOut</li>
                  </c:if>
              </ul>
          </nav>
      </header>



      <!-- Main -->
      <main>
          <nav>
              <ul>
                  <li><a href=""></a>CROWD FUNDING</li>
                  <li><a href=""></a>이용안내</li>
                  <li><a href=""></a>진행중인 펀딩</li>
                  <li><a href=""></a>진행완료 펀딩</li>
                  <li><a href=""></a>삽니다.</li>
                  <li><a href=""></a>팝니다.</li>
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
