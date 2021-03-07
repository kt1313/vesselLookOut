package pl.javastart.lookout;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@WebServlet("")
public class LookOutController extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //PROBA 5/3/21 utworzenia listy ze statkami do wyswietlenia na stronie
//        List<String> listOfVessels=ListOfVessels.getVslsList(getVslName(request));
//        createVesselsList(listOfVessels);
        //PROBA 7 marzec, przykladowa lista
        ListOfVessels.exampleList();

////1. tworzy wybrana przez uzytkownika pelna nazwe statku
//        String vslName = ListOfVessels.getVslsList(getVslName(request)).getListOfVesselsNames().get(Integer.parseInt(getUserChoice()));
//        Integer nrIMO = Integer.parseInt(ListOfVessels.getVslsList(getVslName(request)).getListOfVesselsIMOs().get(Integer.parseInt(getUserChoice())));
//        String vslNameAndIMO = vslName + "-" + nrIMO.toString();
//        //2. wyslac zadanie do strony vesselfinder z danymi: nazwa statku i nr IMO i utworzyc liste z danymi statku
//
//        List<String> vslData = GetDetails.getVslDetails(vslNameAndIMO);
//// przekierowujemy uzytkownika do str glownej
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
    private void createVesselsList(List<String> lisOfVesselsWithNamesAndIMO){
        ServletContext context=getServletContext();
//      //  lisOfVesselsWithNamesAndIMO
                context.setAttribute("listOfVesselsWithNamesAndIMO", lisOfVesselsWithNamesAndIMO);
    }
//    private void saveMessageInHistory(Message message, HttpServletRequest request) {
//        ServletContext context = getServletContext();
//        List<Message> messageHistory = (List<Message>) context.getAttribute("messageHistory");
//        if (messageHistory == null) {
//            messageHistory = new ArrayList<>();
//        }
//        messageHistory.add(message);
//        context.setAttribute("messageHistory", messageHistory);
//    }
}
