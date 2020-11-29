<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <title>Camp list</title>
</head>
<body>
<table border="1">
    <thead>
    <th>No.</th>
    <th>Nazwa obozu</th>
    <th>Data rozpoczecia</th>
    <th>Data zakończenia</th>
    <th>adres</th>
    </thead>
    <tbody>
    <c:forEach items="${camps}" var="camp">
        <tr>
            <td><c:out value="${camps.id}"/></td>
            <td><c:out value="${camps.campsName}"/></td>
            <td><c:out value="${camps.startDate}"/></td>
            <td><c:out value="${camps.endDate}"/></td>
            <td><c:out value="${camps.address}"/></td>
            <td>
                <a class="btn btn-primary" href="/admin/books/update/${camps.id}" role="button">Edytuj</a>
                <a class="btn btn-primary" href="/admin/books/delete/${camps.id}" role="button">Usuń</a>
                <a class="btn btn-primary" href="/admin/books/show/${camps.id}" role="button">Pokaż</a>
            </td>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<a class="btn btn-primary" href="/admin/books/create" role="button">Dodaj nową książkę</a>
</body>
</html>
