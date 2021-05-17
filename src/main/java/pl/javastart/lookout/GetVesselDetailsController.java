
package pl.javastart.lookout;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import javax.swing.text.Document;
import java.io.IOException;

@WebServlet("/getVesselDetailsController")
public class GetVesselDetailsController extends HttpServlet {


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //tu należy otrzymac szczegoly vslNameAndIMO po wcisnieciu Show Details

        System.out.println(request.getParameter("vslChosen"));
        GetDetails.getVslDetails(request.getParameter("vslChosen"));
    }

}


