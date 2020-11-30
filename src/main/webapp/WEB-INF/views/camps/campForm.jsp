<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <title>Formularz obozu</title>
</head>
<body>
<h1>Dodawanie obozu</h1>
<form:form modelAttribute="camp" method="post" action="/camp/form">
    <form:hidden path="id"/>

    <form:label path="campsName">Rodzaj wypoczynku:</form:label>
    <form:input path="campsName"/>
    <form:errors path="campsName" cssClass="error"/><br>

    <form:label path="startDate">Data rozpoczęcia obozu:</form:label>
    <form:input type="date" path="startDate"/>
    <form:errors path="startDate" cssClass="error"/><br>

    <form:label path="endDate">Data zakończenia obozu:</form:label>
    <form:input type="date" path="endDate"/>
    <form:errors path="endDate" cssClass="error"/><br>

    <form:label path="address">Adres:</form:label>
    <form:input path="address"/>
    <form:errors path="address" cssClass="error"/><br>

    <form:label path="personLimit">Limit osób:</form:label>
    <form:input type="number" path="personLimit"/>
    <form:errors path="personLimit" cssClass="error"/><br>

    <button type="submit">Dodaj</button>
</form:form>
</body>
</html>
