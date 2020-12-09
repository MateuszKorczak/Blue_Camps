<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<html>
<head>
    <title>Zalogowany</title>
    <link href="<c:url value="../../css/style.css" />" rel="stylesheet">
</head>

<body>
<div class="container">
    <h1>Witaj na stronie</h1>
    <br>
    <sec:authorize access="hasRole('ADMIN')">
        <p>Zalogowany jako: <sec:authentication property="username"/></p>
        <p>Posiada role: <sec:authentication property="authorities"/></p>

        <form action="/camp/all">
            <button type="submit">Pokaż widok obozów</button>
        </form>
        <form action="/child/list">
            <button type="submit">Pokaż listę dzieci</button>
        </form>
        <form action="/user/all">
            <button type="submit">Pokaż wszystkich użytkowników</button>
        </form>
    </sec:authorize>

    <div class="container">
        <h1>Moje dzieci</h1>
        <table class="table" border="1">
            <tr>
                <th>Imię</th>
                <th>Data urodzenia</th>
            </tr>
            DOKOŃCZ
            <c:forEach items="${user.children}" var="child">
                <tr>
                    <td>${child.firstName}</td>
                    <td>${child.birthDate}</td>
                    <td>${child.paymentStatus}"/></td>
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
        </table>
    </div>
    <form action="<c:url value="/logout"/>" method="post">
        <input class="fa fa-id-badge" type="submit" value="Wyloguj">
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
    </form>
</div>
</body>
</html>
