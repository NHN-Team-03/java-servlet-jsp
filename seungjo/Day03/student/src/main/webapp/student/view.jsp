<%--
  Created by IntelliJ IDEA.
  User: seungjo
  Date: 11/22/23
  Time: 2:31 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="cfmt" uri="http://nhnacademy.com/cfmt" %>
<html>
<head>
    <link rel="stylesheet" href="/style.css"/>
    <title>student - view</title>
</head>
<body>
<h1>학생 - 조회</h1>

<table>
    <tbody>
    <tr>
        <td>아이디</td>
        <td>${student.id}</td>
    </tr>
    <tr>
        <td>이름</td>
        <td>${student.name}</td>
    </tr>
    <tr>
        <td>성별</td>
        <td>${student.gender}</td>
    </tr>
    <tr>
        <td>나이</td>
        <td>${student.age}</td>
    </tr>
    <tr>
        <td>등록일</td>
        <td>${cfmt:formatDate(student.createdAt, 'yyyy-MM-dd HH:mm:ss')}</td>
    </tr>
    </tbody>
</table>

<br>
<ul>
    <li><a href="/student/list.do">리스트</a></li>
    <li>
        <c:url var="update_link" value="/student/update.do">
            <c:param name="id" value="${student.id}"/>
        </c:url>
        <a href="${update_link}">수정</a>
    </li>
    <li>
        <form method="post" action="/student/delete.do">
            <input type="hidden" name="id" value="${student.id}"/>
            <button type="submit">삭제</button>
        </form>
    </li>

</ul>
</body>
</html>
