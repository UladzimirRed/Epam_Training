<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>
<head>
    <fmt:setLocale value="${sessionScope.local}"/>
    <fmt:setBundle basename="locale.locale" var="locale"/>

    <fmt:message bundle="${locale}" key="locale.message.wrongCredentials" var="wrongCredentials"/>

    <fmt:message bundle="${locale}" key="locale.label.login" var="login"/>
    <fmt:message bundle="${locale}" key="locale.label.password" var="password"/>
    <fmt:message bundle="${locale}" key="locale.label.log_in" var="log_in"/>

    <title>Login</title>
</head>

<body>
<c:choose>
    <c:when test="${not empty sessionScope.user}">
        <jsp:forward page="/main"/>
    </c:when>
</c:choose>
<header>
    <jsp:include page="/jsp/header.jsp"/>
</header>
<form name="LoginForm" method="POST" action="controller">
    <input type="hidden" name="command" value="login"/>
    <span>${login}:</span>
    <input type="text"
           name="login"
           value=""/>
    <span>${password}:</span>
    <input type="password"
           name="password"
           value=""/>
    <br/>
    <br/>
    <input type="submit" value="${log_in}"/>
    <c:choose>
    <c:when test="${not empty requestScope.wrongData}">
        ${wrongCredentials}
    </c:when>
    </c:choose>
    <form/>
    <hr/>
</body>
</html>
