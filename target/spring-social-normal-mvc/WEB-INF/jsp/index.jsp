<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title></title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/css/social-buttons-3.css"/>
</head>
<body>
<div class="page-header">
    <c:if test="${applicationScope.mess eq 't'}">
        <div class="alert alert-danger alert-dismissable">
            <button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>
            <spring:message text="Activations complete"/>
        </div>
    </c:if>
    <h1><spring:message code="label.homepage.title"/>
        <sec:authentication property="principal.firstName"/> <sec:authentication property="principal.lastName"/></h1>
</div>
<div>
    <p><spring:message code="text.homepage.greeting"/></p>
</div>

<sec:authorize access="isAuthenticated()">
    <c:forEach items="${lists}" var="list">
        ${list.ip} - ${list.signinTime}
        <br />
    </c:forEach>
</sec:authorize>
</body>
</html>