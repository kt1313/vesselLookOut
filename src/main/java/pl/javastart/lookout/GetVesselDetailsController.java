
package pl.javastart.lookout;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/getVesselDetails")
public class GetVesselDetailsController extends HttpServlet {


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
//tu należy otrzymac szczegoly vslNameAndIMO z buttona
        String vslNameAndIMO = request.getParameter("selectedValue");
        GetDetails.getVslDetails(vslNameAndIMO);

        response.sendRedirect(request.getContextPath());
    }
}


