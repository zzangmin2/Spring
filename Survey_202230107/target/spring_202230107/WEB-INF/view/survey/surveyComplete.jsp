<%--
  Created by IntelliJ IDEA.
  User: kimjungmin
  Date: 2024/05/24
  Time: 12:04 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<html>
<head>
    <title>응답</title>
    <style>
        .label {
            font-weight: bold;
        }
        .value {
            margin-bottom: 10px;
        }
    </style>
</head>
<body>
<h1>응답</h1>
<p class="label">1 : <span class="value">${surveyData.q1}</span></p>
<p class="label">2 : <span class="value">${surveyData.q2}</span></p>
<p class="label">3 : <span class="value">${surveyData.q3}</span></p>
<p class="label">응답자 이름 : <span class="value">${surveyData.respondentName}</span></p>
<p class="label">응답자 나이 : <span class="value">${surveyData.respondentAge}</span></p>

<a href="/survey/surveyList">[응답 리스트 보기]</a>
</body>
</html>
