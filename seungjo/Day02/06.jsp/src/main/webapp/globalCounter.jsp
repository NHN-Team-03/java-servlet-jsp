<%--
  Created by IntelliJ IDEA.
  User: seungjo
  Date: 11/21/23
  Time: 6:27 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>globalCounter</title>
</head>
<body>
<%!
    private long counter = 0L;

    private long increaseCounter() {
        return ++counter;
    }

    // redefine jspInit() method
    public void jspInit() {
        counter = 100L;
    }

%>

    <h1>counter:<%=increaseCounter()%></h1>
</body>
</html>
