<%--
  Created by IntelliJ IDEA.
  User: seungjo
  Date: 11/21/23
  Time: 9:50 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>jsp bean action tag</title>
</head>
<body>
    <jsp:useBean id="user1" scope="request" class="com.nhnacademy.jsp.beans.User"/>
    <jsp:setProperty name="user1" property="name" param="userId"/>
    <jsp:setProperty name="user1" property="age" param="userAag"/>

    <p>my name is<jsp:getProperty name="user1" property="name"/>.</p>
    <p>i am<jsp:getProperty name="user1" property="age"/> years old.</p>
    <p>toString : <%=request.getAttribute("user1")%>
</p>
</body>
</html>