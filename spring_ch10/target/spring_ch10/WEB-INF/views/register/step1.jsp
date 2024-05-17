<%--
  Created by IntelliJ IDEA.
  User: kimjungmin
  Date: 2024/05/03
  Time: 11:23 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title><spring:message code="member.register"/></title>
</head>
<body>
<h2><spring:message code="term"/></h2>
<p>약관내용</p>
<form action="step2" method="post">
    <label>
        <input type="checkbox" name="agree" value="true"><spring:message code="term.agree"/>
    </label>
    <input type="submit" value="<spring:message code="next.btn"/>" />
</form>
</body>
</html>