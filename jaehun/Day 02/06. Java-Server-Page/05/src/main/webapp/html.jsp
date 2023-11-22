<%@ page contentType="text/plain;charset=UTF-8" language="java" %>
<jsp:useBean id="htmlBeautifyer" scope="request" class="com.nhnacademy.jsp.HtmlBeautifier"/>
<jsp:setProperty name="htmlBeautifyer" property="html" param="html"/>
<jsp:getProperty name="htmlBeautifyer" property="html"/>