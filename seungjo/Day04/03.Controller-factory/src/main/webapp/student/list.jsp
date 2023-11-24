<%--
  Created by IntelliJ IDEA.
  User: seungjo
  Date: 11/22/23
  Time: 10:35 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="cfmt" uri="http://nhnacademy.com/cfmt" %>
<html>
<head>
    <link rel="stylesheet" href="/style.css"/>
    <title>student - list</title>
</head>
<body>
<h1>학생 리스트</h1>
<p><a href="<c:url value="/student/register.do"/>">학생(등록)</a></p>
<table>
    <thead>
    <tr>
        <th style="width: 20%">아이디</th>
        <th style="width: 15%">이름</th>
        <th style="width: 10%">성별</th>
        <th style="width: 20%">나이</th>
        <th style="width: 25%">cmd</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="student" items="${studentList}">
        <tr>
            <td>${student.id}</td>
            <td>${student.name}</td>
            <td>${student.gender}</td>
            <td>${student.age}</td>
            <td>
                <c:url var="view_link" value="/student/view.do" scope="request">
                    <c:param name="id" value="${student.id}" />
                </c:url>
                <a href="${view_link}">조회</a></td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
