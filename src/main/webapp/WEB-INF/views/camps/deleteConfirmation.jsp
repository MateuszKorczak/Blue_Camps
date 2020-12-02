<%--
  Created by IntelliJ IDEA.
  User: mateusz
  Date: 02.12.2020
  Time: 19:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Usuń obóz</title>
    <link href="<c:url value="../../css/style.css" />" rel="stylesheet">
</head>

<body>
<div class="container">
    <form:form method="post" modelAttribute="camp" action="/camp/delete/${id}">
        <td>Czy na pewno chcesz usunąć ten obóz i wszystkich jego uczestników?</td>
        <br/>
        <form:hidden path="id"/><br/>
        Autor:
        <form:input readonly="true" path="campsName" id="campsName"/><br/>
        Isbn:
        <form:input readonly="true" path="address" id="address"/><br/>
        Wydawca:
        <form:input readonly="true" path="startDate" id="startDate"/><br/>
        Tytuł:
        <form:input readonly="true" path="endDate" id="endDate"/><br/>
        Gatunek:
        <form:input readonly="true" path="personLimit" id="personLimit"/><br/>

        <%--        lista dzieci--%>
        <a class="btn btn-primary" href="/camp/all" role="button">Anuluj</a>
        <input type="submit" class="btn btn-primary" value="Usuń Obóz">
    </form:form>
</div>
</body>
</html>
