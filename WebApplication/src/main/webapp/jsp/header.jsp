<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>

    <fmt:setLocale value="${sessionScope.local}"/>
    <fmt:setBundle basename="locale.locale" var="locale"/>

    <fmt:message bundle="${locale}" key="locale.lang.text.english" var="en"/>
    <fmt:message bundle="${locale}" key="locale.lang.text.russian" var="ru"/>
    <title>Title</title>
</head>
<body>
<form action="controller">
    <input type="hidden" name="command" value="locale"/>
    <input class="lang-button" type="submit" name="lang" value=${en}>
</form>
<form action="controller">
    <input type="hidden" name="command" value="locale"/>
    <input class="lang-button" type="submit" name="lang" value=${ru}>
</form>
</body>
</html>
