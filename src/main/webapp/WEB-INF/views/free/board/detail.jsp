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
                    <td>${data.membershipTableUserId}</td>
                    <th>조회수</th>
                    <td>${data.viewCnt}</td>
                </tr>
<%--                <tr>--%>
<%--                    <th>첨부파일</th>--%>
<%--                    <td colspan="3"></td>--%>
<%--                </tr>--%>
                <tr>
                    <td colspan="4">
                        <div>
                            <br>
                            ${data.content}
                        </div>
                        <br>
                        <div>
                            <a href="http://www.newlecture.com/resource/spring2.zip">
                                <b>
                                    <u><font size="5" color="#dd8a00">예제 다운로드하기</font>
                                    </u>
                                </b>
                            </a>
                        </div>
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
            <a class="btn btn-list" href="list.html">목록</a>
        </h2>
    </div>

    <div>
        <table>
            <tbody>
            <tr>
                <th>다음글</th>
                <td colspan="3"  class="text-align-left text-indent">다음글이 없습니다.</td>
            </tr>

            <tr>
                <th>이전글</th>
                <td colspan="3"  class="text-align-left text-indent"><a class="text-blue text-strong" href="">스프링 DI 예제 코드</a></td>
            </tr>
            </tbody>
        </table>
    </div>
</main>
</body>
</html>
