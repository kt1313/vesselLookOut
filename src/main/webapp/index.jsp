<%--
  Created by IntelliJ IDEA.
  User: Dell
  Date: 2021-02-23
  Time: 15:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Vessel Look Out</title>
    <link rel="stylesheet" href="style.css">
</head>
<body>


<main>
    <header>
        <h1>Wyszukaj statek</h1>
    </header>
    <form action="" method="post" >
        <h3><p>Podaj nazwę i wybierz z listy dostępnych.</p></h3>
        <div><label for="vslname">Nazwa statku: </label>
            <input type="text" name="vslname" id="vslname">
        </div>
        <button>Wyszukaj!</button>
    </form>
<%--     <c:if test="${not empty listOfVesselsWithNameAndIMO}">--%>
<%--            <ul class="vessel-list">--%>
<%--                <c:forEach var="listOfVesselsItem" items="${listOfVesselsWithNameAndIMO}">--%>
<%--                    <li><c:out value="${listOfVesselsItem}"/></li>--%>
<%--                </c:forEach>--%>
<%--            </ul>--%>
<%--        </c:if>--%>
    <c:if test="${not empty listOfVesselsWithNamesAndIMO}">
        <ul class="message-list">
            <c:forEach var="message" items="${listOfVesselsWithNamesAndIMO}">
                <li><c:out value="${message}"/></li>
            </c:forEach>
        </ul>
    </c:if>
        <c:if test="${empty listOfVesselsWithNameAndIMO}">
            <p>Nie rozpocząłeś jeszcze wyszukiwania</p>
        </c:if>

</main>
</body>
</html>

