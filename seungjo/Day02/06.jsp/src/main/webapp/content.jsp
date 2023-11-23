<%--
  Created by IntelliJ IDEA.
  User: seungjo
  Date: 11/21/23
  Time: 10:45 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" trimDirectiveWhitespaces="true" %>
<%@ page errorPage="./error.jsp" %>
<html>
<head>
  <title>error page 테스트</title>
</head>
<body>
  name 파라미터 값: <%= request.getParameter("userId").contains("marco") %>
</body>
</html>
