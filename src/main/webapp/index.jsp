<%@ page import="pl.javastart.lookout.GetDetails" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Look Out - find your ship</title>
    <link rel="stylesheet" href="style.css">
</head>
<body>
<header>
    <h1>Look for your vessel!</h1>
</header>
<main>
    <form action="" method="post">
        <h3><p>Type a vessel name and choose from the list:</p></h3>
        <div><label for="vslname">Vessel Name: </label>
            <input type="text" name="vslname" id="vslname">
        </div>
        <button>Search!</button>
    </form>

    //listuje statki o podobnej nazwie jesli wcisniety przycisk Search
    <c:if test="${not empty listOfVesselsWithNamesAndIMO}">
        <form action="getVesselDetailsController" method="post">

            <ul class="vsl-list">
                <p></p>
                <c:out value="Looking for ">vslname</c:out>
                <p></p>
                <c:forEach var="vsl" items="${listOfVesselsWithNamesAndIMO}">
                    <var i=0;></var>
                    <li><c:out value=""/>
                        <input type="radio" name="vslChosen" value="${vsl}">${vsl}
                    </li>
                </c:forEach>

                <button>Show details</button>
                <div id="div"></div>
            </ul>
        </form>

    </c:if>
    <c:if test="${empty listOfVesselsWithNameAndIMO}">

        <p>Searching not started yet</p>
    </c:if>

    //listuje szczegóły wybranego statku
    <c:if test="${not empty fullVslDescription}">
        <%--        <form action="getVesselDetailsController" method="post">--%>
        <ul class="vsl-details">
            <var i=0;>
                <c:forEach var="vslDetails" items="${fullVslDescription}">
                    <c:if test="i===2||i===3"><c:out value="${vslDetails}"></c:out>
                    </c:if>
                    <var i=i+1></var>
                    <li>
                        <c:out value="Coordinates lat and lon: "></c:out>
                        <c:out  value="${vslDetails}"></c:out>

                    </li>
                </c:forEach>
            </var>
        </ul>
        <%--    </form>--%>
    </c:if>

</main>
</body>
</html>
