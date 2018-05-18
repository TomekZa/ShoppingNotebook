<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<!DOCTYPE html>

<html>
<head>

    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/styles/css/style.css" />
    <title>Lista zakupów</title>
    <meta charset="utf-8">
</head>
<body>
<div class="container_all">
<div class="container">
<form class="form" method="post" accept-charset="utf-8" >
    <div class="form__group">
    <input class="form__input" type="text" name="dane"/>
        <input type="hidden" name="productId" value="productId" path="productId">

    </div>
    <input class="btn" type="submit" value="Dodaj do listy zakupów"/>
</form>
</div>
            <ol class="ol">
<c:if test="${not empty pobierzListe}">
    <c:forEach items="${pobierzListe}" var="listaProduktow">
    <div class="list_container_border">
        <div class="list_container">
        <li>${listaProduktow}</li>
        </div>
            <div class="edit_button" var="E">
                <a href="<c:url value='/lista/edit/${productId}'/>">E</a>
            </div>
            <div class="delete_button" var="X">
            </div>
    </c:forEach>
</c:if>
            </ol>
        </div>
</div>
</body>
</html>
