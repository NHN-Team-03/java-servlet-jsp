<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>student - list</title>
    <link rel="stylesheet" href="style.css" />
</head>
<body>
    <h1>학생 리스트</h1>
    <p><a href="/student/register.do" >학생(등록)</a></p>
    <table>
        <thead>
            <tr>
                <th style="width: 28%">아이디</th>
                <th style="width: 27%">이름</th>
                <th style="width: 15%">성별</th>
                <th style="width: 15%">나이</th>
                <th style="width: 15%">cmd</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="item" items="${studentList}">
                <tr>
                    <td>${item.getId()}</td>
                    <td>${item.getName()}</td>
                    <td>${item.getGender()}</td>
                    <td>${item.getAge()}</td>
                    <td>
                        <c:url var="view_link" value="/student/view.do" scope="request">
                            <c:param name="id" value="${item.getId()}"/>
                        </c:url>
                        <a href="${view_link}">조회</a>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>

</body>
</html>
