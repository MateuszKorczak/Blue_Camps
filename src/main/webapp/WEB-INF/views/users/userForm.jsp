<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Formularz użytkownika</title>
    <link href="<c:url value="../../css/style.css" />" rel="stylesheet">
</head>
<body>
<div class="container">
    <h1>Dodawanie użytkownika</h1>
    <form:form modelAttribute="user" method="post" action="/user/add">
        <form:hidden path="id"/>

        <form:label path="username">Nazwa użytkownika</form:label>
        <form:input path="username"/>
        <form:errors path="username" cssClass="error" element="div"/><br>

        <form:label path="password">Hasło:</form:label>
        <form:input type="password" path="password"/>
        <form:errors path="password" cssClass="error" element="div"/><br>

        <form:label path="firstName">Imię:</form:label>
        <form:input path="firstName"/>
        <form:errors path="firstName" cssClass="error" element="div"/><br>

        <form:label path="lastName">Nazwisko:</form:label>
        <form:input path="lastName"/>
        <form:errors path="lastName" cssClass="error" element="div"/><br>

        <form:label path="email">Email:</form:label>
        <form:input path="email"/>
        <form:errors path="email" cssClass="error" element="div"/><br>


        <button type="submit">Zapisz</button>
    </form:form>
</div>
</body>
</html>
