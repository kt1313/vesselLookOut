function showDetails() {
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

}