<%--
  Created by IntelliJ IDEA.
  User: seungjo
  Date: 11/21/23
  Time: 10:45 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isErrorPage="true" %>
<html>
<head>
  <title>error page</title>
</head>
<body>
error name: <%= exception.getClass().getName() %> <br>
error message: <b><%= exception.getMessage() %></b>
</body>
</html>
