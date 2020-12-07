<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Formularz obozu</title>
    <link href="<c:url value="../../css/style.css" />" rel="stylesheet">
</head>
<body>
<div class="container">
    <h1>Dodawanie obozu</h1>
    <form:form modelAttribute="camp" method="post" action="/camp/add">
        <form:hidden path="id"/>

        <form:label path="campsName">Rodzaj wypoczynku:</form:label>
        <form:input path="campsName"/>
        <form:errors path="campsName" cssClass="error" element="div"/><br>

        <form:label path="startDate">Data rozpoczęcia obozu:</form:label>
        <form:input type="date" path="startDate"/>
        <form:errors path="startDate" cssClass="error" element="div"/><br>

        <form:label path="endDate">Data zakończenia obozu:</form:label>
        <form:input type="date" path="endDate"/>
        <form:errors path="endDate" cssClass="error" element="div"/><br>

        <form:label path="address">Adres:</form:label>
        <form:input path="address"/>
        <form:errors path="address" cssClass="error" element="div"/><br>

        <form:label path="personLimit">Limit osób:</form:label>
        <form:input type="number" path="personLimit"/>
        <form:errors path="personLimit" cssClass="error" element="div"/><br>
        <button type="submit">Zapisz</button>
    </form:form>
</div>
</body>
</html>
