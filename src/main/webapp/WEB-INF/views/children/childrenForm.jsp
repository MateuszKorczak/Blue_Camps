<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="obozu" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Formularz obozu</title>
    <link href="<c:url value="../../css/style.css" />" rel="stylesheet">
</head>
<body>
<div class="container">
    <h1>Dodawanie obozowicza</h1>
    <form:form modelAttribute="child" method="post" action="/child/add">
        <form:hidden path="id"/>

        <form:label path="firstName">Imię:</form:label>
        <form:input path="firstName"/>
        <form:errors path="firstName" cssClass="error"/><br>

        <form:label path="lastName">Nazwisko:</form:label>
        <form:input path="lastName"/>
        <form:errors path="lastName" cssClass="error"/><br>

        <form:label path="sex">Płeć:</form:label><br>
        <form:label path="sex">Chłopak:</form:label>
        <form:radiobutton path="sex" value="M"/>
        <form:label path="sex">Dziewczyna:</form:label>
        <form:radiobutton path="sex" value="K"/>
        <form:errors path="sex" cssClass="error"/><br>

        <form:label path="parentsName1">Imię rodzica:</form:label>
        <form:input path="parentsName1"/>
        <form:errors path="parentsName1" cssClass="error"/><br>

        <form:label path="parentsName2">Imię rodzica:</form:label>
        <form:input path="parentsName2"/>
        <form:errors path="parentsName2" cssClass="error"/><br>

        <form:label path="birthDate">Data urodzenia:</form:label>
        <form:input type="date" path="birthDate"/>
        <form:errors path="birthDate" cssClass="error"/><br>

        <form:label path="address">Adres:</form:label>
        <form:input path="address"/>
        <form:errors path="address" cssClass="error"/><br>

        <form:label path="parentsAddress">Adres rodzica:</form:label>
        <form:input path="parentsAddress"/>
        <form:errors path="parentsAddress" cssClass="error"/><br>

        <form:label path="parentsPhoneNumber">Telefon kontaktowy rodzica:</form:label>
        <form:input type="tel" path="parentsPhoneNumber" placeholder="123-456-789"/>
        <form:errors path="parentsPhoneNumber" cssClass="error"/><br>

        <form:label path="parentsEmail">Email rodzica:</form:label>
        <form:input type="email" path="parentsEmail" placeholder="email@domena.pl"/>
        <form:errors path="parentsEmail" cssClass="error"/><br>

        <form:label path="infoAboutNeeds">Potrzeby:</form:label>
        <form:textarea path="infoAboutNeeds" rows="3"
                       cols="20"/>
        <form:errors path="infoAboutNeeds" cssClass="error"/><br>

        <form:label path="infoAboutHealth">Informacje dotyczące zdrowia:</form:label>
        <form:textarea path="infoAboutHealth" rows="3"
                       cols="20"/>
        <form:errors path="infoAboutHealth" cssClass="error"/><br>

        <form:label path="infoAboutVaccination">Informacje dotyczące szczepień:</form:label>
        <form:textarea path="infoAboutVaccination" rows="3"
                       cols="20"/>
        <form:errors path="infoAboutVaccination" cssClass="error"/><br>

        <form:label path="pesel">PESEL:</form:label>
        <form:input path="pesel"/>
        <form:errors path="pesel" cssClass="error"/><br>

        <form:label path="agreement">Zgoda:</form:label>
        <form:checkbox path="agreement" />
        <form:errors path="agreement" cssClass="error"/><br>

        <form:label path="paymentStatus">Status płatności:</form:label>
        <form:input path="paymentStatus"/>
        <form:errors path="paymentStatus" cssClass="error"/><br>

        <button type="submit">Zapisz</button>
    </form:form>
</div>
</body>
</html>
