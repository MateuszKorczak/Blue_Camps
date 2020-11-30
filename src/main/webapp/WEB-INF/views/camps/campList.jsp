<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <title>Lista obozów</title>
</head>
<body>
<table border="1">
    <thead>
    <th>No.</th>
    <th>Nazwa obozu</th>
    <th>Data rozpoczęcia</th>
    <th>Data zakończenia</th>
    <th>Adres</th>
    <th>Limit osób</th>
    <th>Lista dzieci</th>
    </thead>
    <tbody>
    <c:forEach items="${camps}" var="camp">
        <tr>
            <td><c:out value="${camp.id}"/></td>
            <td><c:out value="${camp.campsName}"/></td>
            <td><c:out value="${camp.startDate}"/></td>
            <td><c:out value="${camp.endDate}"/></td>
            <td><c:out value="${camp.address}"/></td>
            <td><c:out value="${camp.personLimit}"/></td>
            <td><c:out value="${camp.children}"/></td>     // przerobić na link do osobnego widoku
            <td>
                <a class="btn btn-primary" href="/camp/update/${camp.id}" role="button">Edytuj</a>
                <a class="btn btn-primary" href="/camp/delete/${camp.id}" role="button">Usuń</a>
                <a class="btn btn-primary" href="/camp/show/${camp.id}" role="button">Pokaż</a>
            </td>
<%--            </td>--%>
        </tr>
    </c:forEach>
    </tbody>
</table>
<a class="btn btn-primary" href="/camp/form" role="button">Dodaj nowy obóz</a>
</body>
</html>
