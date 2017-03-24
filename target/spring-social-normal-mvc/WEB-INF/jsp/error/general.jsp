<<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html xmlns:th="www.thymeleaf.org">
<head>
    <title></title>
</head>
<body>
<div class="page-header">
    <h1>Error</h1>
    <div th:replace="fragments/layout.html :: alert (type='danger', message=${errorMessage})">Error: Error</div>
</div>
<div>
    <p><spring:message code="text.homepage.greeting"/></p>
</div>
</body>
</html>
