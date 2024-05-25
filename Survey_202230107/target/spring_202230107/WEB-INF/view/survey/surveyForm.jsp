<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" language="java" %>

<html>
<head>
    <title>설문조사</title>
    <style>
        .error {
            color: red;
        }
    </style>
</head>
<body>
<h1>설문조사</h1>
<form:form action="/survey/surveyForm" method="post" modelAttribute="surveyData">
    <p>
        <label>1. 당신의 희망 분야는?</label><br>
        <form:radiobutton path="q1" value="server" />서버개발자
        <form:radiobutton path="q1" value="front" />프론트개발자
        <form:radiobutton path="q1" value="fullstack"/>풀스택개발자
        <br /><form:errors path="q1" cssClass="error" />
    </p>

    <p>
        <label>2. 가장 많이 사용하는 개발 도구는?</label><br>
        <form:radiobutton path="q2" value="eclipse" />Eclipse
        <form:radiobutton path="q2" value="intellij" />intellij
        <form:radiobutton path="q2" value="vscode" />vscode
        <br /><form:errors path="q2" cssClass="error" />
    </p>

    <p>
        <label for="q3">3. 하고싶은 말</label><br>
        <form:input path="q3" />
        <br /><form:errors path="q3" cssClass="error" />
    </p>

    <p>
        <label for="respondentName">응답자 이름</label>
        <form:input path="respondentName" />
        <br /><form:errors path="respondentName" cssClass="error" />
    </p>

    <p>
        <label for="respondentAge">응답자 나이</label>
        <form:input path="respondentAge" />
        <br /><form:errors path="respondentAge" cssClass="error" />
    </p>

    <input type="submit" value="전송">
</form:form>
</body>
</html>
