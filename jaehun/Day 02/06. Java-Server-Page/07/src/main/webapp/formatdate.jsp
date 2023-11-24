<%@ page import="java.util.Date"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>format date</title>
</head>
<body>
    <c:set var="today" value="<%= new Date()%>"/>
    <p><fmt:formatDate value="${today}" type="date" dateStyle="short"/></p>
    <p><fmt:formatDate value="${today}" type="time" dateStyle="medium"/> </p>
    <p><fmt:formatDate value="${today}" type="both" dateStyle="long"/></p>
    <p><fmt:formatDate value="${today}" pattern="yyyy-MM-dd HH:mm:ss"/> </p>
</body>
</html>
