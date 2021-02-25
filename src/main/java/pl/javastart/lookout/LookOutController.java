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
       request.getRequestDispatcher("index.jsp").forward(request,response);
   }

   @Override
   protected void doPost(HttpServletRequest request, HttpServletResponse response){
       Vessel vessel=createVessel(request);
   }
  private Vessel createVessel(HttpServletRequest request){
       String vslName=;
       String vslCallSign=;
       Integer MMSI=;
       Integer IMO=;
       
       return new Vessel(vslName,vslCallSign, MMSI,IMO)
  }



}
