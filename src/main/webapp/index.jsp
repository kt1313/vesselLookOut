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
<form method="post" action="lookout">
    <main>
        <fieldset>
            <h1>Wyszukaj statek</h1>
            <h3><p>Podaj nazwę i wybierz z listy dostępnych.</p></h3>
            <form action="" method="post">
                <div><label for="vslname">Nazwa statku: </label>
                    <input type="text" name="vslname" id="vslname">
<%--                    <label for="vslcallsign">Podaj Callsign</label>--%>
<%--                    <input type="text" name="vslcallsign" id="vslcallsign">--%>
                </div>
                <button>Wyszukaj!</button>
            </form>
        </fieldset>
        <fieldset>
            <c:if test="${not empty vesselData}">
                <ul class="vessel-list">
                    <c:forEach var="vessel" items="${vesselData}">
                        <li><c:out value="${vessel}"/></li>
                    </c:forEach>
                </ul>
            </c:if>
            <c:if test="${empty vesselData}">
                <p>Nie rozpocząłeś jeszcze wyszukiwania</p>
            </c:if>

        </fieldset>
    </main>
</form>
</body>
</html>

