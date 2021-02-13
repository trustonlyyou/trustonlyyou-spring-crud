<%--
  Created by IntelliJ IDEA.
  User: 렁환이
  Date: 2021-02-12
  Time: 오후 5:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
    <title>MyPage</title>
</head>
<body>
    <div>
        <form:form modelAttribute="userInfo">
            회원 이름 : <form:input path="userName" readonly="true"/>
            <span>
                <form:button>이름 수정</form:button>
            </span>
        </form:form>
    </div>
    <div>
        <form:form modelAttribute="userInfo">
            아이디 : <form:input path="userId" readonly="true"/>
            <span>
                <form:button>아이디 수정</form:button>
            </span>
        </form:form>
    </div>
    <div>
        <form:form modelAttribute="userInfo" action="/membership/modifyPassword" method="get">
            비밀번호 : <form:password path="userPassword" readonly="true" showPassword="true"/>
            <span>
                <form:button>비밀번호 수정</form:button>
            </span>
        </form:form>
    </div>
    <div>
        <form:form modelAttribute="userInfo">
            핸드폰 번호 : <form:input path="userPhone" readonly="true"/>
            <span>
                <form:button>핸드폰 번호 수정</form:button>
            </span>
        </form:form>
    </div>
    <div>
        <form:form modelAttribute="userInfo">
            배송지 : <form:input path="userAddress" readonly="true"/>
            <span>
                <form:button>주소 수정</form:button>
            </span>
        </form:form>
    </div>

</body>
</html>
