<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: kimjungmin
  Date: 2024/05/03
  Time: 11:39 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>회원가입</title>
</head>
<body>
<h2>Step-2 회원 정보 입력</h2>
<form:form action="step3" method="post" modelAttribute="formData">
<%--<form action="step3" method="post">--%>
    <p>
        <label for="email">이메일: </label>
<%--        <input type="text" name="email" id="email" value="${formData.email}"/>--%>
        <form:input path="email" />
    </p>
    <p>
        <label for="name">이름: </label>
<%--        <input type="text" name="name" id="name" value="${formData.email}"/>--%>
        <form:input path="name" />
    </p>
    <p>
        <label for="password">비밀번호: </label>
        <input type="text" name="password" id="password" />
        <label for="confirmPassword">비밀번호 확인: </label>
        <input type="text" name="confirmPassword" id="confirmPassword" />
    </p>

    <input type="submit" value="가입 완료" />
</form:form>
</body>
</html>
