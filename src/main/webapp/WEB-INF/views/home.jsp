<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<html>
<head>
    <title>Home Page</title>
    <link href="<c:url value="../../css/style.css" />" rel="stylesheet">
</head>

<body>
<div class="container">
    <h1>Witaj na stronie</h1>
    <h2>Co chcesz zrobić?</h2>
    <br>

    <sec:authorize access="hasRole('ADMIN')">
        MAM ROLE ADMIN
    <form action="/camp/all">
        <button type="submit">Obozy</button>
    </form>
    </sec:authorize>

    <form action="/child/list">
        <button type="submit">Dzieci</button>
    </form>
    <form action="/user/all">
        <button type="submit">Użytkownicy</button>
    </form>
</div>
</body>
</html>
