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
        createVesselsList(getVslName(request));
        response.sendRedirect(request.getContextPath());
//        createVesselDetails(vslChosen(request));
    }

    private String getVslName(HttpServletRequest request) {
        String vslName = request.getParameter("vslname");
        return vslName;
    }

    private List<String> createVesselsList(String vslName) throws IOException {
        ServletContext context = getServletContext();
        List<String> listOfVesselsWithNamesAndIMO = (List<String>) context.getAttribute("listOfVesselsWithNamesAndIMO");
        listOfVesselsWithNamesAndIMO = ListOfVessels.getVslsList(vslName);
        context.setAttribute("listOfVesselsWithNamesAndIMO", listOfVesselsWithNamesAndIMO);
       // System.out.println(listOfVesselsWithNamesAndIMO.get(1));
       // System.out.println(context);
        return listOfVesselsWithNamesAndIMO;
    }


}
