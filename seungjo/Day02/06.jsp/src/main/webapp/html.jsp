<%--
  Created by IntelliJ IDEA.
  User: seungjo
  Date: 11/21/23
  Time: 10:04 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/plain;charset=UTF-8" language="java" trimDirectiveWhitespaces="true" %>
  <jsp:useBean id="html" scope="application" class="com.nhnacademy.jsp.beans.HtmlBeautifier"/>
  <jsp:setProperty name="html" property="html" param="html" />
  <jsp:getProperty name="html" property="html"/>