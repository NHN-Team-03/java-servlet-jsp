<%--
  Created by IntelliJ IDEA.
  User: seungjo
  Date: 11/21/23
  Time: 6:41 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>구구단</title>
</head>
<body>
<%
    for (int i = 2; i <= 9; i++) {
%>

<%
        for(int j = 1; j <= 9; j++) {
%>

    <p>
        <%=i%> * <%=j%> = <%=i * j%>
    </p>
<%
        }
    }
%>
</body>
</html>
