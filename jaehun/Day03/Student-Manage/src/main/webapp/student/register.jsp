<%@ page import="com.nhnacademy.student.student.Gender" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>student manager</title>

    <link rel="stylesheet" href="style.css" />
</head>
<body>
<h1>
<c:choose>
        <c:when test="${empty student}">
            학생-등록
            <c:set var="action" value="/student/register.do"/>
        </c:when>
        <c:otherwise>
            학생-수정
            <c:set var="action" value="/student/update.do"/>
        </c:otherwise>
</c:choose>
</h1>
<form method="post" action="${action}">
    <table>
        <tbody>
            <tr>
                <th>ID</th>
                <td><input type="text" name="id" value="${student.getId()}" ${empty student ? '' : 'readonly'} required}></td>
            </tr>
            <tr>
                <th>이름</th>
                <td><input type="text" name="name" value="${student.getName()}" required></td>
            </tr>
            <tr>
                <th>성별</th>
                <td>
<%--                    <c:choose>--%>
<%--                        <c:when test="${student.getGender() eq 'M'}}">--%>
<%--                            <input type="radio" name="gender" value="M" checked required>M--%>
<%--                            <input type="radio" name="gender" value="F">F--%>
<%--                        </c:when>--%>
<%--                        <c:when test="${student.getGender() eq 'F'}">--%>
<%--                            <input type="radio" name="gender" value="M">M--%>
<%--                            <input type="radio" name="gender" value="F" checked required>F--%>
<%--                        </c:when>--%>
<%--                        <c:otherwise>--%>
<%--                            <input type="radio" name="gender" value="M">M--%>
<%--                            <input type="radio" name="gender" value="F">F--%>
<%--                        </c:otherwise>--%>
<%--                    </c:choose>--%>
                    <input type="radio" name="gender" value="M" ${student.getGender() eq 'M' ? 'checked' : ''} />M
                    <input type="radio" name="gender" value="F" ${student.getGender() eq 'F' ? 'checked' : ''} />F
                </td>
            </tr>
            <tr>
                <th>나이</th>
                <td><input type="number" name="age" value="${student.getAge()}" required></td>
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
