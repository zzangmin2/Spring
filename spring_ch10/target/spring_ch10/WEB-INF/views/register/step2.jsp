<%--
  Created by IntelliJ IDEA.
  User: kimjungmin
  Date: 2024/05/03
  Time: 11:39 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>회원가입</title>
</head>
<body>
<h2>Step-2 <spring:message code="member.info"/></h2>
<form:form action="step3" method="post" modelAttribute="formData">
<%--<form action="step3" method="post">--%>
    <p>
        <label for="email"><spring:message code="email"/>: </label>
<%--        <input type="text" name="email" id="email" value="${formData.email}"/>--%>
        <form:input path="email" />
        <form:errors path="email" />

    </p>
    <p>
        <label for="name"><spring:message code="name"/>: </label>
<%--        <input type="text" name="name" id="name" value="${formData.email}"/>--%>
        <form:input path="name" />
        <form:errors path="name" />

    </p>
    <p>
        <label for="password"><spring:message code="password"/>: </label>
        <form:password path="password" />
        <form:errors path="password" />
    </p>

    <p>
        <label for="confirmPassword"><spring:message code="password.confirm"/>: </label>
        <form:password path="confirmPassword" />
        <form:errors path="confirmPassword" />

    </p>

    <input type="submit" value="<spring:message code="register.btn"/>" />
</form:form>
</body>
</html>
