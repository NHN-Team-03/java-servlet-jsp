<%--
  Created by IntelliJ IDEA.
  User: jangjaehun
  Date: 11/22/23
  Time: 10:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>el 기본문법 - 연산자</title>
</head>
<body>
    <p>${ 66 + 24 } = 88</p>
    <p>${ 44 - 22 } = 22</p>
    <p>${ 11 * 2} = 22</p>
    <p>${ 22 / 2} = 11</p>
    <p>${ 22 mod 3 } = 1</p>
    <p>${ true && false} = false</p>
    <p>${ false and true } = false</p>
    <p>${ true || false } = true</p>
    <p>${ true or false } = true</p>
    <p>${ not false } = true</p>
    <p>${ !true } = false</p>
    <p>${ 123 == 123 } = true</p>
    <p>${ 123 eq 123 } = true</p>
    <p>${ 101 < 100 } = false</p>
    <p>${ 101 gt 100 } = false</p>
    <p>${ 101 != 100 } = true</p>
    <p>${ 20 > 10 ? "gt" : "lt" } = gt</p>
</body>
</html>
