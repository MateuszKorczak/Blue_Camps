<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Lista obozów</title>
    <link href="<c:url value="../../css/style.css" />" rel="stylesheet">
</head>
<body>
<div class="container">
    <table class="table">
        <thead>
        <th>Nazwa obozu</th>
        <th>Adres</th>
        <th>Data rozpoczęcia</th>
        <th>Data zakończenia</th>
        <th>Limit osób</th>
        <th>Dzieci</th>
        <th>Edycja</th>
        </thead>
        <tbody>
        <c:forEach items="${camps}" var="camp">
            <tr>
                <td><c:out value="${camp.campsName}"/></td>
                <td><c:out value="${camp.address}"/></td>
                <td><c:out value="${camp.startDate}"/></td>
                <td><c:out value="${camp.endDate}"/></td>
                <td><c:out value="${camp.personLimit}"/></td>
                <td>
                    <form method="POST" action="/camp/children">
                        <input name="id" value="${camp.id}" hidden>
                        <button type="submit">Pokaż dzieci</button>
                    </form>
                    <form method="POST" action="/camp/addChild">
                        <input name="id" value="${camp.id}" hidden>
                        <button type="submit">Dodaj dziecko</button>
                    </form>
                </td>
                <td>
                    <form method="POST" action="/camp/edit">
                        <input name="id" value="${camp.id}" hidden>
                        <button type="submit">Zmień</button>
                    </form>
                    <form method="POST" action="/camp/delete">
                        <input name="id" value="${camp.id}" hidden>
                        <button type="submit">Usuń</button>
                    </form>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <br>
    <form method="GET" action="/camp/add">
        <button type="submit">Dodaj nowy obóz</button>
    </form>
    <form method="GET" action="/camp/campList-by-date">
        <button type="submit">Pokaż obozy z przedziału czasu</button>
        <input type="date" name="startDate" value="${startDate}">
        <input type="date" name="endDate" value="${endDate}">
    </form>
    </form>
    <form action="/">
        <button type="submit">Wróć do strony głównej</button>
    </form>


    <form action="<c:url value="/logout"/>" method="post">
        <input class="fa fa-id-badge" type="submit" value="Wyloguj">
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
    </form>


</div>
</body>
</html>
