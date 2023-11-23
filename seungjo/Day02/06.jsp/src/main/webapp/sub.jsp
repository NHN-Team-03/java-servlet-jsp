<%--
  Created by IntelliJ IDEA.
  User: seungjo
  Date: 11/21/23
  Time: 7:42 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <p>THIS IS SUB PAGE. TYPE IS <%= request.getParameter("type") %>.</p>

    <p> SUB : ID IS <%=request.getParameter("id")%></p>
</body>
</html>
