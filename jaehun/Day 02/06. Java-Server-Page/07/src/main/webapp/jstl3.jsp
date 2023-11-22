<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>c:url, c:param - c:redirect</title>
</head>
<body>
    <c:url var="redirectUrl" value="hello.jsp">
        <c:param name="page" value="1"/>
        <c:param name="size" value="15"/>
    </c:url>

    <c:redirect url="${redirectUrl}"/>
</body>
</html>
