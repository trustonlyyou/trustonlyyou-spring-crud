<%--
  Created by IntelliJ IDEA.
  User: 렁환이
  Date: 2021-01-16
  Time: 오후 5:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Title</title>
    <script>
        var message = ${requestScope.get(message)};

        if (message != null) {
            alert(message);
        }

    </script>
</head>
<body>
    <section>
        <form action="/membership/loginPost" method="post">
            <fieldset>
                <legend>로그인</legend>
                <div style="height: 50px;"></div>
                <div style="height: 30px;">
                    <input type="text" placeholder="ID" name="userId" size="15">
                </div>
                <div style="height: 30px;">
                    <input type="password" placeholder="PASSWORD" name="userPassword" size="20">
                </div>

                <nav style="height: 30px;">
                    <a href="">FIND ID/PASSWORD</a>
                </nav>
                <nav style="height: 30px;">
                    <a href="">JOIN US</a>
                </nav>

                <input type="submit" value="Login">
            </fieldset>
        </form>
    </section>

</body>
</html>



