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
    <title>Look Out - find your ship</title>
    <link rel="stylesheet" href="style.css">
</head>
<body>
<main>
    <header>
        <h1>Look for your vessel!</h1>
    </header>
    <form action="" method="post">
        <h3><p>Type a vessel name and choose from the list:</p></h3>
        <div><label for="vslname">Vessel Name: </label>
            <input type="text" name="vslname" id="vslname">
        </div>
        <button>Search!</button>
    </form>


    <c:if test="${not empty listOfVesselsWithNamesAndIMO}">
        <ul class="vsl-list">
            <p></p>
            <c:out value="vslname">vslname</c:out>
            <p></p>
            <c:forEach var="vsl" items="${listOfVesselsWithNamesAndIMO}">
                <var i=0;></var>
                <li><c:out value=""/>
                    <input type="radio" name="choice" value="vsl">"${vsl}"
                </li>

            </c:forEach>
            <p></p>
            <button type="button" id="btn">Show details</button>

        </ul>
    </c:if>
    <c:if test="${empty listOfVesselsWithNameAndIMO}">
        <p>Searching not started yet</p>
    </c:if>
    <c:if test="${not empty fullVslDescription}">
    <ul class ="vsl-details">

        </ul>
<%--    <script>--%>
<%--        function showVslDetails() {--%>
<%--            const btn = document.querySelector('#btn');--%>
<%--// obsluga click button--%>
<%--            btn.onclick = function () {--%>
<%--                const rbs = document.querySelectorAll('input[name="choice"]');--%>
<%--                let selectedValue;--%>
<%--                for (const rb of rbs) {--%>
<%--                    if (rb.checked) {--%>
<%--                        selectedValue = rb.value;--%>
<%--                        break;--%>
<%--                    }--%>
<%--                }--%>
<%--                alert(selectedValue);--%>
<%--                //         gameDetailsParagraph.textContent = `Opis gry: ${game.description}`;--%>
<%--            }--%>
<%--        }--%>
<%--    </script>--%>
    <%--    <input type="button" id="btn" value="Show Details">--%>

</main>
</body>
</html>

