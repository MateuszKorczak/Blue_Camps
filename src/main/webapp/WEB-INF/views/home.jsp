<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Home Page</title>
    <link href="<c:url value="../../css/style.css" />" rel="stylesheet">
</head>

<body>
<div class="container">
    <h1>Witaj na stronie</h1>
    <h2>Co chcesz zrobić?</h2>
    <form  action="/camp/all">
        <button type="submit">Obozy</button>
    </form>
    <form action="/child/list">
        <button type="submit">Dzieci</button>
    </form>
</div>
</body>
</html>
