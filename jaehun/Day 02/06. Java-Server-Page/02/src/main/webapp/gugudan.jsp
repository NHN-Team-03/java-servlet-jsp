<%--
  Created by IntelliJ IDEA.
  User: jangjaehun
  Date: 11/21/23
  Time: 21:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>gugudan</title>
</head>
<body>
<%
    for(int i = 2; i < 10; i++) {
%>
<!-- <%= i%>단 시작 html comment -->
<%-- <%= i %>단 시작 Scriptlet comment --%>
    <h1><%=i%>단</h1>
<%
    for(int j = 1; j < 10; j++) {
%>

    <p>
        <%=i%>*<%=j%>=<%=i*j%>
    </p>
<%
        }
    }
%>

</body>
</html>
