<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page errorPage="error.jsp" %>
<html>
<head>
    <title>$Title$</title>
</head>
<body>
    name 파라미터 값 : <%= request.getParameter("userId").contains("jaehun") %>
</body>
</html>
