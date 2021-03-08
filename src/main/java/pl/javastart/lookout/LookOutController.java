package pl.javastart.lookout;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

@WebServlet("")
public class LookOutController extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
//        PROBA 8/3/21 utworzenia listy ze statkami do wyswietlenia na stronie
        //najpierw listę sama do konsoli
//        ListOfVessels.getVslsList(getVslName(request));
        createVesselsList(getVslName(request));
//        PROBA 7 marzec, przykladowa lista )(DZIALA)
//       createExampleList();
       response.sendRedirect(request.getContextPath());
    }

    private String getVslName(HttpServletRequest request) {
        String vslName = request.getParameter("vslname");
        return vslName;
    }

    private String getUserChoice() {
        Scanner sc = new Scanner(System.in);
        String userChoice = sc.nextLine();
        return userChoice;
    }

    private List<String> createVesselsList( String vslName) throws IOException {
        ServletContext context = getServletContext();
        List<String> listOfVesselsWithNamesAndIMO = (List<String>) context.getAttribute("listOfVesselsWithNamesAndIMO");
        listOfVesselsWithNamesAndIMO = ListOfVessels.getVslsList(vslName);
        context.setAttribute("listOfVesselsWithNamesAndIMO",listOfVesselsWithNamesAndIMO);
        System.out.println(listOfVesselsWithNamesAndIMO.get(1));
        System.out.println(context);
        return listOfVesselsWithNamesAndIMO;
    }

    //ta proba działała 8 marca
    private List<String> createExampleList(){
        ServletContext context =getServletContext();
        List<String> exampleList= (List<String>) context.getAttribute("exampleList");
        exampleList= Arrays.asList("Telford 1, IMO nr 12345", "Telford 2, IMO nr 54321", "Telford 3, IMO nr 98765");
        context.setAttribute("exampleList", exampleList);
        return exampleList;
    }
}
