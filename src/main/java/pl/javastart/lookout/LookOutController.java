package pl.javastart.lookout;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

@WebServlet("")
public class LookOutController extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
//1. tworzy wybrana przez uzytkownika pelna nazwe statku
        String vslName = (ListOfVessels.getVslsList(getVslName(request)).getListOfVesselsNames().get(Integer.parseInt(getUserChoice())));
        Integer nrIMO = Integer.parseInt(ListOfVessels.getVslsList(getVslName(request)).getListOfVesselsIMOs().get(Integer.parseInt(getUserChoice())));
        String vslNameAndIMO = vslName + "-" + nrIMO.toString();
        //2. wyslac zadanie do strony vesselfinder z danymi: nazwa statku i nr IMO i utworzyc liste z danymi statku
       
        List<String> vslData = GetDetails.getVslDetails(vslNameAndIMO);
// przekierowujemy uzytkownika do str glownej
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
}
