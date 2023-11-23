<%@ page contentType="text/html;charset=UTF-8" language="java" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="cfmt" uri="http://nhnacademy.com/cfmt" %>
<html>
<head>
    <title>학생-조회</title>
    <link rel="stylesheet" href="style.css" />
</head>
<body>
<table>
    <tbody>
    <!-- todo view 구현 -->
        <tr>
            <th>아이디</th>
            <td>${student.getId()}</td>
        </tr>
        <tr>
            <th>이름</th>
            <td>${student.getName()}</td>
        </tr>
        <tr>
            <th>성별</th>
            <td>${student.getGender()}</td>
        </tr>
        <tr>
            <th>나이</th>
            <td>${student.getAge()}</td>
        </tr>
        <tr>
            <th>등록일</th>
            <td>${cfmt:formatDate(student.getCreatedAt(), 'yyyy-MM-dd HH:mm:ss')}</td>
        </tr>
    </tbody>
</table>
<ul>
    <li><a href="/student/list.do">리스트</a></li>
    <li>
        <!-- todo ${update_link} 설정 c:url -->
        <c:url var="update_link" value="/student/update.do">
            <c:param name="id" value="${student.getId()}"/>
        </c:url>
        <a href="${update_link}">수정</a>
    </li>
    <li>
        <!-- todo 삭제버튼 구현, method=post -->
<%--        <form method="post" action="/student/delete?id=${student.getId()}">--%>
<%--            <button type="submit">삭제</button>--%>
<%--        </form>--%>
        <form method="post" action="/student/delete.do">
            <input type="hidden" name="id" value="${student.getId()}" />
            <button type="submit">삭제</button>
        </form>
     </li>

 </ul>

</body>
</html>
