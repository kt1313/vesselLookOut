<%@ page import="pl.javastart.lookout.GetDetails" %><%--
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
    <script type="text/javascript" src="${pageContext.request.contextPath}script.js"></script>
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


    <c:if test="${not empty listOfVesselsWithNamesAndIMO}">
        <ul class="vsl-list">
            <p></p>
            <c:out value="Looking for ">vslname</c:out>
            <p></p>
            <c:forEach var="vsl" items="${listOfVesselsWithNamesAndIMO}">
                <var i=0;></var>
                <li><c:out value=""/>
                    <input type="radio" name="choice" value="vsl">"${vsl}"
                </li>

            </c:forEach>
            <p></p>
            <button onclick="showDetails()" id="btn">Show details</button>
            <button onclick="f_pokaz()">Pokaz</button><button onclick="f_ukryj()">Ukryj</button>
            <div id="div"></div>
        </ul>
    </c:if>

    <c:if test="${empty listOfVesselsWithNameAndIMO}">
        <p>Searching not started yet</p>
    </c:if>
    <p id="demo"></p>
</main>
</body>
</html>
<script>function showDetails() {
//     <%
// GetDetails test=new GetDetails();
// test.testMethod2();
// %>
    // GetDetails test=new GetDetails();
    var str =test.testMethod2();
    //
    // document.getElementById("demo").innerHTML = "testestest";
    // var str = "The best things in life are free";
    // var patt = new RegExp("f");
    // var res = patt.test(str);
    // document.getElementById("demo").innerHTML = res;
    document.getElementById("demo").innerHTML = str;

    var temporaryList = [];
    temporaryList = document.getElementById(fullVslDescription);
    if (temporaryList != null) {
        for (var i = 0; i <= temporaryList.length; i++) ;
        document.getElementById("demo").innerHTML = temporaryList[i];
    }

}</script>
<script>
    function f_pokaz(){
        var sText="stststststs"
        document.getElementById("div").innerHTML=sText;
    }
    function f_ukryj(){
        oDivWithInput.innerHTML='';
    }
</script>