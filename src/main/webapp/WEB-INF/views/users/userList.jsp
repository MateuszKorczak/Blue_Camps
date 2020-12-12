<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Lista użytkowników</title>
    <link href="<c:url value="../../css/style.css" />" rel="stylesheet">
</head>
<body>
<div class="container">
    <table class="table">
        <thead>
        <th>Login</th>
        <th>Imię</th>
        <th>Nazwisko</th>
        <th>Email</th>
        <th>Lista dzieci</th>
        <th>Edycja</th>
        </thead>
        <tbody>
        <c:forEach items="${users}" var="user">
            <tr>
                <td><c:out value="${user.username}"/></td>
                <td><c:out value="${user.firstName}"/></td>
                <td><c:out value="${user.lastName}"/></td>
                <td><c:out value="${user.email}"/></td>
                <td>
                    <form  action="/child/list">
<%--                        <input name="id" value="${camp.children}" hidden>--%>
                        <button type="submit">Pokaż listę dzieci</button>
                    </form>
                </td>
                <td>
                    <form method="POST" action="/user/edit">
                        <input name="id" value="${user.id}" hidden>
                        <button type="submit">Zmień</button>
                    </form>
                    <form method="POST" action="/user/delete">
                        <input name="id" value="${user.id}" hidden>
                        <button type="submit">Usuń</button>
                    </form>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <br>
    <form method="GET" action="/user/add">
        <button type="submit">Dodaj nowego użytkownika</button>
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