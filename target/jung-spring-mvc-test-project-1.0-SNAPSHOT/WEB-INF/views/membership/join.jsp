<%--
  Created by IntelliJ IDEA.
  User: 렁환이
  Date: 2021-01-10
  Time: 오후 6:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
    <script type="text/javascript" src="/resources/js/address.js"></script>
    <script type="text/javascript" src="/resources/js/passwordCheck.js"></script>
    <script type="text/javascript" src="/resources/js/isNullofJoin.js"></script>
</head>
<body>
    <h1>Join Membership Page</h1>
    <fieldset>
        <legend>회원가입</legend>
        <div>
            <form name="joinForm" action="/membership/join" method="post" onsubmit="return isNullofInputValues()">
                <div>
                    이름  <input type="text" name="userName" id="userName">
                </div>
                <div>
                    아이디  <input type="text" name="userId" id="userId">
                </div>
                <div>
                    비밀번호 <input type="password" name="userPassword" id="pw" onchange="isSamePasswordCheck()">
                </div>
                <div>
                    비밀번호 확인 <input type="password" name="checkUserPassword" id="pw2" onchange="isSamePasswordCheck()">&nbsp;<span id="same"></span>
                </div>

                <%--                --%>
                <div>
                    생년월일 <input type="text" name="userBirth" id="userBirth" placeholder="예) 19951024">
                </div>
                <div>
                    핸드폰 번호('-' 없이 입력해 주세요.)<input type="text" name="userPhone" id="userPhone" placeholder="예) 01068300772"><br>
                </div>
                <div>
                    이메일  <input type="email" name="userEmail" id="userEmail" placeholder="trustonlyyou@naver.com"><br>
                </div>
                <div>
                    <input type="text" name="userPostcode" id="postcode" placeholder="우편번호">
                </div>
                <div>
                    <input type="button" onclick="execDaumPostcode()" value="우편번호 찾기"><br>
                </div>
                <div>
                    <input type="text" name="userAddress" id="address" placeholder="주소" size="50"><br>
                    <input type="text" name="userDetailAddress" id="detailAddress" placeholder="상세주소">
                    <input type="text" name="userExtraAddress" id="extraAddress" placeholder="참고항목">
                </div>
                <div>
                    <input type="submit" value="완료">
                </div>
            </form>
        </div>
    </fieldset>
</body>
</html>
