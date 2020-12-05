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
        <th>Lista dzieci</th>
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
                    <form  action="/child/list">
<%--                        <input name="id" value="${camp.children}" hidden>--%>
                        <button type="submit">Pokaż listę dzieci</button>
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
    <form method="GET" action="/camp/add">
        <button type="submit">Dodaj nowy obóz</button>
    </form>
    </form>
    <form action="/">
        <button type="submit">Wróć do strony głównej</button>
    </form>
</div>
</body>
</html>
