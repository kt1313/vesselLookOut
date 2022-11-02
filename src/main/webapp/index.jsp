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

<%--    //listuje statki o podobnej nazwie jesli wcisniety przycisk Search--%>
    <c:if test="${not empty listOfVesselsWithNamesAndIMO}">
        <form action="getVesselDetailsController" method="post">

            <p class="vsl-list">
                <p></p>
                <c:out value="Looking for ">vslname</c:out>
                <c:out value="${vslname}"/>
                <p></p>
                <c:forEach var="vsl" items="${listOfVesselsWithNamesAndIMO}">
                    <var i=0;></var>
                    <li><c:out value=""/>
                        <input type="radio" name="vslChosen" value="${vsl}">${vsl}
                    </li>
                </c:forEach>

                <button>Show details</button>
                 <div id="div1"></div>
            </ul>

    </c:if>
        </form>
    <p></p>

<%--    //listuje szczegóły wybranego statku--%>
    <c:if test="${not empty fullVslDescription}">
        <ul class="vsl-details">
            <p>
                <c:out value="Details of your vessel: " >vslname</c:out>
            <c:out value="${vslname}"/>
            </p>
            <c:forEach var="vslDetails" items="${fullVslDescription}" >

<%--                    <c:out value="Coordinates lat: "></c:out>--%>
                <p> <c:out value="${vslDetails}"></c:out></p>
            </c:forEach>
<%--            <c:forEach var="vslDetails" items="${fullVslDescription}" begin="3" end="3">--%>
<%--                    <c:out value="Coordinates long: "></c:out>--%>
<%--                    <c:out value="${vslDetails}"></c:out>--%>

<%--            </c:forEach>--%>
        </ul>
    </c:if>

</main>
</body>
</html>
