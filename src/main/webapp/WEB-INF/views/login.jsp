<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<html>
<head>
    <title>Strona logowania</title>
    <link href="<c:url value="../../css/style.css" />" rel="stylesheet">
</head>
<body>
<div class="container">
    <h1>Zaloguj się</h1>
    <form method="post">
        <div><label> Nazwa użytkownika : <input type="text" name="username"/> </label></div>
        <div><label> Hasło: <input type="password" name="password"/> </label></div>
        <div><input type="submit" value="Zaloguj się"/></div>
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
    </form>
</div>
</body>
</html>
