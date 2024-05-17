<%--
  Created by IntelliJ IDEA.
  User: kimjungmin
  Date: 2024/05/03
  Time: 12:02 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
<head>
    <title>회원가입</title>
</head>
<body>
<h2>Step3 - 회원가입 완료</h2>
<p>
    <strong><spring:message code="register.done" arguments="${registerRequest.name}"/></strong>
</p>
<a href="<c:url value='/main'/>">[<spring:message code="go.main"/>]</a>
</body>
</html>
