<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>학생-등록</title>
    <link rel="stylesheet" href="/style.css" />
    <meta charset="UTF-8" />
</head>

<body>
<c:choose>
    <c:when test="${empty student}">
        <c:set var="action" value="/student/register.do" />
    </c:when>
    <c:otherwise>
        <c:set var="action" value="/student/update.do" />
    </c:otherwise>
</c:choose>

<form method="post" action="${action}">
    <table>
        <tbody>
        <tr>
            <th>ID</th>
            <td><input type="text" name="id" value="${student.id}" ${empty student ? '' : 'readonly style="background-color: lightgray"'}  required /></td>
        </tr>
        <tr>
            <th>이름</th>
            <td><input type="text" name="name" value="${student.name}" required /></td>
        </tr>
        <tr>
            <th>성별</th>
            <td>
                <input type="radio" name="gender" value="M" ${student.gender eq 'M' ? 'checked' : '' } />남
                <input type="radio" name="gender" value="F" ${student.gender eq 'F' ? 'checked' : '' } />여
            </td>
        </tr>
        <tr>
            <th>나이</th>
            <td><input type="number" name="age" value="${student.age}" required /></td>
        </tr>
        </tbody>
    </table>
    <p>
        <button type="submit">
            <c:choose>
                <c:when test="${empty student}">
                    등록
                </c:when>
                <c:otherwise>
                    수정
                </c:otherwise>
            </c:choose>
        </button>
    </p>
</form>
</body>
</html>