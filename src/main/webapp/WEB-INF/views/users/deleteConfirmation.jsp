<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Potwierdzenie usunięcia obozu</title>
    <link href="<c:url value="../../css/style.css" />" rel="stylesheet">
</head>

<body>
<div class="container">
    <h1>Czy na pewno chcesz usunąć tego użytkownika</h1>
    <form method="POST" action="/user/delete/confirmed">
        <input name="id" value="${id}" hidden>
        <button type="submit">Tak, na pewno!</button>
    </form>
    <form action="/user/all">
        <button type="submit">Nie, zabierz mnie stąd</button>
    </form>
</div>
</body>
</html>
