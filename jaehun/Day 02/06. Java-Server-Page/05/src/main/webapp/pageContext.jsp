<%--
  Created by IntelliJ IDEA.
  User: jangjaehun
  Date: 11/21/23
  Time: 22:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title> forward vs include </title>
</head>
<body>
<%
    String id = "jaehun";
%>
    <h1>THIS IS pageContext.jsp.</h1>
    <%
        String type = request.getParameter("type");
        if ("include".equals(type)) {
    %>
        <jsp:include page="sub.jsp">
            <jsp:param name="id" value="<%=id%>"/>
        </jsp:include>
    <%
        } else if ("forward".equals(type)){
    %>
        <jsp:forward page="sub.jsp">
            <jsp:param name="id" value="<%=id%>"/>
        </jsp:forward>
    <%
        } else {
            out.println("type parameter is needed.");
        }
    %>

    <p>
        pageContext : ID is <%=request.getParameter("id")%>
    </p>
</body>
</html>
