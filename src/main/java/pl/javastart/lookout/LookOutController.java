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
//16 marca proba obslugi przycisku "Show details"
        // sprawdza czy przycisniety isButtonClicked
         
//        String vslNameAndIMO = request.getParameter("selectedValue");
//        GetDetails.getVslDetails(vslNameAndIMO);

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


}
