<%--
  Created by IntelliJ IDEA.
  User: kimjungmin
  Date: 2024/05/03
  Time: 12:02 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>회원가입</title>
</head>
<body>
<h2>Step3 - 회원가입 완료</h2>
<p>
    <strong>${formData.name}님</strong>
</p>
<p>
    <strong>회원가입을 완료했습니다</strong>
</p>
<a href="<c:url value="/main" />">[첫 화면으로 이동]</a>
</body>
</html>
