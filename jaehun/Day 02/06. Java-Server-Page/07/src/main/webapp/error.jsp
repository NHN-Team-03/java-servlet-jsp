<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isErrorPage="true" %>
<html>
<head>
    <title>error page</title>
</head>
<body>
    error name : <%= exception.getClass().getName() %> <br/>
    error message : <%= exception.getMessage() %> <br/>
</body>
</html>
