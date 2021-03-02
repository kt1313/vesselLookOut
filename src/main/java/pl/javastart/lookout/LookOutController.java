package pl.javastart.lookout;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet
public class LookOutController extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //1. odbiera od uzytkownika nazwę statku
        String vslName = getVslName(request);
        //2. tworzy liste statkow z nr IMO - jestem tutaj(1/3/21)
        ListOfVessels.getVslsList(vslName);
        //
        response.sendRedirect(request.getContextPath());
    }

    private String getVslName(HttpServletRequest request) {
        String vslName = request.getParameter("vslname");
        return vslName;
    }


    //w wersjo probnej podaje tylko nazwe statku i nr IMO
    private Vessel createVessel(HttpServletRequest request) {
        String vslName = request.getParameter("vslname");
        Integer IMO = null;
        return new Vessel(vslName, IMO);
    }


}
