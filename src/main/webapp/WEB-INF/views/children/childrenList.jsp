<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Lista dzieci</title>
    <link href="<c:url value="../../css/style.css" />" rel="stylesheet">
</head>
<body>
<div class="containerList">
    <table class="table">
        <thead>
        <th>Imię</th>
        <th>Nazwisko</th>
        <th>Płeć</th>
        <th>Imiona rodziców</th>
        <th>Data urodzenia</th>
        <th>Adres</th>
        <th>Adres rodzica</th>
        <th>Numer kontaktowy</th>
        <th>Email rodzica</th>
        <th>Specjalne potrzeby</th>
        <th>Informacje dotyczące zdrowia</th>
        <th>Informacje dotyczące szczepień</th>
        <th>PESEL</th>
        <th>Zgoda</th>
        <th>Status płatności</th>
        <th>Edycja</th>
        </thead>
        <tbody>
        <c:forEach items="${children}" var="child">
            <tr>
                <td><c:out value="${child.firstName}"/></td>
                <td><c:out value="${child.lastName}"/></td>
                <td><c:out value="${child.sex}"/></td>
                <td>
                    <c:out value="${child.parentsName1}"/><br><br>
                    <c:out value="${child.parentsName2}"/><br>
                </td>
                <td><c:out value="${child.birthDate}"/></td>
                <td><c:out value="${child.address}"/></td>
                <td><c:out value="${child.parentsAddress}"/></td>
                <td><c:out value="${child.parentsPhoneNumber}"/></td>
                <td><c:out value="${child.parentsEmail}"/></td>
                <td><c:out value="${child.infoAboutNeeds}"/></td>
                <td><c:out value="${child.infoAboutHealth}"/></td>
                <td><c:out value="${child.infoAboutVaccination}"/></td>
                <td><c:out value="${child.pesel}"/></td>
                <td><c:out value="${child.agreement}"/></td>
                <td><c:out value="${child.paymentStatus}"/> </td>
                <td>
                    <form method="POST" action="${pageContext.request.contextPath}/child/edit">
                        <input name="id" value="${child.id}" hidden>
                        <button type="submit">Zmień</button>
                    </form>
                    <form method="POST" action="/child/delete">
                        <input name="id" value="${child.id}" hidden>
                        <button type="submit">Usuń</button>
                    </form>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <br>
    <form method="GET" action="/child/add">
        <button type="submit">Dodaj dziecko</button>
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
